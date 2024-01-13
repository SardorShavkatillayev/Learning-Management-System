package com.example.lms_prayekt.entity.lesson;

import com.example.lms_prayekt.entity.lesson.repozitary.LessonRepozitary;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import com.example.lms_prayekt.entity.sciences.repozitary.SciencesRepazitory;
import com.example.lms_prayekt.entity.student.controller.StudentRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/amaliyot")
@RequiredArgsConstructor
public class GetCantroller {
    private final LessonRepozitary lessonRepozitary;
    private final SciencesRepazitory sciences;
    private final StudentRepazitory studentRepazitory;
    @GetMapping("{id}")
    public ModelAndView getAll(@PathVariable("id") UUID id, Model model)
    {
        System.out.println("id = " + id);
        System.out.println("salom");
        return new ModelAndView("Lesson");
    }
    @PostMapping("{id}")
    private ModelAndView viewAndStudent(@PathVariable("id")UUID id, Model model)
    {
        System.out.println(id);
        Sciences sciences1 = sciences.findById(id).get();
        model.addAttribute(sciences1);
        return new ModelAndView("Amaliyot",model.asMap());
    }
    @GetMapping
    public ModelAndView getAll()
    {
        System.out.println("heloo");
        return new ModelAndView("tets");
    }

}
