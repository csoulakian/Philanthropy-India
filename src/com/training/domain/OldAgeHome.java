package com.training.domain;

/**
 * OldAgeHome is a specific type of Project and extends the abstract class
 * Project.
 * 
 * @author csoulakian
 *
 */
public class OldAgeHome extends Project {

  /**
   * Empty constructor with no parameters.
   */
  public OldAgeHome() {
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
  public OldAgeHome(String name, String description, double cost) {
    super(name, description, cost);
  }

}
