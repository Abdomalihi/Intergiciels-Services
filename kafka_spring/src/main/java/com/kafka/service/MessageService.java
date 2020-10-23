package com.kafka.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.kafka.model.PageEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(topics = "TestTopic2", groupId = "groupe-ms")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws Exception {
        System.out.println("***********************************");
        PageEvent pageEvent = pageEvent(consumerRecord.value());
        System.out.println("key   => " + consumerRecord.key());
        System.out.println( pageEvent.getPage() + ", " + pageEvent.getDate() + ", " + pageEvent.getDuration() );
        System.out.println("***********************************");
    }

    private PageEvent pageEvent(String jsonPageEvent) throws Exception {
        JsonMapper jsonMapper = new JsonMapper();
        PageEvent pageEvent = jsonMapper.readValue(jsonPageEvent, PageEvent.class);
        return pageEvent;
    }
}
