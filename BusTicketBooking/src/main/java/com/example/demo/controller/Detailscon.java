package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Details;

import com.example.demo.service.Detailsser;

@RestController
public class Detailscon {
@Autowired
Detailsser se;
@PostMapping("add")
public Details adddetails(@RequestBody Details d) {
	return se.add(d);
}
@PostMapping("addall")
public List<Details> addall(@RequestBody List<Details> ss){
	return se.saveall(ss);
}
@GetMapping("disp")
public List<Details> show( Details d) {
	return se.showdetails(d);
}
@GetMapping("show/{id}")
public Optional<Details> showid(@PathVariable int id){
	return se.showbyid(id);
}
@PutMapping("mod")
public Details change(@RequestBody Details d) {
	return se.modify(d);
}
@PutMapping("updatebyid/{id}")
public String modifybyid(@PathVariable int id,@RequestBody Details s) {
	return se.updateinfobyid(id, s);
}
@DeleteMapping("del")
public void Del(@RequestBody Details d) {
	se.remove(d);
}
@DeleteMapping("del/{id}")
public String delete(@PathVariable int id) {
	se.delid(id);
	return "Deleted successfully";
}
@PostMapping("addbusinfo")
public Details addbusdetails(@RequestBody Details d) {
	return se.addbus(d);
}
@GetMapping("dispbusinfo")
public List<Details> showbus( Details d) {
	return se.showbusdetails(d);
}
@GetMapping("showpage/{name}")
public List<Details> sort(@PathVariable String  name){
	return se.sortinfo(name);
}
@GetMapping("showpage/{pagno}/{pagesize}")
public List<Details> getpage(@PathVariable int pagno,@PathVariable int pagesize){
	return se.getbypage(pagno, pagesize);
}
@GetMapping("showpage/{pageno}/{pagesize}/{name}")
public List<Details> getpagesort(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
	return se.getbypagesort(pageno, pagesize, name);
}
@GetMapping("showqueryname/{id}/{name}")
public List<Details> getinfo(@PathVariable int id,@PathVariable String name){
	return se.getperinfo(id, name);
}
@DeleteMapping("deletequeryid/{id}")
public int delinfo(@PathVariable int id) {
	se.delperinfo(id);
	return id;
}
@PutMapping("updatequery/{newname}/{oldid}")
public String updateinfo(@PathVariable String newname,@PathVariable int oldid) {
	se.updateperinfo(newname, oldid);
	return "updated";
}
}
