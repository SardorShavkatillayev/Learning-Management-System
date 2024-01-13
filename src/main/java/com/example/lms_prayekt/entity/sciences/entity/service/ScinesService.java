package com.example.lms_prayekt.entity.sciences.entity.service;

import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import com.example.lms_prayekt.entity.sciences.repozitary.SciencesRepazitory;
import com.example.lms_prayekt.entity.student.Student;
import com.example.lms_prayekt.entity.student.controller.StudentRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScinesService {

    private final SciencesRepazitory sciencesRepazitory;
    private final StudentRepazitory studentRepazitory;


    @Transactional
    public void nbUpdate(UUID id) {
        Student student = studentRepazitory.findById(id).get();
        for (Sciences science : student.getSciences()) {
            int freeLesson = science.getFreeLesson();
            freeLesson = freeLesson + 1;
            science.setFreeLesson(freeLesson);
        }
    }


}
