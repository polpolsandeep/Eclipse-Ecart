package com.sandeep.ecart.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sandeep.ecart.GenericResponse;
import com.sandeep.ecart.model.Category;
import com.sandeep.ecart.service.CategoryService;

@RestController
@RequestMapping("category")
@CrossOrigin("http://localhost:4200")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("add")
	public GenericResponse<Category> addCategory(@RequestParam Integer catId,@RequestParam String catName,
			@RequestParam String catDesc,@RequestParam String status,
			@RequestParam Integer mainCatId,@RequestParam MultipartFile catImage) throws IOException{
		Category category = new Category();
		if(catId!=null && catId!=0) {
			category.setCatId(catId);
		}
		if(catImage!=null) {
			category.setCatImg(Base64.getEncoder().encodeToString(catImage.getBytes()));
			category.setImageName(catImage.getOriginalFilename());
		} 
		category.setCatName(catName);
		category.setCatDesc(catDesc);
		category.setStatus(status);
		category.setMainCatId(mainCatId);
		Category response = categoryService.addCategory(category);
		if(response!=null) {
			return GenericResponse.<Category>builder().success(true).data(response).message("").build();
			//return new GenericResponse<Category>(true,response,"Category added successfully..!");
		}
		else {
			return GenericResponse.<Category>builder().success(false).data(response).message("").build();
		}
	}
	
	/*@PostMapping("add-category")
	public Category addCategory(@RequestBody Category category) {
		Category cat =categoryService.addCategory(category);
		if(cat!=null){
	  		return cat;
	  	}
		else {
			return null;
		}
	}*/
	@GetMapping("remove-category/{catId}")
	public String removeCategory(@PathVariable("catId") int catId) {
		if(categoryService.removeCategory(catId)) {
			return "Success";
		}
		else{
			return "Unsuccess";
		}
	}
	@GetMapping("/categories")
	public List<Category> getCategories(){
		return categoryService.getCategories();
	}
	@GetMapping("categories/{catId}")
	public Category getCategory(@PathVariable("catId") int catId) {
		return categoryService.getCategory(catId);
	}

}
