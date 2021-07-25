package com.xib.assessment.entity;

import com.xib.assessment.dto.TeamDto;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "team_manager",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id"))
    private Set<Manager> managers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public TeamDto createTeamDto(Team team){
        TeamDto teamDto = new TeamDto(team.getName());
        return teamDto;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

}
