package com.example.schedulepractice2.repository;

import com.example.schedulepractice2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
