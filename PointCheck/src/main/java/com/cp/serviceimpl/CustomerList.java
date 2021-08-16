package com.cp.serviceimpl;

import java.util.*;
import com.cp.model.Customer;
import com.cp.model.Invoice;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import java.text.SimpleDateFormat;


@Component
@Scope("singleton")
public class CustomerList implements InitializingBean, DisposableBean{

    private Map<Integer, Customer> list = new HashMap<Integer, Customer>();

    public Map<Integer, Customer> getList() {
        return list;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set");
        Customer person1 = new Customer();
        person1.setAddress("Mumbai");
        person1.setId(list.size()+1);
        person1.setMobile("8976544321");
        person1.setName("Ram");
        Invoice invoice = new Invoice();
        invoice.setAmount(25000);
        invoice.setCustomerID(person1.getId());
        invoice.setValueDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("16/07/2021 10:00:12"));
        person1.getInvoices().add(invoice);
        person1.setPointMap(new PointOperator().calculate(person1));
        list.put(person1.getId(), person1);
        Invoice invoice5 = new Invoice();
        invoice5.setAmount(2000);
        invoice5.setCustomerID(person1.getId());
        invoice5.setValueDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("30/04/2021 23:59:59"));
        person1.getInvoices().add(invoice5);
        person1.setPointMap(new PointOperator().calculate(person1));
        list.put(person1.getId(), person1);
        
        Customer person2 = new Customer();
        person2.setAddress("Delhi");
        person2.setId(list.size()+1);
        person2.setMobile("8966544321");
        person2.setName("Rahul");
        Invoice invoice2 = new Invoice();
        invoice2.setAmount(1000);
        invoice2.setCustomerID(person2.getId());
        invoice2.setValueDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("06/08/2021 10:00:12"));
        person2.getInvoices().add(invoice2);
        person2.setPointMap(new PointOperator().calculate(person2));
        list.put(person2.getId(), person2);
        
        Customer person3 = new Customer();
        person3.setAddress("Pune");
        person3.setId(list.size()+1);
        person3.setMobile("8976544300");
        person3.setName("Vidhya");
        Invoice invoice3 = new Invoice();
        invoice3.setAmount(100);
        invoice3.setCustomerID(person3.getId());
        invoice3.setValueDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/05/2021 00:00:01"));
        person3.getInvoices().add(invoice3);
        person3.setPointMap(new PointOperator().calculate(person3));
        list.put(person3.getId(), person3);
        
        Customer person4 = new Customer();
        person4.setAddress("Bangalore");
        person4.setId(list.size()+1);
        person4.setMobile("8976548821");
        person4.setName("Vijay");
        Invoice invoice4 = new Invoice();
        invoice4.setAmount(250.59f);
        invoice4.setCustomerID(person4.getId());
        invoice4.setValueDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("30/04/2021 23:59:59"));
        person4.getInvoices().add(invoice4);
        person4.setPointMap(new PointOperator().calculate(person4));
        list.put(person4.getId(), person4);
    }

    public void destroy() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }

}
