package Usuarios.Usuarios.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduces {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProduces(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Sends a message to the specified Kafka topic.
     *
     * @param topic   the name of the Kafka topic
     * @param message the message to send
     */
    public void sendMessage(String topic, String message) {
        if (topic == null || topic.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic cannot be null or empty");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        try {
            kafkaTemplate.send(topic, message);
            System.out.println("Message sent to topic " + topic + ": " + message);
        } catch (Exception e) {
            System.err.println("Failed to send message to topic " + topic + ": " + e.getMessage());
            throw e; // Rethrow the exception to propagate it if necessary
        }
    }
}
