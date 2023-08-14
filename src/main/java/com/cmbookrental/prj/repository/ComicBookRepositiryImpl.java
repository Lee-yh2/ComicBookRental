package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.CollectionDB;
import com.cmbookrental.prj.dto.ComicBookDto;

import java.util.List;

public class ComicBookRepositiryImpl implements Repository<ComicBookDto> {

    @Override
    public List<ComicBookDto> findAll() {
        return CollectionDB.getInstance().getComicBookData();
    }

    @Override
    public void add(ComicBookDto data) {
        CollectionDB.getInstance().setComicBookData(data);
    }

    @Override
    public boolean update(ComicBookDto data, int id) throws DBException {
        List<ComicBookDto> list = CollectionDB.getInstance().getComicBookData();
        if (list.isEmpty())
            throw new DBException("만화책이 비어있습니다.");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookNo() == id) {
                list.set(i, data);
                return true;
            }
        }
        //수정할 만화책 없음
        throw new DBException("수정할 " + id + " 만화책이 없습니다");
    }

    @Override
    public boolean delete(int id) throws DBException {
        List<ComicBookDto> list = CollectionDB.getInstance().getComicBookData();
        if (list.isEmpty())
            throw new DBException("만화책이 비어있습니다");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookNo() == id) {
                list.remove(i);
                return true;
            }
        }
        //지울 만화책 없음
        throw new DBException("삭제할 " +id + " 만화책이 없습니다");
    }

    @Override
    public boolean find(int id) {
        List<ComicBookDto> list = CollectionDB.getInstance().getComicBookData();
        if (list.isEmpty())
            return false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookNo() == id) {
                return true;
            }
        }
        return false;
    }
}
