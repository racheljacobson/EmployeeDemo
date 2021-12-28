package com.sw409.employeedemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw409.employeedemo.models.Manager;
import com.sw409.employeedemo.repositories.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	ManagerRepository manRepo;
	
	List<Manager> manList = new ArrayList<>();
	
	public ArrayList<Manager> getAllManagers() {
		return (ArrayList<Manager>) manRepo.findAll();
		
	}
	
	public Manager addManager(Manager man) {
		manList.add(man);
		return manRepo.save(man);
	}
	
	public void updateManager(Integer id, Manager man) {
		Manager oldInfo = manRepo.findById(id).get();
		oldInfo.setEmployees(man.getEmployees());
		manRepo.save(man);
	}
	
	public void deleteManager(Integer id) {
		manRepo.deleteById(id);
	}

}
