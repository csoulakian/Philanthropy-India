package com.training.DAOs;

import java.sql.*;

import com.training.entities.Images;
import com.training.entities.Project;
import com.training.utils.MySQLConnection;

public class ImageDAO {

  private Connection con = null;
  
  /**
   * Empty constructor that creates a connection.
   */
  public ImageDAO() {
    super();
    con = MySQLConnection.getMyOracleConnection();
  }
  
  /**
   * Constructor that uses connection parameter.
   * 
   * @param con connection
   */
  public ImageDAO(Connection con) {
    super();
    this.con = con;
  }
  
  public int addImages(int projectID, Images imagesToAdd) {

    int result;
    
    try {
      
      CallableStatement st = con.prepareCall("{call addImage(?, ?, ?, ?)}");
      st.setInt(1, projectID);
      st.setString(2, imagesToAdd.getImage1());
      st.setString(3, imagesToAdd.getImage2());
      st.setString(4, imagesToAdd.getImage3());
      
      st.execute();
      result = 1;
      
    } catch (SQLException e) {
      e.printStackTrace();
      result = 0;
    }
    return result;
    
  }

  public Images findImages(Project project) {
    
    Images images = new Images();
    
    try {
      
      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from image where projectID = " + project.getProjectID());

      while (rs.next()) {
        images.setImage1(rs.getString("image1"));
        images.setImage2(rs.getString("image2"));
        images.setImage3(rs.getString("image3"));
        project.setImages(images);
      }
      
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return images;
  }

  public int deleteImages(int projectID) {
    int result;
    
    try {
      
      CallableStatement st = con.prepareCall("{call deleteImage(?)}");
      st.setInt(1, projectID);
      
      st.execute();
      result = 1;
      
    } catch (SQLException e) {
      e.printStackTrace();
      result = 0;
    }
    return result;
  }

}
