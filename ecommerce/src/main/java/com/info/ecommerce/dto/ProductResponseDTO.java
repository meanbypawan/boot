package com.info.ecommerce.dto;

public class ProductResponseDTO {
  private int id;
  private String title;
  private int price;
  private String brand;
  private int categoryId;
  private String categoryName;
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getTitle() {
	return title;
  }
  public void setTitle(String title) {
	this.title = title;
  }
  public int getPrice() {
	return price;
  }
  public void setPrice(int price) {
	this.price = price;
  }
  public String getBrand() {
	return brand;
  }
  public void setBrand(String brand) {
	this.brand = brand;
  }
  public int getCategoryId() {
	return categoryId;
  }
  public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
  }
  public String getCategoryName() {
	return categoryName;
  }
  public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
  }

  
}
