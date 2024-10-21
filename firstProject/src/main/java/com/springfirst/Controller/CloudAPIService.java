package com.springfirst.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springfirst.Model.CloudVendor;



@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIService {
    CloudVendor cloudVendor;
	@GetMapping("/{vendorId}")
	public CloudVendor getCloudVendor(String vendorId)
	{
		return cloudVendor;
//		return new CloudVendor("c1","Vendor1","Adress1","XXXXXX");
	}
	@PostMapping
	public String crateCloudVendor(@RequestBody CloudVendor cloudVendor)
	{
		this.cloudVendor = cloudVendor; 
		return "cloud vendor created successfully";
	}

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
    	this.cloudVendor = cloudVendor; 
		return "cloud vendor updated successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(String vendorId)
    {
    	this.cloudVendor = null; 
		return "cloud vendor deleted successfully";
    }
}
