package com.domain.id;

import jakarta.persistence.IdClass;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@EqualsAndHashCode
public class ClubRankPermissionId implements Serializable {

    private Long clubId;
    private Long rankId;
    private String permissionKey;

    public ClubRankPermissionId() {}

    public ClubRankPermissionId(Long clubId, Long rankId, String permissionKey) {
        this.clubId = clubId;
        this.rankId = rankId;
        this.permissionKey = permissionKey;
    }
}
