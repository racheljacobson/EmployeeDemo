package com.sw409.employeedemo.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sw409.employeedemo.models.Manager;
import com.sw409.employeedemo.services.ManagerService;

@RestController
public class ManagerController {
	@Autowired
	ManagerService manService;
	@GetMapping("api/manager")
	public ArrayList<Manager> getAllManagers() {
		return manService.getAllManagers();
	}
	
	@PostMapping("api/manager")
	public Manager addManager(@RequestBody Manager man) {
		return manService.addManager(man);
	}
	
	@PatchMapping("api/manager/{manid}") 
	public void updateManager(@PathVariable("manid") Integer id, @RequestBody Manager man) {
		manService.updateManager(id, man);
		
	}
	
	@DeleteMapping("api/manager/{manid}")
	public void deleteManager(@PathVariable("manid") Integer id) {
		manService.deleteManager(id);
	}

}
