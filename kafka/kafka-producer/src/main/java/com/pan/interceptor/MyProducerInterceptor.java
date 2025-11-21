//package com.pan.interceptor;
//
//import org.apache.kafka.clients.producer.ProducerInterceptor;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//
//import java.util.Map;
//
///**
// * @author ：panleilei
// * @description
// * @modified By：
// * @version:
// * @date ：Created in 2023/10/30 15:06
// */
//public class MyProducerInterceptor implements ProducerInterceptor {
//    @Override
//    public ProducerRecord onSend(ProducerRecord record) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return record;
//    }
//
//    @Override
//    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
//
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//    @Override
//    public void configure(Map<String, ?> configs) {
//
//    }
//}
