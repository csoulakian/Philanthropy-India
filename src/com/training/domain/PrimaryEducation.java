package com.training.domain;

import com.training.entities.Project;

/**
 * PrimaryEducation is a specific type of Project and extends the Project class.
 * 
 * @author csoulakian
 *
 */
public class PrimaryEducation extends Project {

  /**
   * Empty constructor with no parameters.
   */
  public PrimaryEducation() {
    super();
  }

  /**
   * Constructor taking in the parameters required to make a project.
   * 
   * @param projectID
   *          ID of project
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          of project
   */
  public PrimaryEducation(int projectID, String name, String description, double cost) {
    super(projectID, name, description, cost);
  }

}
