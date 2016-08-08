package com.training.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.training.entities.Donor;
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

    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from donor where donorID = " + donorID);

      while (rs.next()) {
        donorNoProject.setDonorID(rs.getInt("donorID"));
        donorNoProject.setDonorName(rs.getString("donorName"));
        donorNoProject.setEmail(rs.getString("donorEmail"));
        donorNoProject.setAmountDonated(rs.getDouble("amountdonated"));
      }

      con.close();

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

        donorNoProject.setDonorID(rs.getInt("donorID"));
        donorNoProject.setDonorName(rs.getString("donorName"));
        donorNoProject.setEmail(rs.getString("donorEmail"));
        donorNoProject.setAmountDonated(rs.getDouble("amountdonated"));

        allDonors.add(donorNoProject);
      }

      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return allDonors;
  }

}
