package com.xib.assessment.controller;

import com.xib.assessment.dto.AgentDto;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/agents/")
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }

    @GetMapping("/agents/page/{page}/size/{size}")
    public ResponseEntity<List<AgentDto>> getAllAgents(@PathVariable("page") int page,
                                                    @PathVariable("size") int size) {
        List<AgentDto> agents = agentService.getAllAgents(page, size);
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }


    @GetMapping("/agent/{id}")
    public ResponseEntity<Agent> findAgent(@PathVariable("id") Long id) {
        Agent agent = agentService.getAgentById(id);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @PostMapping("/agent/")
    @ResponseStatus(HttpStatus.CREATED)
    public Agent saveAgent(@RequestBody Agent agent) {
        return agentService.saveNewAgent(agent);
    }
}
