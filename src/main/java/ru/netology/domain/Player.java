package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private int id;
    private String name;
    private int strength;
}
