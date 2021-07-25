package com.xib.assessment.service;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();

    Team getTeamById(Long teamId);

    Team saveNewTeam(Team team);

    void updateAgentWithTeamDetails(Long id,Agent agent);

    List<Team> findTeamsWithNoAgentOrManager();
}
