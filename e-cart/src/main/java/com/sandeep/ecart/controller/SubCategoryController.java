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
import com.sandeep.ecart.model.SubCategory;
import com.sandeep.ecart.service.SubCategoryService;

@RestController
@RequestMapping("sub-category")
@CrossOrigin("http://localhost:4200")
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@PostMapping("add")
	public GenericResponse<SubCategory> addSubCategory(@RequestParam Integer subCatId,
			@RequestParam String catName,@RequestParam String catDesc,
			@RequestParam MultipartFile catImage,@RequestParam String imageName,@RequestParam Integer catId,@RequestParam String status) throws IOException{
		SubCategory subCategory = new SubCategory();
		if(subCatId !=0) {
			subCategory.setSubCatId(subCatId);
		}
		subCategory.setCatName(catName);
		subCategory.setCatDesc(catDesc);
		if(catImage !=null) {
			subCategory.setCatImage(Base64.getEncoder().encodeToString(catImage.getBytes()));
			subCategory.setImageName(catImage.getOriginalFilename());
		}
		subCategory.setCatId(catId);
		subCategory.setStatus(status);
		SubCategory response = subCategoryService.addSubCategory(subCategory);
		if(response != null) {
			return GenericResponse.<SubCategory>builder().success(true).data(response).message("SubCategory Added SuccessFully..").build();
		}
		else {
			return GenericResponse.<SubCategory>builder().success(false).data(null).message("SubCategory Not Added Try Again!..").build();
		}	
	}
	@GetMapping("remove/{subcatId}")
	public GenericResponse<Boolean> removeSubCategory(@PathVariable("subcatId")int subCatId){
		if(subCategoryService.removeSubCategory(subCatId)) {
			return GenericResponse.<Boolean>builder().success(true).data(true).message("Sub-Category Data Remove SuccessFully!..").build();
		}	
		else {
			return GenericResponse.<Boolean>builder().success(false).data(false).message("Sub-Category Data Not Remove Try Again!..").build();
		}
			
	}
	@GetMapping("/all")
	public GenericResponse<List<SubCategory>> getSubCategories(){
		List<SubCategory> response= subCategoryService.getAllSubCategories();
		if(response !=null) {
			return GenericResponse.<List<SubCategory>>builder().success(true).data(response).message("subCategory Get All Data SuccessFully!..").build();
		}else {
			return GenericResponse.<List<SubCategory>>builder().success(false).data(response).message("No Record Found Please Try Again!..").build();
		}
	}
	@GetMapping("by-ref-id/{catId}")
	public GenericResponse<List<SubCategory>> getSubCategoryByCatId(@PathVariable("catId")int catId){
		List<SubCategory> response = subCategoryService.getAllSubCategoriesByCatId(catId);
		if(response !=null && !response.isEmpty()) {
			return GenericResponse.<List<SubCategory>>builder().success(true).data(response).message("Get the All Data..").build();
		}
		else {
			return GenericResponse.<List<SubCategory>>builder().success(false).data(null).message("Record Not Found Try Again..").build();
		}
	}
	
}
