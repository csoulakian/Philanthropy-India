package com.training.application;

import com.training.domain.Donor;
import com.training.domain.Project;
import com.training.domain.WebPortal;

public class Application {

  public static void main(String[] args) {

    WebPortal webPortal = new WebPortal();
    Project project1 = webPortal.createCancerCureProject();
    project1.setName("Breast Cancer Cure");
    project1.setDescription("Help us cure cancer!");
    project1.setCost(100000.00);
    String[] images = { "www.google.com/image1", "www.google.com/image2" };
    project1.setImages(images);

    System.out.println("*****Project 1 Description*****");
    project1.printProjectDetails();

    Project project2 = webPortal.createPrimaryEdProject("Local Primary Education Fund",
        "Help us fund primary education!", 75000);
    Project project3 = webPortal.createOldAgeHomeProject("Senior Living Home", "Help us fund old age homes!", 50000);

    System.out.println("*****3 donors donate*****");
    Donor donor1 = new Donor(101, "Manish", "man@abc.com", project1, 1275);
    Donor donor2 = new Donor(102, "Ramesh", "ram@abc.com", project3, 25000);
    Donor donor3 = new Donor(103, "Chrissy", "Chrissy@abc.com", project3, 10000);

    System.out.println("\n*****List available projects*****");
    webPortal.listAvailableProjects();

    System.out.println("*****Donor 2 donates again to fully fund project*****");
    donor2.donate(15000);

    System.out.println("*****List available projects*****");
    webPortal.listAvailableProjects();

    System.out.println("*****List all projects and donors*****");
    webPortal.listDonorsByProject();

    System.out.println("*****Print donors for Project 3*****");
    webPortal.listDonors(project3);

  }

}
