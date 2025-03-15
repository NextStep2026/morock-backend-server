package com.service.redis;

import com.domain.dto.ParticipationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisSubscriber implements MessageListener {

    private final SimpMessagingTemplate messagingTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // Redis에서 받은 메시지를 WebSocket으로 브로드캐스트
        try {
            // Redis에서 받은 JSON 메시지를 ParticipationMessage 객체로 변환
            String messageJson = new String(message.getBody());
            ParticipationMessage participationMessage = objectMapper.readValue(messageJson, ParticipationMessage.class);

            // WebSocket을 통해 모든 클라이언트에게 브로드캐스트
            messagingTemplate.convertAndSend("/topic/schedule", participationMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
