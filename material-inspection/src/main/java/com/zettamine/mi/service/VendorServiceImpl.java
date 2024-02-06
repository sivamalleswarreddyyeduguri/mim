package com.zettamine.mi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.zettamine.mi.entities.Vendor;
import com.zettamine.mi.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository repository;

    public VendorServiceImpl(VendorRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public void save(Vendor vendor) {
    	vendor.setVendorName(vendor.getVendorName().toLowerCase());
        vendor.setState(vendor.getState().toLowerCase());
        vendor.setCity(vendor.getCity().toLowerCase());	
        repository.save(vendor);
        
    }

	@Override
	public List<Vendor> findAll() {
		  
		return repository.findAll();
	}

	public Vendor findById(Integer vendorId) {
		
		return repository.findById(vendorId).orElse(null);
	}


	public boolean deleteById(Integer cid) {
		
			 Optional<Vendor> vendor = repository.findById(cid);
			if(vendor.isPresent()) {
			     Vendor softDel = vendor.get();
				 softDel.setStatus("in active");
				repository.save(softDel);
				return true;
			}
		return false;
	}

	public Vendor getVendorById(Integer id) {
	
		Optional<Vendor> findById = repository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public void updateContact(Vendor vendor,Integer id) {
	    if (id != null) {
	        vendor.setVendorId(id);
	        vendor.setVendorName(vendor.getVendorName().toLowerCase());
	        vendor.setState(vendor.getState().toLowerCase());
	        vendor.setCity(vendor.getCity().toLowerCase());
	        repository.save(vendor);
	    }
	}
}

