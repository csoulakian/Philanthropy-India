package com.training.services;

import com.training.DAOs.ImageDAO;
import com.training.entities.Images;
import com.training.entities.Project;

public class ImageService {

  private ImageDAO imageDAO = new ImageDAO(); 
  
  public int addImages(int projectID, Images imagesToAdd) {
    try {
      return imageDAO.addImages(projectID, imagesToAdd);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return 0;
  }
  
  public Images getImagesForProject(Project project) {
    try {
      return imageDAO.findImages(project);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
  public int deleteImages(int projectID) {
    try {
      return imageDAO.deleteImages(projectID);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return 0;
  }
}
