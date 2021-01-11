package com.customer.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "Customer")
public class Customer {

    @Id
    @Indexed(name = "id", type= "string")
    private String id;

    @Indexed(name = "cname", type= "string")
    private String name;

    @Indexed(name = "cstreetAddress", type= "string")
    private String streetAddress;

    @Indexed(name = "cCity", type= "string")
    private String city;

    @Indexed(name = "cState", type= "string")
    private String state;

    @Indexed(name = "cCountry", type= "string")
    private String country;

    @Indexed(name = "cZipCode", type= "string")
    private String zipCode;
    
    public String getId(){
        return id;
    }

    public void setId(final String customerId){
        this.id = customerId;
    }

    public String getName(){
        return name;
    }

    public void setName(final String customerName){
        this.name = customerName;
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public void setStreetAddress(final String customerStreetAddress){
        this.streetAddress = customerStreetAddress;
    }

    public String getCity(){
        return city;
    }

    public void setCity(final String customerCity){
        this.city = customerCity;
    }

    public String getState(){
        return state;
    }

    public void setState(final String customerState){
        this.state = customerState;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(final String customerCountry){
        this.country = customerCountry;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setZipCode(final String customerZipCode){
        this.zipCode = customerZipCode;
    }
}