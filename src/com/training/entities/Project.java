package com.training.entities;

import java.util.ArrayList;

/**
 * A class called Project contains all the functionality of any type of project.
 * Concrete classes that extend Project are CancerCure, PrimaryEducation, and
 * OldAgeHome.
 * 
 * @author csoulakian
 *
 */
public class Project {

  /**
   * ID of the project
   */
  public int projectID;
  /**
   * name of project
   */
  public String name;
  /**
   * description of project
   */
  public String description;
  /**
   * status of project - "funded" or "not funded"
   */
  public String status;
  /**
   * Images represented by 3 strings in Images class
   */
  public Images images;
  /**
   * cost of project
   */
  public double cost;
  /**
   * amount collected in donations for a project
   */
  public double amountCollected = 0;
  /**
   * amount left to be collected
   */
  public double pendingAmount;
  /**
   * array list of donors that have contributed towards a project
   */
  public ArrayList<Donor> listOfDonors = new ArrayList<Donor>();

  /**
   * Constructor with no arguments.
   */
  public Project() {
    super();
  }

  /**
   * Constructor with field arguments.
   * 
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          total cost of project
   */
  public Project(int projectID, String name, String description, double cost) {
    super();
    this.projectID = projectID;
    this.name = name;
    this.description = description;
    this.cost = cost;
  }

  
  
  /**
   * Get the projectID.
   * 
   * @return the projectID
   */
  public int getProjectID() {
    return projectID;
  }

  /**
   * Set the projectID.
   * 
   * @param projectID the projectID to set
   */
  public void setProjectID(int projectID) {
    this.projectID = projectID;
  }

  /**
   * Get the name of the project.
   * 
   * @return name of project
   */
  public String getName() {
    return this.name;
  }

  /**
   * Set the name of the project.
   * 
   * @param name
   *          of project
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the description of the project.
   * 
   * @return description of project
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the project.
   * 
   * @param description
   *          of project
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * Set the status of the project.
   * 
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Get the status of project - "funded" or "not funded"
   * If the pending amount is 0 and the
   * cost of the project has already been set (ensuring an accurate pending
   * amount), set the status to "funded". Otherwise, the project is
   * "not funded."
   * 
   * @return status of project
   */
  public String getStatus() {
    if (getPendingAmount() <= 0 && cost > 0) {
      status = "funded";
    } else {
      status = "not funded";
    }
    return status;
  }

  /**
   * Get the Images object.
   * 
   * @return Images of project
   */
  public Images getImages() {
    return images;
  }

  /**
   * Set the Images for the project
   * 
   * @param images 3 strings
   */
  public void setImages(Images images) {
    this.images = images;
  }

  /**
   * Get the cost of the project.
   * 
   * @return cost of project
   */
  public double getCost() {
    return cost;
  }

  /**
   * Set the cost of the project.
   * 
   * @param cost
   *          of project
   */
  public void setCost(double cost) {
    this.cost = cost;
  }

  /**
   * Get the total amount collected for a project.
   * 
   * @return amount collected
   */
  public double getAmountCollected() {
    return amountCollected;
  }

  /**
   * Set the amount collected by taking in a single donation.
   * 
   * @param amountCollected
   *          from a donation
   */
  public void setAmountCollected(double amountCollected) {
    this.amountCollected = amountCollected;
  }

  /**
   * Set the pending amount.
   * 
   * @param pendingAmount the pendingAmount to set
   */
  public void setPendingAmount(double pendingAmount) {
    this.pendingAmount = pendingAmount;
  }
  
  /**
   * Get the pending amount, the amount waiting to be collected.
   * 
   * @return pending amount
   */
  public double getPendingAmount() {
    pendingAmount = cost - amountCollected;
    return pendingAmount;
  }

  /**
   * Get the array list of donors for a project.
   * 
   * @return array list of donors
   */
  private ArrayList<Donor> getListOfDonors() {
    return listOfDonors;
  }

  /**
   * Add a donor to the array list of donors.
   * 
   * @param donor
   *          to be added
   */
  public void addDonor(Donor donor) {
    listOfDonors.add(donor);
  }

  /**
   * Return the project details as a StringBuilder.
   * 
   * @return StringBuilder of project details
   */
  public StringBuilder getProjectDetails() {
    StringBuilder details = new StringBuilder();
    details.append("Project: " + getProjectID() + " " + getName() + "\nDescription: " + getDescription() + "\nCost: $" + getCost());
    details.append("  Amount Collected: $" + getAmountCollected() + "\nPending Amount: $" + getPendingAmount());
    details.append("  Status: " + getStatus() + "\nImages: ");
    if (getImages().getImage1().length() > 0) {
      details.append(getImages().getImage1() + "\n");
      details.append(getImages().getImage2() + "\n");
      details.append(getImages().getImage3() + "\n");
    } else {
      details.append("none");
    }
    details.append("\n");
    return details;
  }

}
