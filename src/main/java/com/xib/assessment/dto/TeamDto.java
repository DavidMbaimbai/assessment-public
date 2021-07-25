package com.xib.assessment.dto;

public class TeamDto {
    private String name;

    public TeamDto(String name) {
        this.name = name;
    }

    public TeamDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
