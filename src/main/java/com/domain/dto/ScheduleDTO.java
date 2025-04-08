package com.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private String clubName;            // 모임 이름
    private String clubDescription;     // 모임 설명
    private String maxParticipant;      // 최대 인원
    private String fee;                 // 참가비
    private String meetingDate;         // 모임시행날짜(선택)
    private String period;              // 모임 개시 기간(between) 캘린더 선택
    private Long placeId;               // 장소 (리스트 중 선택)
    private String userId;              // 모임 개시자
}
