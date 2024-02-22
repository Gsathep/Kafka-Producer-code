package com.deliveryboy.service;

import com.deliveryboy.config.AppConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class   kafkaService {
    @Autowired
    KafkaTemplate <String,String>kafkaTemplate;

    public boolean updatelocation(String location)
    {
        this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME,location);
        log.info("message published");
        return true;
    }
}
