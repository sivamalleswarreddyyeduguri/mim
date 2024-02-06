package com.zettamine.mi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.mi.entities.Vendor;
import com.zettamine.mi.service.VendorServiceImpl;

@Controller

public class VendorController {
	
	 VendorServiceImpl serviceImpl;
	 
	  public VendorController(VendorServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}

	@GetMapping("/vendor")
	  public String vendorForm(Model model) {
		  model.addAttribute("vendor", new Vendor());

			return "vendor";
	  }
	  
	@PostMapping("/data")
	public String addVendor(Vendor vendor, Model model, Integer id) {
		System.out.println(id);
		if(id == null) {
	    serviceImpl.save(vendor);
	    model.addAttribute("success", "Vendor Saved Successfully!!!!");
	    model.addAttribute("vendor", new Vendor());
	    return "vendor";
	   }
		else {
			serviceImpl.updateContact(vendor,id);
			model.addAttribute("updated", "Updated successfully");
			model.addAttribute("vendor",new Vendor());
			return "vendor";
		}
		
	}


	
	@GetMapping("/view")
	public String viewVendors(Model model) {
		
		  List<Vendor> vendor = serviceImpl.findAll();   
		  model.addAttribute("vendors",vendor);
		  return "view-vendor";
	}
	
	@GetMapping("/edit/{vendorId}")
	public String vendorUpdating(@PathVariable ("vendorId") Integer cid, Model model) {
		 Vendor vendor = serviceImpl.getVendorById(cid);
		    
		    if (vendor != null) {
		    	 addVendor(vendor, model, cid);
		        model.addAttribute("vendor", vendor);
		      
		    } else {
		        model.addAttribute("vendor", new Vendor());
		    }
		    
		    return "vendor";
	}

	
	
	@GetMapping("/delete/{vendorId}")
	public String softDeleting(@PathVariable ("vendorId") Integer id, Model model) {
		serviceImpl.deleteById(id);
		 List<Vendor> updatedVendors = serviceImpl.findAll();
		 model.addAttribute("vendors", updatedVendors);
		return "view-vendor";
	}

}
