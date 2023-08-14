package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.ComicBookDto;
import com.cmbookrental.prj.repository.Repository;

import java.util.List;

public interface ComicBookController {
    List<ComicBookDto> findAll();
    void add(ComicBookDto data);
    boolean update(ComicBookDto data, int id) throws DBException;
    boolean delete(int id) throws DBException;
    boolean haveComicBook(int id);
}
