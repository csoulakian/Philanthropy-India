package com.training.domain;

/**
 * CancerCure is a specific type of Project and extends the abstract class
 * Project.
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
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          of project
   */
  public CancerCure(String name, String description, double cost) {
    super(name, description, cost);
  }

}
