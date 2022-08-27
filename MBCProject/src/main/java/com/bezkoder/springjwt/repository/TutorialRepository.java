package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
