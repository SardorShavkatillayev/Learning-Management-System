package com.example.lms_prayekt.entity.sciences.entity;

import com.example.lms_prayekt.entity.lesson.entity.Lesson;

import com.example.lms_prayekt.entity.student.File;
import com.example.lms_prayekt.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Sciences {
    @Id
    private UUID id;
    private String name;
    private Integer freeLesson;             //nb
    private Integer accumulatedpoints;
    private Integer percentageoftotalscore;
    private String filname;

    @OneToMany(mappedBy = "sciences", fetch = FetchType.EAGER)
    private List<File> files;

    @OneToMany(mappedBy = "sciences", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "sciences", fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreeLesson() {
        return freeLesson;
    }

    public void setFreeLesson(int freeLesson) {
        this.freeLesson = freeLesson;
    }

    public int getAccumulatedpoints() {
        return accumulatedpoints;
    }

    public void setAccumulatedpoints(int accumulatedpoints) {
        this.accumulatedpoints = accumulatedpoints;
    }

    public int getPercentageoftotalscore() {
        return percentageoftotalscore;
    }

    public void setPercentageoftotalscore(int percentageoftotalscore) {
        this.percentageoftotalscore = percentageoftotalscore;
    }

    public String getFilname() {
        return filname;
    }

    public void setFilname(String filname) {
        this.filname = filname;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

