package com.domain.dto;

import com.domain.entity.ClubRankEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubMember {

    private Long clubMemberId;
    private Long clubId;
    private Long userId;
    private String memberRole;
    private ClubRankEntity rankId;
    private LocalDateTime joinedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
