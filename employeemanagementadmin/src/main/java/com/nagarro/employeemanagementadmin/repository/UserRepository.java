package com.nagarro.employeemanagementadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.employeemanagementadmin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
