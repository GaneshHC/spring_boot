package com.wecp.progressive.service.impl;

import java.util.List;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

public class TeamServiceImplArraylist   implements TeamService{

    @Override
    public int addTeam(Team team) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteTeam(int teamId) {
        // TODO Auto-generated method stub
        TeamService.super.deleteTeam(teamId);
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        TeamService.super.emptyArrayList();
    }

    @Override
    public List<Team> getAllTeams() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Team getTeamById(int teamId) {
        // TODO Auto-generated method stub
        return TeamService.super.getTeamById(teamId);
    }

    @Override
    public void updateTeam(Team team) {
        // TODO Auto-generated method stub
        TeamService.super.updateTeam(team);
    }

    

}