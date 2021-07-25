package com.xib.assessment.service.impl;

import com.xib.assessment.exceptions.TeamNotFoundException;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.AgentService;
import com.xib.assessment.service.ManagerService;
import com.xib.assessment.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final AgentService agentService;
    private final ManagerService managerService;

    public TeamServiceImpl(TeamRepository teamRepository,
                           AgentService agentService,
                           ManagerService managerService) {
        this.teamRepository = teamRepository;
        this.agentService = agentService;
        this.managerService = managerService;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamRepository.getOne(teamId);
    }

    @Override
    public Team saveNewTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void updateAgentWithTeamDetails(Long id, Agent agent) {
        Optional<Team> nullableTeam = teamRepository.findById(id);
        if(!nullableTeam.isPresent()){
            throw new TeamNotFoundException("Team with specified id: " + id +" not found!");
        }
        agent.setTeam(nullableTeam.get());
        agentService.updateAgent(agent);
    }

    @Override
    public List<Team> findTeamsWithNoAgentOrManager() {
        List<Agent> allAgents = agentService.getAllAgents();
        Set<Team> managedTeams = managerService.allTeamsWithManagers();
        Set<Team> usedTeams = allAgents.stream()
                .flatMap((a) -> Stream.of(a.getTeam()))
                .collect(Collectors.toSet());
        List<Team> allTeams = teamRepository.findAll();
        allTeams.removeAll(usedTeams);
        allTeams.removeAll(managedTeams);

        return allTeams;
    }
}
