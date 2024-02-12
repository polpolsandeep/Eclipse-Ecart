package com.sandeep.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.ecart.model.MainCategory;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory,Integer> {

}
