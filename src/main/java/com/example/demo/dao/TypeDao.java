package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Type;

@Repository
public interface TypeDao extends JpaRepository<Type,Integer>{

}
