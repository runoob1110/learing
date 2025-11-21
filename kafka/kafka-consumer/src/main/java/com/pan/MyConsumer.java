package com.pan;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/25 16:56
 */
public class MyConsumer {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.74.157:9092");
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put("session.timeout.ms", "30000");
        //消费者是否自动提交偏移量，默认是true 避免出现重复数据 设为false
        prop.put("enable.auto.commit", "false");
        prop.put("auto.commit.interval.ms", "1000");
        //auto.offset.reset 消费者在读取一个没有偏移量的分区或者偏移量无效的情况下的处理
        //earliest 在偏移量无效的情况下 消费者将从起始位置读取分区的记录
        //latest 在偏移量无效的情况下 消费者将从最新位置读取分区的记录
        prop.put("auto.offset.reset", "earliest");
        // 设置组名
        prop.put(ConsumerConfig.GROUP_ID_CONFIG, "group_4");
        KafkaConsumer<String, String> con = new KafkaConsumer<>(prop);

        con.subscribe(Collections.singletonList("demo8"));

        while (true) {
            ConsumerRecords<String, String> records = con.poll(100);
            for (ConsumerRecord<String, String> rec : records) {
                System.out.println(String.format("offset:%d,key:%s,value:%s", rec.offset(), rec.key(), rec.value()));
            }
        }
    }
}
