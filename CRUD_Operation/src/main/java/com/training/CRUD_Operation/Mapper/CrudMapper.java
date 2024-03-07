package com.training.CRUD_Operation.Mapper;

import org.springframework.stereotype.Component;

import com.training.CRUD_Operation.Entity.CRUDentity;
import com.training.CRUD_Operation.Response.CRUDResponse;

@Component
public class CrudMapper {

	public CRUDResponse EntitytoResponse(CRUDentity entity){
		CRUDentity getdetails=entity;
		CRUDResponse cr=new CRUDResponse();
		cr.setId(getdetails.getId());
		cr.setName(getdetails.getName());
		cr.setAge(getdetails.getAge());
		cr.setJob(getdetails.getJob());
		return cr;
	}
	
	public CRUDentity ResponsetoEntity(CRUDResponse cresponse) {
//		CRUDResponse c1=cresponse;
		CRUDentity c=new CRUDentity();
		c.setId(cresponse.getId());
		c.setName(cresponse.getName());
		c.setAge(cresponse.getAge());
		c.setJob(cresponse.getJob());
		return c;
	}
	
}
