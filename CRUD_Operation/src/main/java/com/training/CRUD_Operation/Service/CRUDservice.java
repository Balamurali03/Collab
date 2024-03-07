package com.training.CRUD_Operation.Service;

import java.util.List;

import com.training.CRUD_Operation.Response.CRUDResponse;

public interface CRUDservice {

	public boolean SaveCRUD(CRUDResponse crud );
	
	public CRUDResponse Getbyid(int id);
	
	public List<CRUDResponse> Getall();
	
	public boolean UpdateCRUD(CRUDResponse crud1);
	
	public boolean Deletebyid(int id);
	
	public boolean DeleteAll();
	
	public boolean SaveAll(List<CRUDResponse> crud2);
}