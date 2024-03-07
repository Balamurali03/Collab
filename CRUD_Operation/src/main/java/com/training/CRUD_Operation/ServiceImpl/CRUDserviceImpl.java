package com.training.CRUD_Operation.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.CRUD_Operation.Entity.CRUDentity;
import com.training.CRUD_Operation.Mapper.CrudMapper;
import com.training.CRUD_Operation.Repo.CRUDrepo;
import com.training.CRUD_Operation.Response.CRUDResponse;
import com.training.CRUD_Operation.Service.CRUDservice;

@Service
public class CRUDserviceImpl implements CRUDservice{

	@Autowired
	private CRUDrepo crudrepo;
	
@Autowired
private CrudMapper mapper;
	

	@Override
	public boolean SaveCRUD(CRUDResponse crud) {
//		CRUDentity c=new CRUDentity();
//		c.setId(crud.getId());
//		c.setName(crud.getName());
//		c.setAge(crud.getAge());
//		c.setJob(crud.getJob());
//		crudrepo.save(c);
//		boolean a=crudrepo.existsById(c.getId());
//		return a;
		
//		USING MAPPER
		crudrepo.save(mapper.ResponsetoEntity(crud));
		
		boolean a=crudrepo.existsById(crud.getId());
		return a;
	}
	
	
	@Override
	public boolean UpdateCRUD(CRUDResponse crud1) {
//	CRUDentity oldcrud=crudrepo.findById(crud1.getId()).get();
//		oldcrud.setName(crud1.getName());
//		oldcrud.setAge(crud1.getAge());
//		oldcrud.setJob(crud1.getJob());
//		crudrepo.save(oldcrud);
//		String s1=crud1.toString();
//		String s2=oldcrud.toString();
//		if(s1.equals(s2)) {
//			return false;
//		}
//		else return true;
		
//		USING MAPPER
		
		CRUDentity a=	crudrepo.findById(crud1.getId()).get();
	 a=mapper.ResponsetoEntity(crud1);
		crudrepo.save(a);
	String s1=crud1.toString();
	System.out.println(s1);
	String s2=a.toString();
	if(s1.equals(s2)) {
		return false;
	}else
		return true;
	}
	
	
	@Override
	public boolean SaveAll(List<CRUDResponse> crud2) {
//List<CRUDentity> list=new ArrayList<>();
//		int count=0;
//		for(int i=0;i<crud2.size();i++) {
//			CRUDentity ce=new CRUDentity();
//			ce.setId(crud2.get(i).getId());
//			ce.setName(crud2.get(i).getName());
//			ce.setAge(crud2.get(i).getAge());
//			ce.setJob(crud2.get(i).getJob());
//		list.add(ce);
//		count++;
//		}
//		crudrepo.saveAll(list);
//		if(count==crud2.size()) {     
//			return true;
//		}
//		else
//		return false;
		
//		using mapper
		List<CRUDentity> list=new ArrayList<>();
		for(int i=0;i<crud2.size();i++) {
			list.add(mapper.ResponsetoEntity(crud2.get(i)));
		}
	crudrepo.saveAll(list);
	if(list.size()==crud2.size()) {
		return true;
	}
	else return false;
		
	}
	
	
	@Override
	public CRUDResponse Getbyid(int id) {	
		boolean a=crudrepo.existsById(id);
		if(a==true) {
CRUDentity getdetails=crudrepo.findById(id).get();
	CRUDResponse cr=new CRUDResponse();
	cr.setId(getdetails.getId());
	cr.setName(getdetails.getName());
	cr.setAge(getdetails.getAge());
	cr.setJob(getdetails.getJob());
	return cr;
		}
		else
			return null;
		
//	USING MAPPER	
		
//		boolean b=crudrepo.existsById(id);
//		if(b==true) {
//			CRUDentity getdetails=crudrepo.findById(id).get();
//	return mapper.EntitytoResponse(getdetails);
//}else
//		return null;
	}
	

	@Override
	public List<CRUDResponse> Getall() {
		List<CRUDentity> l=new ArrayList<>();
//		getting all the datas from repo
		l=crudrepo.findAll();
		List<CRUDResponse> list=new ArrayList<>();
		CRUDResponse cr=new CRUDResponse();
		for(int i=0;i<l.size();i++) {
			CRUDentity ce=l.get(i);
		cr.setId(ce.getId());
		cr.setName(ce.getName());
		cr.setAge(ce.getAge());
		cr.setJob(ce.getJob());
		list.add(cr);
		}
		if(list.size()>0) {
			return list;
		}
		else
			return null;
		
//			USING MAPPER
//			List<CRUDentity> l=new ArrayList<>();
//			l=crudrepo.findAll();
//			List<CRUDResponse> list=new ArrayList<>();
//			for(int i=0;i<l.size();i++) {
//				CRUDentity ce=l.get(i);
//			list.add(mapper.EntitytoResponse(ce));
//		}
//		if(list.size()>0) {
//			return list;
//		}else
//		return null;
	}
	
	
	@Override
	public boolean Deletebyid(int id) {
		crudrepo.deleteById(id);
		boolean c=crudrepo.existsById(id);
		return c;
	}

	
	@Override
	public boolean DeleteAll() {
		if(crudrepo.count()!=0) {
			crudrepo.deleteAll();
			return true;
		}
		else
			return false;
	}

	
}
