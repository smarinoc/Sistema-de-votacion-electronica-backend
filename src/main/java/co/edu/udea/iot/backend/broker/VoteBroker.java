package co.edu.udea.iot.backend.broker;

import co.edu.udea.iot.backend.service.VoteService;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VoteBroker {

    private final IMqttClient client;
    private final String DEFAULT_PUB_TOPIC = "front/vote";
    private final String BROKER_URL = "tcp://localhost:1883";

    private final VoteService voteService;

    public VoteBroker(VoteService voteService) throws MqttException {
        this.voteService = voteService;
        String clientId = UUID.randomUUID().toString();
        client = new MqttClient(BROKER_URL, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        client.connect(options);
        client.subscribe(DEFAULT_PUB_TOPIC, this::processMessage);
        client.subscribe("front/finalize", this::processMessage);
        client.subscribe("raspberry/vote", this::raspberryVoteing);
        client.subscribe("finalize", this::finalize);
    }

    private void processMessage(String topic, MqttMessage message) {
        System.out.printf("%s -> %s", topic, message);
    }

    private void raspberryVoteing(String topic, MqttMessage message) throws MqttException {
         voteService.raspberryVoting(message.toString());
         this.pubVote();
    }

    private void finalize(String topic, MqttMessage message) throws MqttException {
        this.publish("front/finalize", "1");
    }

    private void pubVote() throws MqttException {
        this.publish("front/vote", "1");
    }

    public void publish(String message) throws MqttException {
        this.publish(this.DEFAULT_PUB_TOPIC, message);
    }

    public void publish(String topic, String message) throws MqttException {
        if (!client.isConnected()) {
            //todo log message client not connected
            return;
        }
        MqttMessage msg = new MqttMessage(message.getBytes());
        msg.setQos(0);
        msg.setRetained(true);
        client.publish(topic, msg);
    }

}
