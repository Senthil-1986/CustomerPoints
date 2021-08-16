package com.cp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.cp.serviceimpl.CustomerList;
import org.springframework.beans.factory.annotation.Autowired;
import com.cp.model.*;
import java.util.*;
import com.cp.service.*;
import com.cp.serviceimpl.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.cp.exception.CustomerNullException;

@RestController
public class CustomerContrller {

    @Autowired
    CustomerList list;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer createCustomer(@RequestParam("name") String name,
            @RequestParam("mobile") String mobile,
            @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setId(list.getList().size() + 1);
        customer.setMobile(mobile);
        customer.setName(name);
        customer.setPointMap(new PointOperator().calculate(customer));
        list.getList().put(customer.getId(), customer);
        return customer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public Customer addInvoice(@RequestParam("customerID") int id,
            @RequestParam("valueDate") String date,
            @RequestParam("amount") float amount) throws ParseException {
        Invoice invoice = new Invoice();
        invoice.setAmount(amount);
        invoice.setCustomerID(id);
        invoice.setValueDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date));
        Optional opt = Optional.ofNullable(list.getList().get(id));
        if (opt.isPresent()) {
            Customer customer = (Customer) opt.get();
            customer.getInvoices().add(invoice);
            customer.setPointMap(new PointOperator().calculate(customer));
            return customer;
        } else {
            throw new CustomerNullException();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/process/{id}", method = RequestMethod.GET)
    public Map getAwardPoint(@PathVariable int id) throws CustomerNullException {
        Optional opt = Optional.ofNullable(list.getList().get(id));
        if (opt.isPresent()) {
            CalculatePoint proc = new PointOperator();
            return proc.calculate((Customer) opt.get());
        } else {
            throw new CustomerNullException();
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/process/list", method = RequestMethod.GET)
    public Map getAllRecords() throws CustomerNullException {
        return list.getList();

    }

}
