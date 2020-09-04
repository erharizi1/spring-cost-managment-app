package com.crud.cost.managment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.cost.managment.entity.Expenses;
import com.crud.cost.managment.entity.Project;
import com.crud.cost.managment.repository.ExpensesRepository;
import com.crud.cost.managment.repository.ProjectRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TestController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private ExpensesRepository expensesRepo;
	
	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	
	
	@RequestMapping("/allprojects")
    public List<Project> getAllProjects() {
		List<Project> project = projectRepo.findAll();
        return project;
    }
	
	@RequestMapping("/allexpenses/{id}")
	public List<Expenses> getAllExpensesForProject(@Validated @PathVariable(value = "id") int projectid) {
		List<Expenses> expenses = expensesRepo.findByProjectId(projectid);
		return expenses;
	}
	
//	@RequestMapping("/project/{id}")
//	    public ResponseEntity<Project> getEmployeeById(@PathVariable(value = "id") Long projectId)
//	      //  throws ResourceNotFoundException 
//	{
//		Project project = projectRepo.findById(projectId)
//	     //     .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//	        return ResponseEntity.ok().body(project);
//	    }
//	
	
	@RequestMapping("/newproject")
	public Project createProject(@Validated @RequestBody Project project) {
		System.out.println(project);
		//new Project(project.getName(), project.getExpectedCost(),project.getNotes(), project.getStartingDate(), project.getEndDate())
		projectRepo.save(project);
		return project;
	}
	
	
	@RequestMapping("/project/{id}")
	public Project getProjectById(@PathVariable(value = "id") Long projectid) {
		
		Optional<Project> pr = projectRepo.findById(projectid);
		
		Project project = pr.get();

		
		return  project;
	}
	
	@RequestMapping("/expenses/{id}")
	public Expenses getExpensesById(@PathVariable(value = "id") Long expensesid) {
		
		Optional<Expenses> exp = expensesRepo.findById(expensesid);
		
		Expenses expenses = exp.get();
		
		return  expenses;
	}
	
	
	
	@PutMapping("/updateexpenses/{id}")
	public Expenses updateExpenses(@PathVariable(value = "id") Long expesesid , @Validated @RequestBody Expenses expensesDetails ) {
		
		Expenses exp = getExpensesById(expesesid);
		exp.setName(expensesDetails.getName());
		exp.setCost(expensesDetails.getCost());
		exp.setNotes(expensesDetails.getNotes());
		expensesRepo.save(exp);
		
		return  exp;
	}
	
	@PutMapping("/updateproject/{id}")
	public Project updateProject(@PathVariable(value = "id") Long projectid , @Validated @RequestBody Project projectDetails ) {
		
		Project pr = getProjectById(projectid);
		
		pr.setName(projectDetails.getName());
		pr.setExpectedCost(projectDetails.getExpectedCost());
		pr.setNotes(projectDetails.getNotes());
		pr.setEndDate(projectDetails.getEndDate());
		pr.setStartingDate(projectDetails.getStartingDate());
		pr.setLastModified(projectDetails.getLastModified());
		projectRepo.save(pr);
		
		return  pr;
	}
	
	
	
	@RequestMapping("/newexpenses")
	public Expenses createExpenses(@Validated @RequestBody  Expenses expenses) {
		
//		if(expenses.getProject() == null) {
//			expenses.setProject(getProjectById(projectid));
//		}
//		
		expensesRepo.save(expenses);
		return expenses;
		
	}
	
	@GetMapping("/projects/get")
	public Page<Project> getProjectPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		
		//Sort sort = new Sort(new Sort.Order(Direction.ASC, "nom"));
		Sort sort2 = Sort.by(Sort.Direction.ASC,"name");
		Pageable pageable =  PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"name"));
		
		
		return projectRepo.findAll(pageable);
		
	}
	
//	@GetMapping("/project/name")
//	public Page<Project> getProjectsByName(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
//		
//		Sort sort2 = Sort.by(Sort.Direction.ASC,"name");
//		Pageable pageable =  PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"name"));
//		
//		return  projectRepo.findAllByName(name, pageable) ;
//	}
	
	@GetMapping("/project/name")
	public List<Project> getProjectsByName(@RequestParam("name") String name) {
		
		
		return  projectRepo.findAllByName(name) ;
	}
	
	
	
	
	

}
