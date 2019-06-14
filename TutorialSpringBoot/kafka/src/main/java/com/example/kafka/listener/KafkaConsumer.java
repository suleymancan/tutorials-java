package com.example.kafka.listener;

import com.example.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "TutorialTopic", groupId = "group_id")
    public void consume(String message){
    log.info("Consumed message: " + message);
    }

    @KafkaListener(topics = "TutorialJSON", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeJson(User user){
        log.info("Consumed JSON: " + user);
    }
}
