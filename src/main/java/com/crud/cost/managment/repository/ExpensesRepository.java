package com.crud.cost.managment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.cost.managment.entity.Expenses;

@Repository
public interface ExpensesRepository  extends JpaRepository<Expenses, Long> {

	List<Expenses> findByProjectId(int projectid);
	Optional<Expenses>  findById(Long expId);

}
