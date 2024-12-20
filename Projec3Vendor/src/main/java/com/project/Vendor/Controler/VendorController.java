package com.project.Vendor.Controler;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Vendor.Model.Vendor;
import com.project.Vendor.Services.VendorService;

@RestController
@RequestMapping("/cloudvendor")
public class VendorController {
	
	VendorService vendorServices;

	public VendorController(VendorService vendorServices) {
		super();
		this.vendorServices = vendorServices;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendor> getVendor(@PathVariable int id){
		
		Vendor vend=vendorServices.getVendor(id);
		return ResponseEntity.ok(vend);
	}
	
	@PostMapping
	public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor)
	{
		return new ResponseEntity<>(vendorServices.createVendor(vendor),HttpStatus.CREATED);
	}
	
}
