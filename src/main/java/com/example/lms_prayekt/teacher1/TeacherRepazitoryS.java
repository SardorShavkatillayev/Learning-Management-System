package com.example.lms_prayekt.teacher1;

import com.example.lms_prayekt.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherRepazitoryS extends JpaRepository<Teacher, UUID> {



}
