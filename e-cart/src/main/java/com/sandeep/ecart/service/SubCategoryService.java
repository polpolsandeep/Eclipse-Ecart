package com.sandeep.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.SubCategory;
import com.sandeep.ecart.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	public SubCategory addSubCategory(SubCategory subCategory) {
		try {
			return subCategoryRepository.save(subCategory);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In addSubCategory :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public boolean removeSubCategory(int subCatId) {
		try {
			subCategoryRepository.deleteById(subCatId);
			return true;
		}
		catch(Exception px) {
			System.err.println("Exception Occured In removeSubCategory :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return false;
		
	}
	public List<SubCategory> getAllSubCategories(){
		try {
			return subCategoryRepository.findAll();
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getAllSubCategory :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public List<SubCategory> getAllSubCategoriesByCatId(int catId){
		try {
			return subCategoryRepository.findByCatId(catId);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getAllSubCategoriesByCatId :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}

}
