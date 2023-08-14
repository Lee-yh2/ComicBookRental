package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.CollectionDB;
import com.cmbookrental.prj.dto.CustomerDto;

import java.util.List;

public class CustomerRepositoryImpl implements Repository<CustomerDto> {
    @Override
    public List<CustomerDto> findAll() {
        return CollectionDB.getInstance().getCustomerData();
    }

    @Override
    public void add(CustomerDto data) {
        CollectionDB.getInstance().setCustomerData(data);
    }

    @Override
    public boolean update(CustomerDto data, int id) throws DBException {
        List<CustomerDto> list = CollectionDB.getInstance().getCustomerData();
        if (list.isEmpty())
            throw new DBException("현재 등록된 고객이 없습니다");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomerNo() == id) {
                list.set(i, data);
                return true;
            }
        }
        //찾는 고객이 없음
        throw new DBException( "수정할 "+id + "고객이 없습니다");
    }

    @Override
    public boolean delete(int id) throws DBException {
        List<CustomerDto> list = CollectionDB.getInstance().getCustomerData();
        if (list.isEmpty())
            throw new DBException("현재 등록된 고객이 없습니다");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomerNo() == id) {
                list.remove(i);
                return true;
            }
        }
        //찾는 고객이 없음
        throw new DBException( "삭제할 "+id + "고객이 없습니다");
    }

    @Override
    public boolean find(int id) {
        List<CustomerDto> list = CollectionDB.getInstance().getCustomerData();
        if (list.isEmpty())
            return false;
        //          throw new DBException("현재 고객이 없습니다.");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomerNo() == id) {
                return true;
            }
        }
        //찾는 고객이 없음
        return false;
    }
}
