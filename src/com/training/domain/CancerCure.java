package com.training.domain;

import com.training.entities.Project;

/**
 * CancerCure is a specific type of Project and extends the Project class.
 * 
 * @author csoulakian
 *
 */
public class CancerCure extends Project {

  /**
   * Empty constructor with no parameters.
   */
  public CancerCure() {
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
  public CancerCure(int projectID, String name, String description, double cost) {
    super(projectID, name, description, cost);
  }

}
