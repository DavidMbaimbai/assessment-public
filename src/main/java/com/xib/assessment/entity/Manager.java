package com.xib.assessment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Manager {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String idNumber;

    @ManyToMany(mappedBy = "managers")
    private Set<Team> teams;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private List<Agent> agents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
}
