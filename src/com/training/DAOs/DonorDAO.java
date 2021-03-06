package com.training.DAOs;

import java.sql.*;
import java.util.ArrayList;

import com.training.entities.Donor;
import com.training.entities.Project;
import com.training.ifaces.IDAO;
import com.training.utils.MySQLConnection;

public class DonorDAO implements IDAO<Donor> {

  private Connection con = null;
  
  
  /**
   * Empty constructor that creates a connection.
   */
  public DonorDAO() {
    super();
    con = MySQLConnection.getMyOracleConnection();
  }
  
    /**
     * Constructor that uses connection parameter.
     * 
   * @param con connection
   */
  public DonorDAO(Connection con) {
    super();
    this.con = con;
  }

  @Override
  public int add(Donor donor) {
    
    int result;
    
    try {
      
      CallableStatement st = con.prepareCall("{call addDonor(?, ?, ?, ?, ?)}");
      st.setInt(1, donor.getDonorID());
      st.setString(2, donor.getDonorName());
      st.setString(3, donor.getEmail());
      st.setInt(4, donor.getSelectedProject().getProjectID());
      st.setDouble(5, donor.getAmountDonated());
      
      //TODO execute returns boolean value, can return that instead of result
      st.execute();
      result = 1;
      
    } catch (SQLException e) {
      e.printStackTrace();
      result = 0;
    }
    
    return result;
  }

  @Override
  public Donor find(int donorID) {
    Donor donorNoProject = new Donor();
    Project project = new Project();

    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from donor where donorID = " + donorID);

      while (rs.next()) {
        donorNoProject.setDonorID(rs.getInt("donorID"));
        donorNoProject.setDonorName(rs.getString("donorName"));
        donorNoProject.setEmail(rs.getString("donorEmail"));
        project.setProjectID(rs.getInt("selectedProjectID"));
        donorNoProject.setSelectedProject(project);
        donorNoProject.setAmountDonated(rs.getDouble("amountdonated"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return donorNoProject;
  }

  @Override
  public int delete(int donorID) {
    int result;
    
    try {
      
      CallableStatement st = con.prepareCall("{call deleteDonor(?)}");
      st.setInt(1, donorID);
      
      st.execute();
      result = 1;
      
    } catch (SQLException e) {
      e.printStackTrace();
      result = 0;
    }
    return result;
  }

  @Override
  public ArrayList<Donor> findAll() {
    
    ArrayList<Donor> allDonors = new ArrayList<Donor>();

    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from donor");

      while (rs.next()) {
        Donor donorNoProject = new Donor();
        Project project = new Project();

        donorNoProject.setDonorID(rs.getInt("donorID"));
        donorNoProject.setDonorName(rs.getString("donorName"));
        donorNoProject.setEmail(rs.getString("donorEmail"));
        project.setProjectID(rs.getInt("selectedProjectID"));
        donorNoProject.setSelectedProject(project);
        donorNoProject.setAmountDonated(rs.getDouble("amountDonated"));

        allDonors.add(donorNoProject);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return allDonors;
  }
  

  public ArrayList<Donor> findDonorsForProject(Project project) {
    
    ArrayList<Donor> allDonors = new ArrayList<Donor>();

    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("SELECT * FROM donor WHERE projectID = " + project.getProjectID());

      while (rs.next()) {
        Donor donor = new Donor();

        donor.setDonorID(rs.getInt("donorID"));
        donor.setDonorName(rs.getString("donorName"));
        donor.setEmail(rs.getString("donorEmail"));
        donor.setSelectedProject(project);
        donor.setAmountDonated(rs.getDouble("amountDonated"));

        allDonors.add(donor);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return allDonors;
  }
  
  public void updateAmountDonated(int donorID, double newDonationTotal) {
    
    try {
      
      Statement s = (Statement) con.createStatement();
      
      s.executeUpdate("UPDATE donor SET amountDonated = " + newDonationTotal + "WHERE donorID = " + donorID);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
  
  public boolean authenticateDonor(int donorID, String donorEmail) {
    
    String actualEmail = null;
    
    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from donor where donorID = " + donorID);

      while (rs.next()) {
        actualEmail = rs.getString("donorEmail");
      }
      
      if(donorEmail.equals(actualEmail)) {
        return true;
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
   
    return false;
  }

}
