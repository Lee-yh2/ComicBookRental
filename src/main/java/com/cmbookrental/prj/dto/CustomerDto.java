package com.cmbookrental.prj.dto;

import lombok.Getter;

@Getter
public class CustomerDto {
    private int customerNo;
    private String customerName;

    public CustomerDto(int customerNo, String customerName){
        this.customerNo = customerNo;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "고객ID :" + this.customerNo + "\n" +
                "고객 이름 : " + this.customerName;
    }
}
