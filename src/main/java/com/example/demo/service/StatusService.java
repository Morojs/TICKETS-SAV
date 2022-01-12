package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StatusDao;
import com.example.demo.entity.Status;

@Service
public class StatusService {
	
	@Autowired
	private StatusDao statusDao;

	public void deleteById(Integer id) {
		statusDao.deleteById(id);
	}

	public List<Status> findAll() {
		return statusDao.findAll();
	}

	public Status findById(Integer id) {
		return statusDao.findById(id).get();
	}

	public Status save(Status status) {
		return statusDao.save(status);
	}
	  public void initStatus() {

		  Status status=new Status();
		  status.setLibelle("Actif");
		  status.setDescription("this is the default status of tickets");
		  statusDao.save(status);
	    }
	
	

}
