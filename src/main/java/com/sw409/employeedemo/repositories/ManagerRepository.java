package com.sw409.employeedemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sw409.employeedemo.models.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {

}
