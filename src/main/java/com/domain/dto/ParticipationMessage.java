package com.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipationMessage {
    private Long clubId;
    private Long memberId;    // 참여한 유저 ID
    private String userName;  // 참여한 유저 이름
    private String scheduleId; // 참여한 스케줄 ID
    private String eventType;
    public ParticipationMessage() {}

    public ParticipationMessage(Long clubId, Long memberId, String userName, String scheduleId, String eventType) {
        this.clubId = clubId;
        this.memberId = memberId;
        this.userName = userName;
        this.scheduleId = scheduleId;
        this.eventType = eventType;
    }
}
