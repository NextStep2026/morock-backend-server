package com.service.redis;

import com.domain.dto.ParticipationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    // ✅ Redis Pub/Sub에 메시지를 게시하는 메서드
    public void publish(String channel, ParticipationMessage participationMessage) {
        try {
            String messageJson = objectMapper.writeValueAsString(participationMessage);
            redisTemplate.convertAndSend(channel, messageJson);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

    }
}
