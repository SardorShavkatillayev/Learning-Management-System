package com.example.lms_prayekt.entity.student.controller;


import com.example.lms_prayekt.entity.admin.Admin;
import com.example.lms_prayekt.entity.admin.repozitary.AdminRepozitary;
import com.example.lms_prayekt.entity.lesson.repozitary.LessonRepozitary;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import com.example.lms_prayekt.entity.sciences.repozitary.SciencesRepazitory;
import com.example.lms_prayekt.entity.student.Student;

import com.example.lms_prayekt.teacher.Teacher;
import com.example.lms_prayekt.teacher.TeacherRepazitory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class LoginController {
    private final StudentRepazitory studentRepazitory;
    private final TeacherRepazitory repazitory;
    private final AdminRepozitary adminrepozitary;
    private final LessonRepozitary lessonRepozitary;
    private final SciencesRepazitory sciencesRepazitory;
    private List<Sciences> sciences=new ArrayList<>();
    private static String loginStudent="";
    @PostMapping("/loginParol")
    public ModelAndView register(@RequestParam("Login")String login, Model model)
    {
        loginStudent+=login;
        for (Teacher teacher : repazitory.findAll()) {
            if (teacher.getLogin().equals(login))
            {
                model.addAttribute(teacher);
                return new ModelAndView("Teacher",model.asMap());
            }
        }
        Student byLogin = studentRepazitory.getByLogin(login);

        if (byLogin!=null ){
         sciences = byLogin.getSciences();
        model.addAttribute(sciences);
        findLoginTeacher(login);
        return new ModelAndView("Dars",model.asMap());}
        else if (byLogin==null ) {
            Admin byLogin1 = adminrepozitary.findByLogin(login);
            model.addAttribute(byLogin1);
            return new ModelAndView("lessonAdmin",model.asMap());
        }
        return new ModelAndView("login");
    }

    private void findLoginTeacher(String login) {
        List<Teacher>teachers=new ArrayList<>();
        for (Sciences science : sciences) {
            for (Teacher teacher : science.getTeachers()) {
                for (Student student : teacher.getStudents()) {
                    if (student.getLogin().equals(login))
                    {
                        System.out.println("teacher.getFullname() = " + teacher.getFullname());
                        teachers.add(teacher);
                    }
                }
            }
        }
        for (Sciences science : sciences) {
            for (Teacher teacher : science.getTeachers()) {
                for (Student student : teacher.getStudents()) {
                    if (student.getLogin().equals(login))
                    {
                       science.setTeachers(teachers);
                    }
                }
            }
        }
        System.out.println("teachers = " + teachers.size());

    }
    @GetMapping("/jadval")
    public ModelAndView jadvalDars( Model model)
    {
        model.addAttribute(sciences);

        return new ModelAndView("test",model.asMap());
    }

    @GetMapping("/lessons")
    public ModelAndView getAll(Model model)
    {
        model.addAttribute(sciences);
        return new ModelAndView("TableDars",model.asMap());
    }
    @GetMapping("/data")
     private ModelAndView getAllData(Model model)
    {
        model.addAttribute(sciences);
        return new ModelAndView("TableDars",model.asMap());
    }
    @Transactional
    @PostMapping("/{id}")
    public ModelAndView handleFileUpload(@PathVariable("id") UUID id, @RequestParam("file") File file,Model model) {
        Student student = studentRepazitory.getByLogin(loginStudent);
        String directoryPath = "D:\\LMS_Prayekt\\src\\main\\resources\\files";
        Sciences sciences1 = sciencesRepazitory.findById(id).get();
        // Saqlanishi kerak bo'lgan fayl nomi
        String fileName = file.getName();

        // Faylning to'liq manzili
        String filePath = directoryPath + "/" + fileName;
         sciences1.setFiles(List.of(new com.example.lms_prayekt.entity.student
                 .File(UUID.randomUUID(),"Topshiriq-1",fileName, LocalDate.now(),sciences1)));
        File file1 = new File(filePath);
        try {
            // Faylni yaratish
            if (file1.createNewFile()) {
                System.out.println("Fayl muvaffaqiyatli yaratildi.");
            } else {
                System.out.println("Fayl allaqachon mavjud.");
            }
        } catch (IOException e) {
            System.out.println("Xatolik yuz berdi: " + e.getMessage());
        }
        model.addAttribute(sciences1);
        return new ModelAndView("Lesson",model.asMap());
    }

    @GetMapping()
    public ModelAndView gerBack()
    {
        return new ModelAndView("Teacher");
    }
}
