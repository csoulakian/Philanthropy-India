package com.training.services;

import java.util.ArrayList;

import com.training.DAOs.ImageDAO;
import com.training.DAOs.ProjectDAO;
import com.training.entities.Project;

public class ProjectService {

  private ProjectDAO projectDAO = new ProjectDAO();
  private ImageDAO imageDAO = new ImageDAO();
  
  public int addProject(Project project) {
    
    try {
      if (project.getImages().getImage1().length() > 0) {
        imageDAO.addImages(project.getProjectID(), project.getImages());
      }
      return projectDAO.add(project);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return 0;
    
  }
  
  public int deleteProject(int projectID) {
    
    try {
      return projectDAO.delete(projectID);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return 0;
    
  }
  
  public Project getProject(int projectID) {
    
    try {
      return projectDAO.find(projectID);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
  public ArrayList<Project> getAllProjects() {
    
    try {
      return projectDAO.findAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
  public void acceptDonation(Project project, double newDonation) {
    
    double oldAmountCollected = getProject(project.getProjectID()).getAmountCollected();
    project.setAmountCollected(oldAmountCollected + newDonation);
    
    try {
      
      projectDAO.updateAmountCollected(project.getProjectID(), project.getAmountCollected());
      projectDAO.updatePendingAmount(project.getProjectID(), project.getPendingAmount());
      projectDAO.updateStatus(project.getProjectID(), project.getStatus());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
}
