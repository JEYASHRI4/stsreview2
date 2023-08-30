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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BusDetails;
import com.example.demo.service.Busdetailservice;

@RestController
public class BusDetailsController {

	@Autowired
	Busdetailservice bs;
	
	@PostMapping("addbus")
	public BusDetails addbus(@RequestBody BusDetails bd) {
		return bs.add(bd);
	}
	@PostMapping("addallbus")
	public List<BusDetails> addall(@RequestBody List<BusDetails> ss){
		return bs.saveall(ss);
	}
	@GetMapping("dispbus")
	public List<BusDetails> show(BusDetails bd){
		return bs.print(bd);
	}
	@GetMapping("showbus/{id}")
	public Optional<BusDetails> showid(@PathVariable int id){
		return bs.showbyid(id);
	}
	@PutMapping("updatebus")
	public BusDetails update(@RequestBody BusDetails bd) {
		return bs.update(bd);
	}
	@PutMapping("updatebusbyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody BusDetails s) {
		return bs.updateinfobyid(id, s);
	}
	@DeleteMapping("delbus/{id}")
	public String del(@PathVariable int id) {
		bs.delete(id);
		return "Deleted";
	}
	@DeleteMapping("delbus")
	public String delinfo(@RequestBody BusDetails s) {
		 bs.deleteinfo(s);
		 return "Deleted successfully";
	}
	@DeleteMapping("delparamidbus")
	public void delid(@RequestParam int id) {
		bs.delete(id);
	}
	@GetMapping("showquerybusname/{id}/{name}")
	public List<BusDetails> getbusinfo(@PathVariable int id,@PathVariable String name){
		return bs.getbusinfo(id, name);
	}
	@DeleteMapping("deletequerybusid/{id}")
	public int delbusinfo(@PathVariable int id) {
		bs.delbusinfo(id);
		return id;
	}
	@PutMapping("updatebus/{newname}/{oldid}")
	public String updatebusinfo(@PathVariable String newname,@PathVariable int oldid) {
		bs.updatebusinfo(newname, oldid);
		return "updated";
	}
	@GetMapping("showbuspage/{name}")
	public List<BusDetails> sort(@PathVariable String  name){
		return bs.sortinfo(name);
	}
	@GetMapping("showbuspage/{pagno}/{pagesize}")
	public List<BusDetails> getpage(@PathVariable int pagno,@PathVariable int pagesize){
		return bs.getbypage(pagno, pagesize);
	}
	@GetMapping("showbuspage/{pageno}/{pagesize}/{name}")
	public List<BusDetails> getpagesort(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
		return bs.getbypagesort(pageno, pagesize, name);
	}
}
