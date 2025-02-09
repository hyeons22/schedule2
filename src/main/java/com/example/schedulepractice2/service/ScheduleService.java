package com.example.schedulepractice2.service;

import com.example.schedulepractice2.dto.ScheduleRequestDto;
import com.example.schedulepractice2.dto.ScheduleResponseDto;
import com.example.schedulepractice2.entity.Schedule;
import com.example.schedulepractice2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getTitle(), dto.getContent(), LocalDateTime.now(), LocalDateTime.now());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getTitle(),savedSchedule.getContent(),savedSchedule.getCreatedAt(),savedSchedule.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtoList = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContent(), schedule.getCreatedAt(), schedule.getModifiedAt());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 스케줄이 없습니다.")
        );
        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getContent(),schedule.getCreatedAt(),schedule.getModifiedAt());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 스케줄이 없습니다.")
        );
        schedule.update(dto.getTitle(),dto.getContent(),LocalDateTime.now());

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(),schedule.getContent(),schedule.getCreatedAt(),schedule.getModifiedAt());
    }

    @Transactional
    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
