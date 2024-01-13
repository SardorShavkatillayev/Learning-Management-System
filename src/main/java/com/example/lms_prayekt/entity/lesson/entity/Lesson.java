package com.example.lms_prayekt.entity.lesson.entity;

import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lesson {

    @Id
    private UUID id;
    private Integer hourOfweek;
    private Integer minutOfweek;
    private String roomname;
    private Integer dayOfWeek;
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    private Sciences sciences;


}
