package com.sandeep.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.ecart.model.Admin;
import com.sandeep.ecart.repository.AdminRepository;

@Service
public class AdminService {
  @Autowired
  private AdminRepository adminRepository;
  
  public int loginAdmin(Admin admin) {
	  try {
	      return adminRepository.getAdminByUnameAndPass(admin.getUsername(),admin.getPassword(),admin.getStatus());
	  }
	  catch(Exception ex) {
		  System.err.println("Error Occured in loginAdmin: "+ex.getMessage()+"Cause"+ex.getCause());
	  }
	  return 0;
  }
}  