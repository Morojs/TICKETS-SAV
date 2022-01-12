package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TypeDao;
import com.example.demo.entity.Type;
@Service
public class TypeService {
	@Autowired
	private TypeDao typeDao;

	public void deleteById(Integer id) {
		typeDao.deleteById(id);
	}

	public List<Type> findAll() {
		return typeDao.findAll();
	}

	public Type findById(int id) {
		return typeDao.findById(id).get();
	}

	public Type save(Type type) {
		return typeDao.save(type);
	}
	
	

}
