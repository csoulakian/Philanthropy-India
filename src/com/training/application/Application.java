package com.training.application;

import java.util.ArrayList;
import java.util.List;

import com.training.DAOs.*;
import com.training.domain.*;
import com.training.entities.Donor;
import com.training.entities.Image;
import com.training.entities.Project;
import com.training.services.DonorService;
import com.training.services.ProjectService;
import com.training.utils.MySQLConnection;

public class Application {

  public static void main(String[] args) {

    System.out.println(MySQLConnection.getMyOracleConnection() + "\n");
    
    WebPortal webPortal = new WebPortal();
    Project project1 = new CancerCure();
    project1.setProjectID(201);
    project1.setName("Breast Cancer Cure");
    project1.setDescription("Help us cure cancer!");
    project1.setCost(100000.00);
    Image img1 = new Image("www.google.com/image1");
    Image img2 = new Image("www.google.com/image2");
    ArrayList<Image> imagesList = new ArrayList<>();
    imagesList.add(img1);
    imagesList.add(img2);
    project1.setImages(imagesList);
    
    
    DonorService donorService = new DonorService();
    
    Donor d1 = new Donor(501, "Ramesh", "man@abc.com", project1, 50);
    donorService.donate(d1, 700000);
    

/*    System.out.println("*****Project 1 Description*****");
    System.out.println(project1.getProjectDetails());

    System.out.println("*****Create 2 more projects*****");
    Project project2 = new PrimaryEducation(102, "Local Primary Education Fund", "Help us fund primary education!", 75000);
    webPortal.createProject(project2);
    Project project3 = new OldAgeHome(103, "Senior Living Home", "Help us fund old age homes!", 50000);
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
    printProjectDonorsForProject(webPortal.listDonors(project3));*/

  }

/*  *//**
   * Print the list of donors for a project
   *//*
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

  }*/

  /**
   * Print the list of all donors.
   * 
   * @param listOfAllDonors
   *          all donors in arraylist
   */
  public static void printAllProjectDonors(ArrayList<Donor> listOfAllDonors) {
    for (Donor donor : listOfAllDonors) {
      System.out.println(donor.getDonorDetails());
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
