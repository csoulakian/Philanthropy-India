/**
 * 
 */
package com.training.entities;

/**
 * Each project has an ArrayList of images.
 * 
 * @author csoulakian
 *
 */
public class Images {
  
  private String image1 = "";
  private String image2 = "";
  private String image3 = "";
  
  /**
   * Empty constructor.
   */
  public Images() {
    super();
  }

  /**
   * Constructor using 1 imageURL.
   * 
   * @param image1
   */
  public Images(String image1) {
    super();
    this.image1 = image1;
  }

  /**
   * Constructor using 2 imageURLs.
   * 
   * @param image1
   * @param image2
   */
  public Images(String image1, String image2) {
    super();
    this.image1 = image1;
    this.image2 = image2;
  }

  /**
   * Constructor using 3 imageURLs.
   * 
   * @param image1
   * @param image2
   * @param image3
   */
  public Images(String image1, String image2, String image3) {
    super();
    this.image1 = image1;
    this.image2 = image2;
    this.image3 = image3;
  }

  /**
   * Get image1.
   * 
   * @return the image1
   */
  public String getImage1() {
    return image1;
  }

  /**
   * Set image1.
   * 
   * @param image1 the image1 to set
   */
  public void setImage1(String image1) {
    this.image1 = image1;
  }

  /**
   * Get image2.
   * 
   * @return the image2
   */
  public String getImage2() {
    return image2;
  }

  /**
   * Set image2.
   * 
   * @param image2 the image2 to set
   */
  public void setImage2(String image2) {
    this.image2 = image2;
  }

  /**
   * Get image3.
   * 
   * @return the image3
   */
  public String getImage3() {
    return image3;
  }

  /**
   * Set image3.
   * 
   * @param image3 the image3 to set
   */
  public void setImage3(String image3) {
    this.image3 = image3;
  }
  
}
