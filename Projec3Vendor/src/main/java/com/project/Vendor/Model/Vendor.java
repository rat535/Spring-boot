package com.project.Vendor.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="Vendor_Name")
	private String Vendorname;
	@Column
	private String Vendoraddress;
	@Column
	private String phoneno;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(int id, String vendorname, String vendoraddress, String phoneno) {
		super();
		this.id = id;
		Vendorname = vendorname;
		Vendoraddress = vendoraddress;
		this.phoneno = phoneno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendorname() {
		return Vendorname;
	}
	public void setVendorname(String vendorname) {
		Vendorname = vendorname;
	}
	public String getVendoraddress() {
		return Vendoraddress;
	}
	public void setVendoraddress(String vendoraddress) {
		Vendoraddress = vendoraddress;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	
	
}
