package com.information.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Project {
    private String title;
    private String description;
    private List<Tecnology> tecnologies;
    private String urlRepo;
}
