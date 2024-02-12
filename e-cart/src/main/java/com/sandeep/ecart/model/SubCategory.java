package com.sandeep.ecart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="sub_category")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_description")
	private String catDesc;
	
	@Lob
	@Column(name="cat_image")
	private String catImage;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="status")
	private String status;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getCatImage() {
		return catImage;
	}

	public void setCatImage(String catImage) {
		this.catImage = catImage;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
