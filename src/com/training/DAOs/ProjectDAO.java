/**
 * 
 */
package com.training.DAOs;

import java.sql.*;
import java.util.ArrayList;

import com.training.entities.Project;
import com.training.ifaces.IDAO;
import com.training.utils.MySQLConnection;

/**
 * @author csoulakian
 *
 */
public class ProjectDAO implements IDAO<Project> {
  
  private Connection con = null;
  
  /**
   * Empty constructor that creates a connection.
   */
  public ProjectDAO() {
    super();
    con = MySQLConnection.getMyOracleConnection();
  }
  
  /**
   * Constructor that uses connection parameter.
   * 
   * @param con connection
   */
  public ProjectDAO(Connection con) {
    super();
    this.con = con;
  }

  @Override
  public int add(Project project) {
    
    int result;
    
    try {
      
      CallableStatement st = con.prepareCall("{call addProject(?, ?, ?, ?, ?, ?, ?)}");
      st.setInt(1, project.getProjectID());
      st.setString(2, project.getName());
      st.setString(3, project.getDescription());
      st.setString(4, project.getStatus());
      st.setDouble(5, project.getCost());
      st.setDouble(6, project.getAmountCollected());
      st.setDouble(7, project.getPendingAmount());
      
      st.execute();
      result = 1;
      
    } catch (SQLException e) {
      e.printStackTrace();
      result = 0;
    }
    return result;
  }

  @Override
  public Project find(int projectID) {
    
    Project project = new Project();
    
    try {
      
      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from project where projectID = " + projectID);

      while (rs.next()) {
        project.setProjectID(rs.getInt("projectID"));
        project.setName(rs.getString("projectName"));
        project.setDescription(rs.getString("projectDescription"));
        project.setStatus(rs.getString("projectStatus"));
        project.setCost(rs.getDouble("projectCost"));
        project.setAmountCollected(rs.getDouble("amountCollected"));
        project.setPendingAmount(rs.getDouble("pendingAmount"));
      }
      
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return project;
  }

  @Override
  public int delete(int projectID) {
    int result;
    
    try {
      
      CallableStatement st = con.prepareCall("{call deleteProject(?)}");
      st.setInt(1, projectID);
      
      st.execute();
      result = 1;
      
    } catch (SQLException e) {
      e.printStackTrace();
      result = 0;
    }
    return result;
  }

  @Override
  public ArrayList<Project> findAll() {
    
    ArrayList<Project> allProjects = new ArrayList<Project>();
    
    try {
      
      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from project");
      
      while (rs.next()) {
        Project project = new Project();
        
        project.setProjectID(rs.getInt("projectID"));
        project.setName(rs.getString("projectName"));
        project.setDescription(rs.getString("projectDescription"));
        project.setStatus(rs.getString("projectStatus"));
        project.setCost(rs.getDouble("projectCost"));
        project.setAmountCollected(rs.getDouble("amountCollected"));
        project.setPendingAmount(rs.getDouble("pendingAmount"));
        
        allProjects.add(project);
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return allProjects;
  }
  
  public void updateAmountCollected(int projectID, double newAmountCollected) {
    
    try {
      
      Statement s = (Statement) con.createStatement();
      
      s.executeUpdate("UPDATE project SET amountCollected = " + newAmountCollected + "WHERE projectID = " + projectID);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void updatePendingAmount(int projectID, double newPendingAmount) {
    
    try {
      
      Statement s = (Statement) con.createStatement();
      
      s.executeUpdate("UPDATE project SET pendingAmount = " + newPendingAmount + "WHERE projectID = " + projectID);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void updateStatus(int projectID, String newStatus) {
    
    try {
      
      Statement s = (Statement) con.createStatement();
      
      s.executeUpdate("UPDATE project SET projectStatus = '" + newStatus + "' WHERE projectID = " + projectID);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }

}
