package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Status;
import com.example.demo.service.StatusService;

@RestController
@RequestMapping("api/status")
public class StatusController {

	@Autowired
	private StatusService statusService;

	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('Admin')")
	public void deleteById(@PathVariable Integer id) {
		statusService.deleteById(id);
	}

	@GetMapping("")
	public List<Status> findAll() {
		return statusService.findAll();
	}

	@GetMapping("{id}")
	public Status findById(@PathVariable Integer id) {
		return statusService.findById(id);
	}
	@PostMapping("create")
	@PreAuthorize("hasRole('Admin')")
	public Status save(@RequestBody Status status) {
		return statusService.save(status);
	}

	@PostConstruct
	public void initStatus() {
		statusService.initStatus();
	}
	
	
	
	
}
