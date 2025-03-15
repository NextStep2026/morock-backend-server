package com.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.connection.stream.MapRecord;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RedisParticipationStore {

    private final StringRedisTemplate redisTemplate;

    // ✅ Stream 참여자 추가
    public void addParticipant(Long clubId, Long scheduleId, Long memberId, String eventType) {
        String STREAM_KEY = getStreamKey("participants", clubId, scheduleId);

        Map<String, Object> message = new HashMap<>();
        message.put("clubId", clubId);
        message.put("scheduleId", scheduleId);
        message.put("memberId", memberId);
        message.put("eventType", eventType);

        redisTemplate.opsForStream().add(STREAM_KEY, message);
    }

    // ✅ Stream 참여자 목록 조회
    public List<String> getParticipants(Long clubId, Long scheduleId) {
        String STREAM_KEY = getStreamKey("participants", clubId, scheduleId);

//        List<MapRecord<String, String, Object>> records =
//                redisTemplate.opsForStream()
//                        .read(MapRecord.class, StreamOperations.empty(), STREAM_KEY);

//        return records.stream()
//                .map(record -> String.valueOf(record.getValue().get("memberId")))  // ✅ 명시적 String 변환
//                .collect(Collectors.toList());
        List<String> aa = new ArrayList<>();
        return aa;
    }

    // ✅ 스케줄이 가득 찼는지 확인
    public boolean isScheduleFull(Long clubId, Long scheduleId, int maxParticipants) {
        List<String> participants = getParticipants(clubId, scheduleId);
        return participants.size() >= maxParticipants;
    }

    // ✅ Stream Key 생성 (모임 + 스케줄 조합)
    private String getStreamKey(String startKey, Object clubId, Object scheduleId) {
        return startKey + "-clubId:" + clubId + "-scheduleId:" + scheduleId;
    }
}