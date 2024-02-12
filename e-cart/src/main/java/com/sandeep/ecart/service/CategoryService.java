package com.sandeep.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.Category;
import com.sandeep.ecart.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category addCategory(Category category) {
		try {
			return categoryRepository.save(category);
		}
		catch(Exception ex){
			System.err.println("Exception Occured In addCategory :"+ex.getMessage()+"Cause"+ex.getCause());
	    }
	   return null;
}
	public boolean removeCategory(int categoryId) {  /*For remove method*/
		try {
			categoryRepository.deleteById(categoryId);
			return true;
		}
		catch(Exception ex) {
			System.err.println("Exception Occured In removeCategory :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return false;
	} 
	public List<Category> getCategories(){       /*get All Data*/
		try {
			return categoryRepository.findAll();
		}
		catch(Exception ex) {
			System.err.println("Exception Occurred In getCategories :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return null;
	}
	public Category getCategory(int categoryId) {    /*get Single Data*/
		try {
			return categoryRepository.findById(categoryId).get();
		}
		catch(Exception ex) {
			System.err.println("Exception Occured In getCategory :"+ex.getMessage()+"Cause"+ex.getCause());
		}
		return null;
	}

}
