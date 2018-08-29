package com.sudeep.etl.load;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
public class loadCassandraController {
  
  private HotelRepository repo; 
 
  @Autowired
	public void DatabaseLoader(HotelRepository hotelRepository) {
		this.repo = hotelRepository;
	}

   @RequestMapping(value="/load" , method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
  	public List<Hotel> loadCassandra(@RequestBody List<Hotel> hotels) throws Exception
	{
		/*String name=requestParams.get("name");
		String address=requestParams.get("address");
		String zip=requestParams.get("zip");
		String version=requestParams.get("version");
		Hotel hotel =new Hotel(name,address,zip,version);*/
	   for (Hotel hotl: hotels)
	   {	   hotl.setId(UUID.randomUUID());
	          this.repo.save(hotl);
	  
	}
	   return hotels;
   }
}
