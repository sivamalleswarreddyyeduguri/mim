package com.zettamine.mi.service;


import java.util.List;

import com.zettamine.mi.entities.Vendor;

public interface VendorService {
         
	  void save(Vendor vendor);
	  List<Vendor> findAll();
	  Vendor getVendorById(Integer id);
//	  void update(Vendor vendor);
	void updateContact(Vendor vendor,Integer id);
	
}
