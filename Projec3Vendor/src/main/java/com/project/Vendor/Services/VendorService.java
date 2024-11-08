package com.project.Vendor.Services;

import com.project.Vendor.Model.Vendor;

public interface VendorService {

	Vendor createVendor(Vendor vendor);
	Vendor getVendor(Integer id);
	Vendor getAllVendors();
}
