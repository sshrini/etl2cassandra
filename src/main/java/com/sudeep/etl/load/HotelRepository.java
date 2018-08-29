/**
 * 
 */
package com.sudeep.etl.load;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;
/**
 * @author sudeep.shrinivasan
 *
 *
 */
public interface HotelRepository extends CassandraRepository<Hotel,UUID>{

}
