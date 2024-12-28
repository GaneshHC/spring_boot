package com.wecp.progressive.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO{

    private Connection connection;
    public TeamDAOImpl(Connection connection){
        this.connection=connection;
    }

    @Override
    public int addTeam(Team team)   {
        
        // String sql="INSERT INTO team (team_id, team_name, location, owner_name, establishment_year) VALUES (?, ?, ?, ?)";
        // try(PreparedStatement smt=connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)){
        //     smt.setString(1,team.getTeam_name());
        //     smt.setString(2,team.getLocation());
        //     smt.setString(3,team.getOwner_name());
        //     smt.setInt(4,team.getEstablishment_year());
        //     smt.executeUpdate();
        //     ResultSet rs=smt.getGeneratedKeys();
        //     if(rs.next()){
        //         team.setTeam_id(rs.getInt(1));
        //         return team.getTeam_id();
        //     }
        //     return -1;
            

        // }
        // catch(SQLException e){
        //     e.printStackTrace();
        // }
        return -1;
    }

    @Override
    public Team getTeamById(int teamId) {
        // String sql="SELECT * from team WHERE teamId=?";
        // try(PreparedStatement smt=connection.prepareStatement(sql)){
        //     smt.setInt(1,teamId);
        //     //smt.executeQuery();
        //     ResultSet rs=smt.executeQuery();
        //     while(rs.next()){
        //         Team t=new Team();
        //         t.setTeam_id(rs.getInt)
        //     }

        // }
    //     throw new UnsupportedOperationException("Unimplemented method 'updateTeam'");
    // }

        
    

    // @Override
    // public void updateTeam(Team team) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateTeam'");
    return null;
    }

    @Override
    public void deleteTeam(int teamId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteTeam'");
    }

    @Override
    public List<Team> getAllTeams() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllTeams'");
        return null;
    }

    @Override
    public void updateTeam(Team team) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateTeam'");
    }
    



}
