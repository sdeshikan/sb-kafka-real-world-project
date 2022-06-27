package com.sdesh.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import entity.WikimediaData;
import repository.WikimediaDataRepository;

@Service
public class KafkaConsumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private WikimediaDataRepository wikimediaDataRepository;
    

    public KafkaConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }


    @KafkaListener(topics = "wikimedia_recentchange", groupId = "sdeshGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimediaData);
    }

}
