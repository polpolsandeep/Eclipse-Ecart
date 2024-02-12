package com.sandeep.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.MainCategory;
import com.sandeep.ecart.repository.MainCategoryRepository;

@Service
public class MainCategoryService {
	
	@Autowired
	private MainCategoryRepository mainCategoryRepository;
	
	public MainCategory addMainCategory(MainCategory mainCat) {
		try {
			mainCategoryRepository.save(mainCat);
		}
		catch(Exception px) {
			System.err.println("Exception Occured In addMainCategory :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}
	public boolean removeMainCategory(int mainCatId) {
		try {
			mainCategoryRepository.deleteById(mainCatId);
			return true;
		}
		catch(Exception px) {
			System.err.println("Exception Occured In removeMainCategory :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return false;
	}
	public List<MainCategory> getAllMainCategories(){
		try {
			mainCategoryRepository.findAll();
		}
		catch(Exception px) {
			System.err.println("Exception Occured In getAllMainCategory :"+px.getMessage()+"Cause :"+px.getCause());
		}
		return null;
	}

}
