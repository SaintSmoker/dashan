package com.example.ssmspringboot.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Raw_Materials_Warehouse {
    private String Stock_no;
    private String Material_no;
    private String Stock_num;
    private String Storage_address;
    private Timestamp Product_date;
    private String Staff_no_storage;//原料库负责人
    private String Details;


    public String getStock_no() {
        return Stock_no;
    }
    public void setStock_no(String stock_no) { this.Stock_no = stock_no == null ? null : stock_no.trim(); }

    public String getMaterial_no() {
        return Material_no;
    }
    public void setMaterial_no(String material_no) { this.Material_no = material_no == null ? null : material_no.trim(); }

    public String getStock_num() {
        return Stock_num;
    }
    public void setStock_num(String stock_num) {this.Stock_num = stock_num == null ? null : stock_num.trim(); }

    public String getStorage_address() {
        return Storage_address;
    }
    public void setStorage_address(String storage_address) { this.Storage_address = storage_address == null ? null : storage_address.trim(); }

    public Timestamp getProduct_date() {
        return Product_date;
    }
    public void setProduct_date(Timestamp product_date) {
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        this.Product_date = product_date == null ? nousedate : product_date;
    }

    public String getStaff_no_storage() {
        return Staff_no_storage;
    }
    public void setStaff_no_storage(String staff_no_storage) { this.Staff_no_storage = staff_no_storage == null ? null : staff_no_storage.trim(); }

    public String getDetails() {
        return Details;
    }
    public void setDetails(String details) {
        Details = details;this.Details = details == null ? null : details.trim();
    }


    public Raw_Materials_Warehouse() {

    }

    public Raw_Materials_Warehouse(String Stock_no,	            String Material_no,
                                   String Storage_address,	    Timestamp Product_date,
                                   String Staff_no_storage,     String Details,
                                   String Stock_num) {
        this.Stock_no=Stock_no;
        this.Material_no=Material_no;
        this.Storage_address=Storage_address;
        this.Product_date=Product_date;
        this.Staff_no_storage=Staff_no_storage;
        this.Details=Details;
        this.Stock_num=Stock_num;
    }
}

