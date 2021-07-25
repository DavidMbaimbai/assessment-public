package com.xib.assessment.service.impl;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.entity.Team;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.service.ManagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager saveNewManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Set<Team> allTeamsWithManagers(){
        List<Manager> allManagers = managerRepository.findAll();
        return allManagers.stream()
                .flatMap(a-> a.getTeams().stream().flatMap(b->Stream.of(b)))
                .collect(Collectors.toSet());
    }
}
