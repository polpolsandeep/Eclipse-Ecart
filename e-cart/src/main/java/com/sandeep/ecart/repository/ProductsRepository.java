package com.sandeep.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sandeep.ecart.model.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
	@Query(nativeQuery=true,value="select * from products where sub_cat_id=subCatId")
	public List<Products> findBySubCatId(@Param("subCatId") Integer subCatId);

}
