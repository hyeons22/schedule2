package com.example.schedulepractice2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

