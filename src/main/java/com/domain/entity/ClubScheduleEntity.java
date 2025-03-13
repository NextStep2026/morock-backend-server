package com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "club_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId; // 스케줄 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private ClubEntity club; // 모임 ID (FK)

    @Column(nullable = false, length = 255)
    private String scheduleTitle; // 스케줄 제목

    @Column(columnDefinition = "TEXT")
    private String scheduleContent; // 스케줄 내용

    // 모집 기간 (공개 및 신청 가능 기간)
    @Column(nullable = false)
    private LocalDateTime recruitmentStartDate;

    private LocalDateTime recruitmentEndDate;

    // 시행일 (모임 실제 개최 일시)
    @Column(nullable = false)
    private LocalDateTime eventStartDate;

    private LocalDateTime eventEndDate;

    @Column(length = 255)
    private String location; // 장소

    // 정산 관련
    @Column(nullable = false)
    private Boolean isFixedPerPerson; // TRUE: 1인당 고정 비용, FALSE: 총 비용 n분의 1 정산

    private BigDecimal costPerPerson; // 1인당 비용

    private BigDecimal totalAmount; // 총 비용

    private Integer maxParticipants; // 최대 참여 인원 (NULL이면 제한 없음)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private ClubMemberEntity createdByUser; // 개설자 (FK)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleStatus status = ScheduleStatus.PENDING; // 정산 상태

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum ScheduleStatus {
        PENDING, COMPLETED, CANCELLED
    }
}
