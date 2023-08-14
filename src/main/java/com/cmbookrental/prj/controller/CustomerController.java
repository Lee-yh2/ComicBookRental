package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.CustomerDto;

import java.util.List;

public interface CustomerController {
    List<CustomerDto> findAll();
    void add(CustomerDto data);
    boolean update(CustomerDto data, int id) throws DBException;
    boolean delete(int id) throws DBException;
    boolean haveCustomer(int id);
}
