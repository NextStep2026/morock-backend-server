package com.controller;

import com.domain.dto.ParticipationMessage;
import com.service.redis.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final RedisPublisher redisPublisher;


    // ✅ 클라이언트가 "/app/schedule/join"으로 메시지를 보내면 실행됨
    @MessageMapping("/schedule/join")
    public void handleJoinEvent(ParticipationMessage participationMessage) {
        // ✅ 유저 ID와 스케줄 ID를 Redis에 발행
        redisPublisher.publish("schedule-participation", participationMessage);
    }
}
