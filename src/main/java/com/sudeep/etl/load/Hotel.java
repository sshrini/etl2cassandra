package com.sudeep.etl.load;
import org.springframework.data.cassandra.core.mapping.*;
import java.io.Serializable;
import java.util.UUID;
@Table("hotels")
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    private UUID id;
    private String name;
    private String address;
    private String zip;
    private Integer version;
    public Hotel() {
    }
    public Hotel(String name) {
        this.name = name;
    }
    public Hotel(String name, String address, String zip, String version) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.address = address;
        this.zip = zip;
        this.version = Integer.getInteger(version);
    }
    
    public UUID getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getZip() {
        return this.zip;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
}
