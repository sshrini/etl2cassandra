package com.sudeep.etl.load;

import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = EtlDemoApplication.class)
public class EtlDemoApplicationTests {


	 @Autowired
	 private HotelRepository hotelRepository;
	 @Test
	 public void repositoryCrudOperations() {
	  Hotel sample = sampleHotel();
	  this.hotelRepository.save(sample);
	  Optional<Hotel> savedHotel = this.hotelRepository.findById(sample.getId());
	  assertThat(savedHotel.get().getName(), equalTo("Sample Hotel"));
	  this.hotelRepository.deleteById(savedHotel.get().getId());
	 }
	 private Hotel sampleHotel() {
	  Hotel hotel = new Hotel();
	  hotel.setId(UUID.randomUUID());
	  hotel.setName("Sample Hotel");
	  hotel.setAddress("Sample Address");
	  hotel.setZip("8764");
	  return hotel;
	 }

}
