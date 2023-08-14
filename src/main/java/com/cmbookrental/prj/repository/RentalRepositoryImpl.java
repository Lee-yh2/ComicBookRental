package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.dto.CollectionDB;
import com.cmbookrental.prj.dto.RentalDto;

import java.util.List;

public class RentalRepositoryImpl implements Repository<RentalDto>{
    @Override
    public List<RentalDto> findAll() {
        return CollectionDB.getInstance().getRentalData();
    }

    @Override
    public void add(RentalDto data) {
        List<RentalDto> list = CollectionDB.getInstance().getRentalData();
        if(!list.isEmpty()) {
            //대여건 있는경우 반납후 대여
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getRentalCustomerNo() == data.getRentalCustomerNo()){
                    list.remove(i);
                    break;
                }
            }
        }
        CollectionDB.getInstance().setRentalData(data);
    }

    @Override
    public boolean update(RentalDto data, int id) throws DBException {
        List<RentalDto> list = CollectionDB.getInstance().getRentalData();
        if(list.isEmpty()) {
            throw new DBException("현재 대여이력이 없습니다.");
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getRentalNo() == id){
                list.set(i, data);
                return true;
            }
        }
        //찾는 대여이력이 없음
        throw new DBException( "수정할 "+ id+"대여이력이 없습니다.");
    }

    @Override
    public boolean delete(int id) throws DBException {
        List<RentalDto> list = CollectionDB.getInstance().getRentalData();
        if(list.isEmpty())
            throw new DBException("현재 대여이력이 없습니다.");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getRentalNo() == id){
                list.remove(i);
                return true;
            }
        }
        //찾는 대여이력이 없음
        throw new DBException( "반납할 "+ id+"대여이력이 없습니다.");
    }

    @Override
    public boolean find(int id) {
        List<RentalDto> list = CollectionDB.getInstance().getRentalData();
        if(list.isEmpty())
            return false;
        //          throw new DBException("현재 대여이력이 없습니다.");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getRentalNo() == id){
                return true;
            }
        }
        //찾는 대여이력이 없음
        return false;
    }
}
