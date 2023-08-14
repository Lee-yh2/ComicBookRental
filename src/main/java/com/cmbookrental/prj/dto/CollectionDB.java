package com.cmbookrental.prj.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionDB {
    private static CollectionDB instance = new CollectionDB();

    private static final String COMIC_BOOK_DATA = "ComicBook";
    private static final String RENTAL_DATA = "Rental";
    private static final String CUSTOMER_DATA = "Customer";

    private static Map<String, ArrayList> mData = new HashMap<>();

    private CollectionDB(){}

    static{
        ArrayList<ComicBookDto> cmBookList = new ArrayList<>();
        cmBookList.add(new ComicBookDto(1, "a", "aaa"));
        mData.put(COMIC_BOOK_DATA, cmBookList);

        ArrayList<CustomerDto> customerList = new ArrayList<>();
        customerList.add(new CustomerDto(1, "yun"));
        mData.put(CUSTOMER_DATA, customerList);

        mData.put(RENTAL_DATA, new ArrayList<RentalDto>());
    }

    public static CollectionDB getInstance() {
        if(instance == null)
            instance = new CollectionDB();
        return instance;
    }

    public Map getmData(){
        return this.mData;
    }

    public void setComicBookData(ComicBookDto comicBookDto){
        mData.get(CollectionDB.COMIC_BOOK_DATA).add(comicBookDto);
    }

    public ArrayList<ComicBookDto> getComicBookData(){
        return mData.get(CollectionDB.COMIC_BOOK_DATA);
    }

    public void setCustomerData(CustomerDto customerDto){
        mData.get(CollectionDB.CUSTOMER_DATA).add(customerDto);
    }

    public ArrayList<CustomerDto> getCustomerData(){
        return mData.get(CollectionDB.CUSTOMER_DATA);
    }

    public void setRentalData(RentalDto rentalDto){
        mData.get(CollectionDB.RENTAL_DATA).add(rentalDto);
    }

    public ArrayList<RentalDto> getRentalData(){
        return mData.get(CollectionDB.RENTAL_DATA);
    }

}
