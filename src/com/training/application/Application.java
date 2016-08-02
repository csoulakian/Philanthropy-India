package com.training.application;

import java.util.ArrayList;
import java.util.List;

import com.training.domain.CancerCure;
import com.training.domain.Donor;
import com.training.domain.OldAgeHome;
import com.training.domain.PrimaryEducation;
import com.training.domain.Project;
import com.training.domain.WebPortal;

public class Application {

  public static void main(String[] args) {

    WebPortal webPortal = new WebPortal();
    Project project1 = new CancerCure();
    project1.setName("Breast Cancer Cure");
    project1.setDescription("Help us cure cancer!");
    project1.setCost(100000.00);
    String[] images = { "www.google.com/image1", "www.google.com/image2" };
    project1.setImages(images);
    webPortal.createProject(project1);

    System.out.println("*****Project 1 Description*****");
    System.out.println(project1.getProjectDetails());

    System.out.println("*****Create 2 more projects*****");
    Project project2 = new PrimaryEducation("Local Primary Education Fund", "Help us fund primary education!", 75000);
    webPortal.createProject(project2);
    Project project3 = new OldAgeHome("Senior Living Home", "Help us fund old age homes!", 50000);
    webPortal.createProject(project3);

    System.out.println("*****3 donors donate*****");
    Donor donor1 = new Donor(101, "Manish", "man@abc.com", project1, 1275);
    Donor donor2 = new Donor(102, "Ramesh", "ram@abc.com", project3, 25000);
    Donor donor3 = new Donor(103, "Chrissy", "Chrissy@abc.com", project3, 10000);

    System.out.println("\n*****List available projects*****");
    printAllProjectDetails(webPortal.getListOfAvailableProjects());

    System.out.println("*****Donor 2 donates again to fully fund project*****\n");
    donor2.donate(15000);

    System.out.println("*****List available projects*****");
    printAllProjectDetails(webPortal.getListOfAvailableProjects());

    System.out.println("*****List all projects and donors*****");
    printAllProjectDonors(webPortal.listDonorsByProject());

    System.out.println("*****Print donors for Project 3*****");
    printProjectDonorsForProject(webPortal.listDonors(project3));

  }

  /**
   * Print the list of donors for a project
   */
  public static void printProjectDonorsForProject(ArrayList<Donor> listOfDonors) {
    if (listOfDonors.size() > 0) {
      System.out.println("\nList of Donors for Project " + listOfDonors.get(0).getSelectedProject().getName());
      System.out.println("-----------------");
      for (Donor donor : listOfDonors) {
        System.out.println(donor.getDonorDetails());
      }
    } else {
      System.out.println("Project with no donors :(");
      System.out.println("-----------------");
    }

  }

  /**
   * Print the list of all donors organized by project
   * 
   * @param listOfAllDonors
   *          all donors separated in arraylists by project
   */
  public static void printAllProjectDonors(List<ArrayList<Donor>> listOfAllDonors) {
    for (ArrayList<Donor> list : listOfAllDonors) {
      printProjectDonorsForProject(list);
    }
  }

  /**
   * Print the project details for all projects
   * 
   * @param projects
   *          array list of all the projects
   */
  public static void printAllProjectDetails(ArrayList<Project> projects) {
    for (Project project : projects) {
      System.out.println(project.getProjectDetails());
    }
  }

}
