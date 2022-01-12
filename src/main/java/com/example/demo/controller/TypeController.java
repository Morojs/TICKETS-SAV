package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Type;
import com.example.demo.service.TypeService;

@RestController
@RequestMapping("api/types")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('Admin')")
	public void deleteById(@PathVariable Integer id) {
		typeService.deleteById(id);
	}
	@GetMapping("")
	public List<Type> findAll() {
		return typeService.findAll();
	}
	@GetMapping("{id}")
	public Type findById(@PathVariable Integer id) {
		return typeService.findById(id);
	}
	@PostMapping("create")
	@PreAuthorize("hasRole('Admin')")
	public Type save(@RequestBody Type type) {
		return typeService.save(type);
	}
	
	
}
