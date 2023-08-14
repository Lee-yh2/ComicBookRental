package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.Common;
import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.ComicBookDto;
import com.cmbookrental.prj.factory.Factory;
import com.cmbookrental.prj.repository.Repository;

import java.util.List;

public class ComicBookControllerImpl implements ComicBookController {
    private Repository repository = null;

    public ComicBookControllerImpl() {
        repository = Factory.getInstance().getRepository(Common.COMIC_BOOK);
    }

    @Override
    public List<ComicBookDto> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(ComicBookDto data) {
        repository.add(data);
    }

    @Override
    public boolean update(ComicBookDto data, int id) throws DBException {
        return repository.update(data, id);
    }

    @Override
    public boolean delete(int id) throws DBException {
        return repository.delete(id);
    }

    @Override
    public boolean haveComicBook(int id) {
        return repository.find(id);
    }
}
