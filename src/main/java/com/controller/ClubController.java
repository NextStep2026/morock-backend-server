package com.controller;

import com.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @GetMapping("/{clubId}")
    public ResponseEntity<String> selectClub(@PathVariable Long clubId) {
        clubService.setCurrentClubId(clubId);
        return ResponseEntity.ok().body("클럽 선택 완료");
    }
}
