package com.example.lms_prayekt.entity.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin_StudentCreatedDto {

    private UUID id;
    private String name;
    private String surname;
    private String login;
    private String password;

}
