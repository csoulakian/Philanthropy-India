package com.training.domain;

import java.util.ArrayList;

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
   * Gets a list of all the projects.
   * 
   * @return array list of projects
   */
  public ArrayList<Project> getListOfProjects() {
    return listOfProjects;
  }

  /**
   * Create an empty CancerCure project and add it to the list of projects.
   * 
   * @return CancerCure project that was created
   */
  public Project createCancerCureProject() {
    Project project = new CancerCure();
    listOfProjects.add(project);
    return project;
  }

  /**
   * Create a new CancerCure project and specify the name, description, and cost
   * of project.
   * 
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          of project
   * @return CancerCure project that was created
   */
  public Project createCancerCureProject(String name, String description, double cost) {
    Project project = new CancerCure(name, description, cost);
    listOfProjects.add(project);
    return project;
  }

  /**
   * Create an empty PrimaryEducation project and add it to the list of
   * projects.
   * 
   * @return PrimaryEducation project that was created
   */
  public Project createPrimaryEdProject() {
    Project project = new CancerCure();
    listOfProjects.add(project);
    return project;
  }

  /**
   * Create a new PrimaryEducation project and specify the name, description,
   * and cost of project.
   * 
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          of project
   * @return PrimaryEducation project that was created
   */
  public Project createPrimaryEdProject(String name, String description, double cost) {
    Project project = new CancerCure(name, description, cost);
    listOfProjects.add(project);
    return project;
  }

  /**
   * Create an empty OldAgeHome project and add it to the list of projects.
   * 
   * @return OldAgeHome project that was created
   */
  public Project createOldAgeHomeProject() {
    Project project = new CancerCure();
    listOfProjects.add(project);
    return project;
  }

  /**
   * Create a new OldAgeHome project and specify the name, description, and cost
   * of project.
   * 
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          of project
   * @return OldAgeHome project that was created
   */
  public Project createOldAgeHomeProject(String name, String description, double cost) {
    Project project = new CancerCure(name, description, cost);
    listOfProjects.add(project);
    return project;
  }

  /**
   * List all the available projects (projects that are not funded) and print
   * the details of those projects.
   */
  public void listAvailableProjects() {
    for (Project project : getListOfProjects()) {
      if (project.getStatus().equals("not funded")) {
        project.printProjectDetails();
      }
    }
  }

  /**
   * List all the donors organized by project.
   */
  public void listDonorsByProject() {
    for (Project project : getListOfProjects()) {
      project.printProjectDonors();
    }
  }

  /**
   * List the donors who donated to a specific project.
   * 
   * @param project
   *          to list all the donors
   */
  public void listDonors(Project project) {
    project.printProjectDonors();
  }

}
