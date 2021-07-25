package com.xib.assessment.entity;

import com.xib.assessment.dto.AgentDto;

import javax.persistence.*;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    @OneToOne(optional = true)
    private Team team;

    @ManyToOne(optional = true)
    @JoinColumn(name = "manager")
    private Manager manager;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public AgentDto createAgentDto(){
        AgentDto agentDto = new AgentDto(this.getFirstName(), this.getLastName(),
                this.getIdNumber(), this.getTeam().createTeamDto(this.getTeam()));
        return agentDto;
    }
}
