package com.example.lms_prayekt.teacher.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {

    private UUID id;
    private String Fullname;

    private String Login;

    private String parol;
}
