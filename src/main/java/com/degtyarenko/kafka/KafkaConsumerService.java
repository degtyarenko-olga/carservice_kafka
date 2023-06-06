package com.degtyarenko.kafka;


import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author Degtyarenko Olga
 * @since 19.05.2023
 */
@Service
public class KafkaConsumerService {

    private static final Logger log = Logger.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "request_logs", groupId = "first")
    public void consumeRequestLog(String requestLog) {
        log.info("Received request log: " + requestLog);
    }

    @KafkaListener(topics = "token_grant_logs", groupId = "first")
    public void consumeTokenGrantLog(String tokenGrantLog) {
        log.info("Received token grant log: " + tokenGrantLog);
    }

}
