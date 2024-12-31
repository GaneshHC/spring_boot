package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO{

    @Override
    public int addCricketer(Cricketer cricketer) throws SQLException{
        Connection connection=null;
        PreparedStatement statement=null;
        int generatedID=-1;
        try{
            connection =DatabaseConnectionManager.getConnection();
            String sql="INSERT into cricketer(  team_id, cricketer_name, age, nationality , experience, role, total_runs, total_wickets) VALUES (?,?,?,?,?,?,?,?) ";
            statement=connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cricketer.getTeam_id());
            statement.setString(2,cricketer.getCricketer_name());
            statement.setInt(3, cricketer.getAge());
            statement.setString(4, cricketer.getNationality());
            statement.setInt(5, cricketer.getExperience());
            statement.setString(6, cricketer.getRole());
            statement.setInt(7, cricketer.getTotal_runs());
            statement.setInt(8, cricketer.getTotal_wickets());
            statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            if(rs.next()){
                generatedID=rs.getInt(1);
                cricketer.setCricketer_id(generatedID);
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
        return generatedID;
         
        
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {

         Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
            connection=DatabaseConnectionManager.getConnection();
            String sql="SELECT * FROM cricketer WHERE cricketer_id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1, cricketerId);
            statement.executeQuery();
            ResultSet rs= statement.executeQuery();
            if(rs.next()){
                Cricketer o=new Cricketer();
                o.setCricketer_id(rs.getInt("cricketer_id"));
                o.setTeam_id (rs.getInt("team_id"));
                o.setCricketer_name (rs.getString("cricketer_name"));
                o.setAge(rs.getInt("age"));
                o.setNationality (rs.getString("nationality"));
                o.setExperience (rs.getInt("experience"));
                o.setRole (rs.getString("role"));
                o.setTotal_runs (rs.getInt("total_runs"));

                o.setTotal_wickets (rs.getInt("total_wickets"));
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
    public void updateCricketer(Cricketer cricketer) throws SQLException{
        Connection connection=null;
        PreparedStatement statement=null;
        String sql="UPDATE cricketer SET(  team_id, cricketer_name, age, nationality , experience, role, total_runs, total_wickets) VALUES (?,?,?,?,?,?,?,?) ";
         try(PreparedStatement statement2=connection.prepareStatement(sql)){
            statement2.setInt(1, cricketer.getTeam_id());
            statement2.setString(2,cricketer.getCricketer_name());
            statement2.setInt(3, cricketer.getAge());
            statement2.setString(4, cricketer.getNationality());
            statement2.setInt(5, cricketer.getExperience());
            statement2.setString(6, cricketer.getRole());
            statement2.setInt(7, cricketer.getTotal_runs());
            statement2.setInt(8, cricketer.getTotal_wickets());
            statement2.executeUpdate();

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
    public void deleteCricketer(int cricketerId) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        String sql="delete from cricketer where cricketId=?";
        try(PreparedStatement sm=connection.prepareStatement(sql)){
            sm.setInt(1,cricketerId);
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
    public List<Cricketer> getAllCricketers() throws SQLException{
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
            connection=DatabaseConnectionManager.getConnection();
            String sql="SELECT * FROM cricketer";
            statement=connection.prepareStatement(sql);
            //statement.setInt(1, cricketerId);
            statement.executeQuery();
            ResultSet rs= statement.executeQuery();
            List<Cricketer> l=new ArrayList<>();
            while(rs.next()){
                //List<Cricketer> l=new ArrayList<>();
                
                Cricketer o=new Cricketer();
                o.setCricketer_id(rs.getInt("cricketer_id"));
                o.setTeam_id (rs.getInt("team_id"));
                o.setCricketer_name (rs.getString("cricketer_name"));
                o.setAge(rs.getInt("age"));
                o.setNationality (rs.getString("nationality"));
                o.setExperience (rs.getInt("experience"));
                o.setRole (rs.getString("role"));
                o.setTotal_runs (rs.getInt("total_runs"));

                o.setTotal_wickets (rs.getInt("total_wickets"));
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

}
