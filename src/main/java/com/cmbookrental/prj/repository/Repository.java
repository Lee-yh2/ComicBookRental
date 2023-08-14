package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.comm.DBException;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    void add(T data);
    boolean update(T data, int id) throws DBException;
    boolean delete(int id) throws DBException;

    boolean find(int id);
}
