package com.wecp.progressive.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO{

    private Connection connection;
    public TeamDAOImpl(Connection connection){
        this.connection=connection;
    }

    @Override
    public int addTeam(Team team)   throws SQLException {
        
        String sql="INSERT INTO team (team_id, team_name, location, owner_name, establishment_year) VALUES (?, ?, ?, ?)";
        try(PreparedStatement smt=connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)){
            smt.setString(1,team.getTeam_name());
            smt.setString(2,team.getLocation());
            smt.setString(3,team.getOwner_name());
            smt.setInt(4,team.getEstablishment_year());
            smt.executeUpdate();
            ResultSet rs=smt.getGeneratedKeys();
            if(rs.next()){
                team.setTeam_id(rs.getInt(1));
                return team.getTeam_id();
            }
            return -1;
            

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
            connection=DatabaseConnectionManager.getConnection();
            String sql="SELECT * FROM cricketer WHERE team_id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1, teamId);
            statement.executeQuery();
            ResultSet rs= statement.executeQuery();
            if(rs.next()){
                Team o=new Team();
                o.setTeam_id(rs.getInt("team_id"));
                o.setTeam_name (rs.getString("team_name"));
                o.setLocation (rs.getString("location"));
                o.setOwner_name(rs.getString("owner_name"));
                o.setEstablishment_year (rs.getInt("establishment_year"));
                // o.setExperience (rs.getInt("experience"));
                // o.setRole (rs.getString("role"));
                // o.setTotal_runs (rs.getInt("total_runs"));

                // o.setTotal_wickets (rs.getInt("total_wickets"));
                return o;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(statement !=null){
                statement.close();
            }
        }
        return null;

        
    

    
    
    }


    @Override
    public void deleteTeam(int teamId) throws SQLException{
        Connection connection=null;
        PreparedStatement statement=null;
        String sql="delete from team where cricketId=?";
        try(PreparedStatement sm=connection.prepareStatement(sql)){
            sm.setInt(1,teamId);
            sm.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            if(statement !=null){
                statement.close();
            }
        }

    }

    @Override
    public List<Team> getAllTeams() throws SQLException {
       Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
            connection=DatabaseConnectionManager.getConnection();
            String sql="SELECT * FROM team";
            statement=connection.prepareStatement(sql);
            //statement.setInt(1, cricketerId);
            statement.executeQuery();
            ResultSet rs= statement.executeQuery();
            List<Team> l=new ArrayList<>();
            while(rs.next()){
                //List<Cricketer> l=new ArrayList<>();
                
                Team o=new Team();
                o.setTeam_id(rs.getInt("team_id"));
                o.setTeam_name (rs.getString("team_name"));
                o.setLocation (rs.getString("location"));
                o.setOwner_name(rs.getString("owner_name"));
                o.setEstablishment_year (rs.getInt("establishment_year"));
                 l.add(o);
            }
            return l;

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(statement !=null){
                statement.close();
            }
        }
         
    }

    

    @Override
    public void updateTeam(Team team) throws SQLException{
        Connection connection=null;
        PreparedStatement statement=null;
        String sql="UPDATE team SET( team_name, location, owner_name, establishment_year) VALUES (?, ?, ?, ?) ";
         try(PreparedStatement statement2=connection.prepareStatement(sql)){
            statement2.setString(1,team.getTeam_name());
            statement2.setString(2,team.getLocation());
            statement2.setString(3,team.getOwner_name());
            statement2.setInt(4,team.getEstablishment_year());
            statement2.executeUpdate();
           // statement2.executeUpdate();

         }
         catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            if(statement !=null){
                statement.close();
            }
        }
    }
    



}
