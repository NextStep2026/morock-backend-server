package com.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "club")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long clubId; // 모임 고유 ID (PK)

    @Column(name = "club_name", nullable = false, length = 30)
    private String clubName; // 모임 이름

    @Column(name = "club_code", nullable = false, unique = true, length = 10)
    private String clubCode; // 모임 초대 코드

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // 생성일

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
