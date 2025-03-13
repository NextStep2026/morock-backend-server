package com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "kafka_event_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KafkaEventLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId; // 이벤트 고유 ID

    @Column(nullable = false, length = 50)
    private String eventType; // 이벤트 유형 (JOIN, PAYMENT, AUTO_CANCEL, etc.)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private ClubScheduleEntity schedule; // 관련 스케줄 ID (FK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private ClubMemberEntity member; // 관련 멤버 ID (FK)

    @Column(columnDefinition = "JSON")
    private String eventPayload; // 이벤트 추가 데이터 (JSON)

    @Column(nullable = false, updatable = false)
    private LocalDateTime eventTime = LocalDateTime.now(); // 이벤트 발생 시간
}
