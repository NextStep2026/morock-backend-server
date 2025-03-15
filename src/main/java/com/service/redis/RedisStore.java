package com.service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RedisStore<T> {

    private final RedisTemplate<String, T> redisTemplate;

    // 특정 키에 특정 값이 존재하는지 확인 (ex: 유저 참여 여부)
    public boolean exists(String key, T value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    // 특정 키에 값 추가 (ex: 참여 등록)
    public void add(String key, T value) {
        redisTemplate.opsForSet().add(key, value);
    }

    // 특정 키에서 값 삭제 (ex: 참여 취소)
    public void remove(String key, T value) {
        redisTemplate.opsForSet().remove(key, value);
    }

    // 특정 키에 저장된 전체 값 조회 (ex: 특정 스케줄의 모든 참여자 조회)
    public Set<T> getAll(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // Redis에서 최근 10개 메시지 가져오기
    public List<T> getRecentMessages(String key) {
        return redisTemplate.opsForList().range(key, -10, -1);
    }
}
