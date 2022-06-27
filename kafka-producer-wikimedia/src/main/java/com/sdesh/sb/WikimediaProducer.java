package com.sdesh.sb;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recentchange";

        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder eBuilder = new EventSource.Builder(eventHandler, URI.create(url));

        EventSource eventSource = eBuilder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
        

    }

}
