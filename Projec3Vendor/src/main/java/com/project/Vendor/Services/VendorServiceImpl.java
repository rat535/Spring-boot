package com.project.Vendor.Services;

import org.springframework.stereotype.Service;

import com.project.Vendor.Model.Vendor;
import com.project.Vendor.Repository.VendorRepo;

@Service
public class VendorServiceImpl implements  VendorService{

	VendorRepo vendorrepo;
	
	public VendorServiceImpl(VendorRepo vendorrepo) {
		super();
		this.vendorrepo = vendorrepo;
	}

	@Override
	public Vendor createVendor(Vendor vendor) {
	
        return vendorrepo.save(vendor);
		
	}

	@Override
	public Vendor getVendor(Integer id) {
		
		return vendorrepo.findById(id).orElseThrow(()->new RuntimeException("Accound does not exists"));
	}

	@Override
	public Vendor getAllVendors() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
