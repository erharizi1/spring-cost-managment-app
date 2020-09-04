package com.crud.cost.managment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.cost.managment.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	
	Project save(Project p);
	Optional<Project> findById(Long id);
	Page<Project> findAll(Pageable pageable);
	
//	@Query("SELECT p FROM Project p WHERE p.name=:name")
//	Page<Project> findAllByName(String name ,Pageable pageable);
	
	@Query("SELECT p FROM Project p WHERE p.name Like %:name%")
	List<Project> findAllByName(String name);
}
