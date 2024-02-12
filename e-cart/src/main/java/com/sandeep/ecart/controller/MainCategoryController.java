package com.sandeep.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ecart.GenericResponse;
import com.sandeep.ecart.model.MainCategory;
import com.sandeep.ecart.service.MainCategoryService;

@RestController
@RequestMapping("main-category")
@CrossOrigin("http://localhost:4200")
public class MainCategoryController {
	@Autowired
	private MainCategoryService mainCategoryService;
	
	@PostMapping("add")
	public GenericResponse<MainCategory> addMainCategory(@RequestBody MainCategory mainCategory){
		MainCategory mainCat = mainCategoryService.addMainCategory(mainCategory);
		if(mainCat!=null) {
		return GenericResponse.<MainCategory>builder()
				.success(true)
				.data(mainCat)
				.message("Main Category Added SuccessFully")
				.build();
		}
		else {
			return GenericResponse.<MainCategory>builder()
					.success(false)
					.data(mainCat)
					.message("Main Category not Added..! Try again")
					.build();
			
		}
	}
	@GetMapping("remove/{maiCatId}")
	public GenericResponse<Boolean> removeMainCategory(@PathVariable int mainCatId){
		if(mainCategoryService.removeMainCategory(mainCatId)) {
			return GenericResponse.<Boolean>builder()
					.success(true)
					.data(true)
					.message("Main Category deleted SuccessFully.....!")
					.build();
		}
		else {
			return GenericResponse.<Boolean>builder()
					.success(true)
					.data(true)
					.message("Main Category Not deleted Try Again..!")
					.build();
		}
	}
	@GetMapping("all")
	public GenericResponse<List<MainCategory>> getAllMainCategories(){
		List<MainCategory> list = mainCategoryService.getAllMainCategories();
		if(list!=null) {
			return GenericResponse.<List<MainCategory>>builder()
					.success(true)
					.data(list)
					.message("")
					.build();
		}
		else {
			return GenericResponse.<List<MainCategory>>builder()
					.success(true)
					.data(null)
					.message("")
					.build();
		}
	}

}
