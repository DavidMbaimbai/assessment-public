package com.xib.assessment.service;

import com.xib.assessment.dto.AgentDto;
import com.xib.assessment.entity.Agent;

import java.util.List;

public interface AgentService {

    List<Agent> getAllAgents();

    Agent getAgentById(Long id);

    Agent saveNewAgent(Agent agent);

    List<AgentDto> getAllAgents(int page, int size);

    void updateAgent(Agent agent);
}
