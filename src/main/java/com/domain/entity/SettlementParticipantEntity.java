package com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "settlement_participant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementParticipantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settlementParticipantId; // 정산 참여자 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private ClubScheduleEntity schedule; // 참여한 스케줄 (FK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private ClubMemberEntity member; // 참여자 (FK)

    @Column(nullable = false, updatable = false)
    private LocalDateTime joinTime = LocalDateTime.now(); // 참여 시간

    @Column(nullable = false)
    private LocalDateTime paymentDeadline; // 개별 정산 마감 기한

    @Column(nullable = false)
    private Boolean isFreeParticipant = false; // 무료 혜택 여부

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paidStatus = PaymentStatus.PENDING; // 결제 상태

    private LocalDateTime paymentTime; // 결제 완료 시간

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // 생성일

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum PaymentStatus {
        PENDING, PAID, CANCELLED
    }
}
