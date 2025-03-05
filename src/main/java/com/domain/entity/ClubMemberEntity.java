package com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "club_member", schema = "public")  // 스키마 지정 (PostgreSQL 기준)
public class ClubMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_member_id")
    private Long clubMemberId;  // 모임 회원 고유 ID (PK)

    @Column(name = "user_id", nullable = false)
    private Long userId;  // 앱 회원 ID (FK)

    @Column(name = "club_id", nullable = false)
    private Long clubId;  // 모임 ID (FK)

    @Column(name = "member_role", length = 10)
    private String memberRole;  // 모임 내 역할

    @Column(name = "joined_at")
    private LocalDateTime joinedAt;  // 모임 가입일

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;  // 생성일 (기본값: CURRENT_DATE)

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;  // 수정일
}
