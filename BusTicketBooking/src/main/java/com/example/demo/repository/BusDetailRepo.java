package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.BusDetails;


public interface BusDetailRepo extends JpaRepository<BusDetails, Integer> {

	@Query(value = "select * from bus_info where id=:s or bus_no=:ns",nativeQuery = true)
	public List<BusDetails> getbusinfo(@Param("s") int id,@Param("ns") String bus_no);
	@Modifying
	@Transactional
	@Query(value ="delete from bus_info where id=:s",nativeQuery = true)
	public int deletebusinfo(@Param("s") int id);
	@Modifying
	@Transactional
	@Query(value="update bus_info set boardingpoint=?1 where id=?2",nativeQuery = true)
	public int updatebusinfo(String newboarding,int oldid);
}
