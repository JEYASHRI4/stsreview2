package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.BusDetails;
import com.example.demo.repository.BusDetailRepo;

@Service
public class Busdetailservice {
	@Autowired
	BusDetailRepo  br;
	
	public BusDetails add(BusDetails bd) {
		return br.save(bd);
	}
	 public List<BusDetails> saveall(List<BusDetails> ss){
		   return (List<BusDetails>) br.saveAll(ss);
	   }
	public List<BusDetails> print(BusDetails bd){
		return br.findAll();
	}
	 public Optional<BusDetails> showbyid(int id){
		   return br.findById(id);
	   }
	public BusDetails update(BusDetails bd) {
		return br.saveAndFlush(bd);
	}
	public String updateinfobyid(int id,BusDetails s) {
		br.saveAndFlush(s);
		if(br.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter valid id";
		}
	}
	public void delete(int id) {
		br.deleteById(id);
	}
	public void deleteinfo(BusDetails s) {
		   br.delete(s);
  }
	public List<BusDetails> getbusinfo(int id,String bus_no){
		return br.getbusinfo(id, bus_no);
	}
	public int delbusinfo(int id) {
		   br.deletebusinfo(id);
		   return id;
	}
	public String updatebusinfo(String name,int id2) {
		   br.updatebusinfo(name, id2);
		   return "Updated";
	}
	public List<BusDetails> sortinfo(String s){
		 return br.findAll(Sort.by(Sort.Direction.ASC, s));
	}
	public List<BusDetails> getbypage(int pagno,int pagsize){
		 Page<BusDetails> c=br.findAll(PageRequest.of(pagno, pagsize));
		 return c.getContent();
	}
	public List<BusDetails> getbypagesort(int pagno,int pagsize,String s){
		 Page<BusDetails> c=br.findAll(PageRequest.of(pagno,pagsize,Sort.by(Sort.Direction.ASC, s)));
		 return c.getContent();
	}
}
