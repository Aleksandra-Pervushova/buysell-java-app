package com.example.Buysell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Buysell.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
