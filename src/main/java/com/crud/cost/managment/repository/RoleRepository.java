package com.crud.cost.managment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.cost.managment.entity.ERole;
import com.crud.cost.managment.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);

}
