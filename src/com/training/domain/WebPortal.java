package com.training.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A web portal that contains all the functionality needed to interact with
 * projects.
 * 
 * @author csoulakian
 *
 */
public class WebPortal {

  /**
   * array list of all the projects.
   */
  private ArrayList<Project> listOfProjects = new ArrayList<Project>();

  /**
   * Empty constructor.
   */
  public WebPortal() {
    super();
  }

  /**
   * Gets a list of available the projects.
   * 
   * @return array list of available projects
   */
  public ArrayList<Project> getListOfAvailableProjects() {
    ArrayList<Project> availableProjects = new ArrayList<Project>();
    for (Project project : listOfProjects) {
      if (project.getStatus().equals("not funded")) {
        availableProjects.add(project);
      }
    }
    return availableProjects;
  }

  /**
   * Add a particular project to the list of projects in the web portal.
   * 
   * @param project
   *          to be added
   * @return that was added
   */
  public Project createProject(Project project) {
    listOfProjects.add(project);
    return project;
  }

  /**
   * List all the donors organized by project.
   * 
   * @return list of array lists of donors
   */
  public List<ArrayList<Donor>> listDonorsByProject() {
    List<ArrayList<Donor>> allDonorsList = new ArrayList<ArrayList<Donor>>();
    for (Project project : listOfProjects) {
      allDonorsList.add(listDonors(project));
    }
    return allDonorsList;
  }

  /**
   * List the donors who donated to a specific project.
   * 
   * @param project
   *          to list all the donors
   * @return arraylist of donors for a particular project
   */
  public ArrayList<Donor> listDonors(Project project) {
    return project.listOfDonors;
  }

}
