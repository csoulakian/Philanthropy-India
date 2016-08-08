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
public class Image {
  
  private String imageURL;

  /**
   * Empty constructor.
   */
  public Image() {
    super();
  }

  /**
   * Constructor using imageURL field.
   * 
   * @param imageURL
   */
  public Image(String imageURL) {
    super();
    this.imageURL = imageURL;
  }

  /**
   * Get the image URL.
   * 
   * @return the imageURL
   */
  public String getImageURL() {
    return imageURL;
  }

  /**
   * Set the image URL.
   * 
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }
  
}
