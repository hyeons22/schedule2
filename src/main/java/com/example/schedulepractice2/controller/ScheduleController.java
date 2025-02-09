package com.example.schedulepractice2.controller;

import com.example.schedulepractice2.dto.ScheduleRequestDto;
import com.example.schedulepractice2.dto.ScheduleResponseDto;
import com.example.schedulepractice2.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.save(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(scheduleService.findById(id));
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.update(id,dto));
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteById(@PathVariable Long id){
        scheduleService.deleteById(id);
    }
}
