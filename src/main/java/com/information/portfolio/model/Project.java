package com.information.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Project {
    private String id;
    private String title;
    private String description;
    private List<Tecnology> technologies ;
    private String urlRepo;
}
