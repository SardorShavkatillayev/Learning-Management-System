package com.example.lms_prayekt.file;
import org.apache.catalina.connector.Response;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/name")
public class FileController {
    @GetMapping("/{file}")
    public ResponseEntity<Resource> downloadPdfFile(@PathVariable("file") String filename) throws IOException {
        Resource fileResource = new FileSystemResource("files/" + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "files/download.jpg; filename=" + fileResource);
        return ResponseEntity.ok()
                .contentLength(fileResource.getFile().length())
                .contentType(MediaType.IMAGE_PNG)
                .body(fileResource);
    }
    @GetMapping
    public ModelAndView getAllTest()
    {
        return new ModelAndView("resources/files/test123");
    }
}
