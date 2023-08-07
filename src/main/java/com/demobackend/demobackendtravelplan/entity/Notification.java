package com.demobackend.demobackendtravelplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Notification {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int planId;
    private String planTitle;
    private String description;
}
