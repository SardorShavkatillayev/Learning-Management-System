package com.example.lms_prayekt.entity.student;

import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class File {
    @Id
    private UUID id;
    private String Taskname;
    private String filename;
    private LocalDate date;
    private final LocalDate TaskofDate=LocalDate.now();
    @ManyToOne
    private Sciences sciences;
}
