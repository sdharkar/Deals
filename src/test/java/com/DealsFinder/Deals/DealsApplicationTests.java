package com.DealsFinder.Deals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.DealsFinder.Deals.model.Deals;
import com.DealsFinder.Deals.repository.DealRepo;

@SpringBootTest
class DealsApplicationTests {

	@Autowired
	DealRepo dealRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Deals d = new Deals();
		d.setId("1L1");
		d.setItem("headphone");
		d.setDeal("Buy BoAt Airdopes & get 10% off on next product of BoAt.");
		dealRepo.save(d);
		assertNotNull(dealRepo.findById("1L1").get());	
	}
	
	@Test
	public void testGetAllDeals() {
		List<Deals> l = dealRepo.findAll();
		assertThat(l).size().isGreaterThan(0);
	}

}
