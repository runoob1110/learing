package com.pan.docker.secret.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/9/4 10:49
 */
public class DockerSecretProcessor implements EnvironmentPostProcessor {
    /**
     * 系统环境变量中，通过docker secrets中读取的参数的前缀
     *  如：从docker secrets中读取到的参数为：token，那么在系统环境变量中的key为：docker-secret-token
     */
    private static final String DOCKER_SECRET_VARIABLE_PREFIX = "docker-secret-";
    // openatc token
    public static final String DOCKER_SECRET_OPENATC_TOKEN_FILE = "OPENATC_TOKEN_FILE";
    public static final Map<String,String> DOCKER_SECRET_MAP = new HashMap<>();
    /**
     * 支持通过docker-secret设置值的参数列表
     */
    private static Set<String> supportDockerSecretList;
    static {
        supportDockerSecretList = new HashSet<>(1);
        supportDockerSecretList.add(DOCKER_SECRET_OPENATC_TOKEN_FILE);

        DOCKER_SECRET_MAP.put(DOCKER_SECRET_OPENATC_TOKEN_FILE,"docker-secret-openatc-token");
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // spring boot 支持docker-secret的思路
        // 1、在application.properties中配置支持的参数列表
        // 2、读取环境变量，加载设置了值的参数
        // 3、将读取到的值，放入到environment中
        // 4、在需要使用的地方，使用@Value注解，获取值d

        for (String param : supportDockerSecretList) {
            String paramValue = environment.getProperty(param);
            if (paramValue == null) {
                continue;
            }
            String bindPathPpty = paramValue.substring(0,paramValue.lastIndexOf("/"));
            String envKey = DOCKER_SECRET_MAP.get(param);
            if (bindPathPpty != null) {
                Path bindPath = Paths.get(bindPathPpty);
                if (Files.isDirectory(bindPath)) {
                    Map<String,Object> dockerSecrets;
                    try {
                        dockerSecrets =
                                Files.list(bindPath)
                                        .collect(
                                                Collectors.toMap(
                                                        path -> {
//                                                            File secretFile = path.toFile();
                                                            return envKey;
                                                        },
                                                        path -> {
                                                            File secretFile = path.toFile();
                                                            try {
                                                                byte[] content = FileCopyUtils.copyToByteArray(secretFile);
                                                                return new String(content);
                                                            } catch (IOException e) {
                                                                throw new RuntimeException(e);
                                                            }
                                                        }
                                                ));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    dockerSecrets
                            .entrySet()
                            .forEach(entry -> {
                                System.out.println(entry.getKey()+"=\""+entry.getValue()+"\"");
                            });

                    MapPropertySource pptySource = new MapPropertySource("docker-secrets",dockerSecrets);

                    environment.getPropertySources().addLast(pptySource);



                }
            }
        }

    }
}
