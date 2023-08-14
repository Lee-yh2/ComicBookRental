package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.RentalDto;

import java.util.List;

public interface RentalController {
    List<RentalDto> findAll();
    void add(RentalDto data);
    boolean delete(int id) throws DBException;
    boolean haveRental(int id);
}
