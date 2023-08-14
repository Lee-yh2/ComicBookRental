package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.Common;
import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.CustomerDto;
import com.cmbookrental.prj.factory.Factory;
import com.cmbookrental.prj.repository.Repository;

import java.util.List;

public class CustomerControllerImpl implements CustomerController{

    private Repository repository = null;

    public CustomerControllerImpl() {
        repository = Factory.getInstance().getRepository(Common.CUSTOMER);
    }
    @Override
    public List<CustomerDto> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(CustomerDto data) {
        repository.add(data);
    }

    @Override
    public boolean update(CustomerDto data, int id) throws DBException {
        return repository.update(data, id);
    }

    @Override
    public boolean delete(int id) throws DBException {
        return repository.delete(id);
    }

    @Override
    public boolean haveCustomer(int id) {
        return repository.find(id);
    }
}
