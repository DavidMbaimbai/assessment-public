package com.xib.assessment.dto;

public class AgentDto {
    private String firstName;
    private String lastName;
    private String idNumber;
    private TeamDto team;

    public AgentDto() {
    }

    public AgentDto(String firstName, String lastName, String idNumber, TeamDto teamDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.team = teamDto;
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

    public TeamDto getTeamDto() {
        return team;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.team = teamDto;
    }
}
