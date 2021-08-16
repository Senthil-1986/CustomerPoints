
package com.cp.model;
import java.util.*;
import java.util.ArrayList;


public class Customer {

    
    private String name;
    private String mobile;
    private String address;
    private int id;
    private Map pointMap = new HashMap();

    public Map getPointMap() {
        return pointMap;
    }

    public void setPointMap(Map pointMap) {
        this.pointMap = pointMap;
    }

    

    private List<Invoice> invoices = new ArrayList<Invoice>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }


}
