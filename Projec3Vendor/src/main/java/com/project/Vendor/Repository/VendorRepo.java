package com.project.Vendor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Vendor.Model.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer> {

}
