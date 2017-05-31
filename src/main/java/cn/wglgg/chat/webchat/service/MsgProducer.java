package cn.wglgg.chat.webchat.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * 类MsgProducer的实现描述：TODO 类实现描述
 *
 * @author za-wanggang 2017/5/19 17:34
 */
@Component
public class MsgProducer {
    /*
     * @Value("${spring.kafka.template.default-topic}") private String topic;
     * @Autowired private KafkaTemplate<String, String> kafkaTemplate; public
     * void send(String text) { kafkaTemplate.send(topic, text); }
     */

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void send(String msg) {
        jmsTemplate.convertAndSend(new ActiveMQQueue(("wglgg.msg2tts")), msg);
    }
}
