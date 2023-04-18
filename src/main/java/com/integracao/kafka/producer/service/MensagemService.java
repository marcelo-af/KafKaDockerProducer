package com.integracao.kafka.producer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    //Variavel para ver o log
    private static final Logger logger = LoggerFactory.getLogger(MensagemService.class);

    @Value("${topic.praticar-kafka}")
    private String topicPraticarKafka;

    //Cria o template do kafka para enviar a Mensagem
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //Metodo que envia mensagem para o Kafka
    public void sendMessage(String message){
        logger.info("Mensagem -> {}", message);
        this.kafkaTemplate.send(topicPraticarKafka, message);
    }

}