package com.training.services;

import java.util.ArrayList;

import com.training.DAOs.DonorDAO;
import com.training.DAOs.ProjectDAO;
import com.training.entities.Donor;
import com.training.entities.Project;

public class DonorService {

  private DonorDAO donorDAO = new DonorDAO();
  private ProjectService projectService = new ProjectService();
  
  public int addDonor(Donor donor) {
    
    try {
      return donorDAO.add(donor);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return 0;
    
  }
  
  public int deleteDonor(int donorID) {
    
    try {
      return donorDAO.delete(donorID);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return 0;
    
  }
  
  public Donor getDonor(int donorID) {
    
    try {
      Donor donor = donorDAO.find(donorID);
      // only selectedProjectID has been set, look up rest of project info 
      // in projectDAO based on ID before returning donor
      donor.setSelectedProject(projectService.getProject(donor.getSelectedProject().getProjectID()));
      return donor;
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
  public ArrayList<Donor> getAllDonors() {
    
    try {
      ArrayList<Donor> listOfDonors = donorDAO.findAll();
      for(Donor donor : listOfDonors) {
        donor.setSelectedProject(projectService.getProject(donor.getSelectedProject().getProjectID()));
      }
      return listOfDonors;
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
  public void donate(Donor donor, double newDonation) {
    
    double oldAmountDonated = donor.getAmountDonated();
    donor.setAmountDonated(oldAmountDonated + newDonation);
    
    try {
      donorDAO.updateAmountDonated(donor.getDonorID(), donor.getAmountDonated());
      projectService.acceptDonation(donor.getSelectedProject(), newDonation);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  
}
