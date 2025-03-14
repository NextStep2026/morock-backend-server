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
@IdClass(com.domain.id.ClubRankPermissionId.class)
@Table(name = "club_rank_permission")
public class ClubRankPermissionEntity {

    @Id
    private Long clubId;

    @Id
    private Long rankId;

    @Id
    private String permissionKey;

    private LocalDateTime createdAt;
}