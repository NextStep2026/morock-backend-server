package com.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long placeId;


    // 장소 이름
    @Column(name = "", nullable = false, length = 50)
    private String placeName;

    // 위도
    @Column(name = "", nullable = false)
    private Double latitude;

    // 경도
    @Column(name = "", nullable = false)
    private Double longitude;

    // 장소 설명
    @Column(name = "", length = 100)
    private String description;

    // 등록자 id
    @Column(name= "")
    private Long registeredById;

    // 생성일
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 수정일
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
