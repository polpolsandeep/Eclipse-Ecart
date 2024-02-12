package com.sandeep.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sandeep.ecart.model.SubCategory;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
	
	@Query(nativeQuery = true, value="select * from sub_category where cat_id=:cat_id and status='active'")
	public List<SubCategory> findByCatId(@Param("catId") Integer catId);

}
