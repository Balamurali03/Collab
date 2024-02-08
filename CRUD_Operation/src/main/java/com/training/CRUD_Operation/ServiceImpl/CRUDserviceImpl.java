package com.training.CRUD_Operation.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.CRUD_Operation.Entity.CRUDentity;
import com.training.CRUD_Operation.Repo.CRUDrepo;
import com.training.CRUD_Operation.Service.CRUDservice;

@Service
public class CRUDserviceImpl implements CRUDservice{

	@Autowired
	private CRUDrepo crudrepo;
	
	public String SaveCRUD(CRUDentity crud) {
		CRUDentity c=new CRUDentity();
		c.setId(crud.getId());
		c.setName(crud.getName());
		c.setAge(crud.getAge());
		c.setJob(crud.getJob());
		crudrepo.save(crud);
		return "Saved Successfully";
	}
}
