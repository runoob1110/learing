package com.pan;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/25 15:54
 */
public class MyProducer {
    public static void main(String[] args) {
        // 定义配置信息
        Properties prop = new Properties();
        // kafka地址，多个地址用逗号分割  "192.168.23.76:9092,192.168.23.77:9092"
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.74.157:9092");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        prop.put(ProducerConfig.CLIENT_ID_CONFIG,"producer.client.id.demo8");
        ConfigDef configDef = ProducerConfig.configDef();

        KafkaProducer<String,String> prod = new KafkaProducer<>(prop);

        // 发送消息
        try {
            for(int i=0; i<10; i++) {
                String join = "hello 3";
                // 生产者记录消息
                ProducerRecord<String, String> pr = new ProducerRecord<>("demo8", join);
                prod.send(pr);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            prod.close();
        }
    }
}
