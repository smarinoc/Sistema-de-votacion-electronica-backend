package co.edu.udea.iot.backend.broker;

import co.edu.udea.iot.backend.service.VoteService;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VoteBroker {

    private final IMqttClient client;
    private final String BROKER_URL = "tcp://localhost:1883";

    private final VoteService voteService;

    private final WebPublisher webPublisher;

    public VoteBroker(VoteService voteService, WebPublisher webPublisher) throws MqttException {
        this.voteService = voteService;
        this.webPublisher = webPublisher;
        String clientId = UUID.randomUUID().toString();
        client = new MqttClient(BROKER_URL, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        client.connect(options);
        client.subscribe("raspberry/vote", this::raspberryVoteing);
        client.subscribe("finalize", this::frontFinalize);
    }

    private void processMessage(String topic, MqttMessage message) {
        System.out.printf("%s -> %s", topic, message);
    }

    private void raspberryVoteing(String topic, MqttMessage message) throws MqttException {
        voteService.raspberryVoting(message.toString());
        webPublisher.publish("front/vote","1");
    }

    private void frontFinalize(String topic, MqttMessage message) throws MqttException {
        webPublisher.publish("front/finalize", "1");
    }
}
