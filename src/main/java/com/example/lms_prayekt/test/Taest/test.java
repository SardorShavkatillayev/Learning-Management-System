package com.example.lms_prayekt.test.Taest;

import com.example.lms_prayekt.entity.student.Student;
import com.example.lms_prayekt.entity.student.controller.StudentRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/test1")
@RequiredArgsConstructor
public class test {
    private final StudentRepazitory studentRepazitory;
    @GetMapping
    public ModelAndView getAll()
    {
        System.out.println("heloo");
        return new ModelAndView("tets");
    }
    @PostMapping("{id}")
    public ResponseEntity<String> handleFileUpload(@PathVariable("id")UUID id, @RequestParam("file") File file) {
        System.out.println(file);
        String directoryPath = "D:\\LMS_Prayekt\\src\\main\\resources\\files";

        // Saqlanishi kerak bo'lgan fayl nomi
        String fileName = file.getName();

        // Faylning to'liq manzili
        String filePath = directoryPath + "/" + fileName;

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
        return ResponseEntity.badRequest().body("No file1 uploaded.");
        }
    }

