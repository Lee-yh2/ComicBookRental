package com.cmbookrental.prj.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RentalDto {
    private int rentalNo;
    private LocalDate rentalDate;
    private int rentalCmbookNo;
    private int rentalCustomerNo;

    public RentalDto(int rentalNo, int rentalCmbookNo, int rentalCustomerNo){
        this.rentalNo = rentalNo;
        this.rentalDate = LocalDate.now();
        this.rentalCmbookNo = rentalCmbookNo;
        this.rentalCustomerNo = rentalCustomerNo;
    }
}
