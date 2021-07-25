package com.xib.assessment.service;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.entity.Team;

import java.util.Set;

public interface ManagerService {
    Manager saveNewManager(Manager manager);

    Set<Team> allTeamsWithManagers();
}
