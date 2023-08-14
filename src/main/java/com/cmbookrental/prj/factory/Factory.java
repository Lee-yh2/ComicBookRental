package com.cmbookrental.prj.factory;

import com.cmbookrental.prj.comm.Common;
import com.cmbookrental.prj.controller.*;
import com.cmbookrental.prj.repository.ComicBookRepositiryImpl;
import com.cmbookrental.prj.repository.CustomerRepositoryImpl;
import com.cmbookrental.prj.repository.RentalRepositoryImpl;
import com.cmbookrental.prj.repository.Repository;


public class Factory {
    private static Factory instance;

    public static Factory getInstance() {
        if(instance == null)
            instance = new Factory();
        return instance;
    }

    public Repository getRepository(int kind){
        Repository repository = null;
        if(kind == Common.COMIC_BOOK)
            repository = new ComicBookRepositiryImpl();
        if(kind == Common.CUSTOMER)
            repository = new CustomerRepositoryImpl();
        if(kind == Common.RENTAL)
            repository = new RentalRepositoryImpl();

        return repository;
    }

    public ComicBookController getComicBookController(){
        return new ComicBookControllerImpl();
    }

    public CustomerController getCustomerController(){
        return new CustomerControllerImpl();
    }

    public RentalController getRentalController(){
        return new RentalControllerImpl();
    }

}
