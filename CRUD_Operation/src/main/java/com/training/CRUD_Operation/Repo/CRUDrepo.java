package com.training.CRUD_Operation.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.CRUD_Operation.Entity.CRUDentity;

public interface CRUDrepo extends JpaRepository<CRUDentity,Integer> {
	

}
