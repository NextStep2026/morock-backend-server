package com.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "club_name")
    private String clubName;            // 모임 이름

    @Column(name = "club_description")
    private String clubDescription;     // 모임 설명

    @Column(name = "max_participant")
    private String maxParticipant;      // 최대 인원

    @Column(name = "fee")
    private String fee;                 // 참가비

    @Column(name = "meeting_date")
    private String meetingDate;         // 모임시행날짜(선택)

    @Column(name = "period")
    private String period;              // 모임 개시 기간(between) 캘린더 선택

    @Column(name = "place_id")
    private Long placeId;               // 장소 (리스트 중 선택)

    @Column(name = "user_id")
    private String userId;
}
