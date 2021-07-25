package com.xib.assessment.service.impl;

import com.xib.assessment.dto.AgentDto;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.AgentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final TeamRepository teamRepository;

    public AgentServiceImpl(AgentRepository agentRepository, TeamRepository teamRepository) {
        this.agentRepository = agentRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent getAgentById(Long id) {
        return agentRepository.getOne(id);
    }

    @Override
    public Agent saveNewAgent(Agent agent) {
        Team agentTeam = null;
        Optional<Team> team = teamRepository.findById(agent.getTeam().getId());
        if (!team.isPresent()) {
            agentTeam = teamRepository.save(agent.getTeam());
        }else{
            agentTeam = team.get();
        }
        agent.setTeam(agentTeam);
        return agentRepository.save(agent);
    }

    @Override
    public List<AgentDto> getAllAgents(int page, int size) {
        Page<Agent> pagedAgents = agentRepository.findAll(PageRequest.of(page, size));
        return pagedAgents
                .getContent()
                .stream().map(Agent::createAgentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateAgent(Agent agent) {
        agentRepository.save(agent);
    }
}
