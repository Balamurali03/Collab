package com.training.CRUD_Operation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.CRUD_Operation.ExceptionHandling.CRUDException;
import com.training.CRUD_Operation.Response.CRUDResponse;
import com.training.CRUD_Operation.ServiceImpl.CRUDserviceImpl;

@RestController
public class CRUDcontroller {

	@Autowired
	private CRUDserviceImpl implementation;
	
	@PostMapping("/save")
	public ResponseEntity<String> SaveData(@RequestBody CRUDResponse crud) {
		if(crud.getId()==0 || crud.getName().equals("") || crud.getAge()==0 || crud.getJob().equals("")) {
		throw new CRUDException("No data in the object");
		}
		boolean response=implementation.SaveCRUD(crud);
		if(response==true) {
			return ResponseEntity.status(200).body("Successfully saved");
		}
		return ResponseEntity.status(400).body("save unsuccessful");
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> UpdateData(@RequestBody CRUDResponse crud1) {
		boolean response=implementation.UpdateCRUD(crud1);
		if(response==true) {
			return ResponseEntity.status(200).body("Updated successfully");
		}
		return ResponseEntity.status(400).body("Updated unsuccessful");
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> GetData(@PathVariable int id) {
		if(id<=0) {
			throw  new CRUDException("id can't be zero and negative");
		}
		CRUDResponse response=implementation.Getbyid(id);
		if(response!=null) {
	return ResponseEntity.status(200).body(response);	
	}else
		return ResponseEntity.status(400).body("No details found");
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> GetAllData(){
		List<CRUDResponse> list=implementation.Getall();
		if(list!=null) {
			return ResponseEntity.status(200).body(list);
		}else
			return ResponseEntity.status(400).body("No list of data");
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> DeleteData(@PathVariable int id) {
		boolean response=implementation.Deletebyid(id);
		if(response==true) {
			return ResponseEntity.status(200).body("Data deleted successfully");
		}
		return ResponseEntity.status(400).body("Data deletion is unsuccessful");
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String> DeleteAllData(){
		boolean response=implementation.DeleteAll();
		if(response==true) {
			return ResponseEntity.status(200).body("Data deleted");
		}
		else
			return ResponseEntity.status(400).body("Data not deleted");	
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> SaveAllData(@RequestBody List<CRUDResponse> crud2){
		boolean response=implementation.SaveAll(crud2);
		if(response==true) {
			return ResponseEntity.status(200).body("Multiple data stored");
		}else
			return ResponseEntity.status(400).body("Not saved");
		
	}
	
	@ExceptionHandler(CRUDException.class)
	public ResponseEntity<String> HandleCRUDException(CRUDException exception){
		return ResponseEntity.status(404).body(exception.getMessage());
	}
	
}
