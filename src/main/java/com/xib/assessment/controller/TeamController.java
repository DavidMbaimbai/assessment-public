package com.xib.assessment.controller;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams/")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long teamId) {
        Team team = teamService.getTeamById(teamId);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping("/team/")
    @ResponseStatus(HttpStatus.CREATED)
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveNewTeam(team);
    }

    @PutMapping("/team/{id}/agent")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAgentTeam(@PathVariable("id") Long id, @RequestBody Agent agent) {
        teamService.updateAgentWithTeamDetails(id, agent);
    }

    @GetMapping
    public ResponseEntity<List<Team>> findTeamsWithNoAgentOrManager() {
        List<Team> teams = teamService.findTeamsWithNoAgentOrManager();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
}
