package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.Common;
import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.RentalDto;
import com.cmbookrental.prj.factory.Factory;
import com.cmbookrental.prj.repository.Repository;

import java.util.List;

public class RentalControllerImpl implements RentalController{
    private Repository repository = null;

    public RentalControllerImpl() {
        repository = Factory.getInstance().getRepository(Common.RENTAL);
    }
    @Override
    public List<RentalDto> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(RentalDto data) {
        repository.add(data);
    }

    @Override
    public boolean delete(int id) throws DBException {
        return repository.delete(id);
    }

    @Override
    public boolean haveRental(int id) {
        return repository.find(id);
    }
}
