package com.example.taskapi.model;

import jakarta.validation.constraints.NotBlank;

public record Task(
        Long id,
        @NotBlank String title,
        boolean done
) {}
