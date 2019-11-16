package com.example.ssmspringboot.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Manufacture_Design {
    private String Manufacture_no;
    private String Staff_no_design;//生产计划科负责人
    private Timestamp Deadline;
    private String Progress;
    private String Stock_no_raw_material;//原料库编号
    private String Raw_materials_requirement;//数字+“--”+单位
    private String Workshop;
    private String Stock_no_products;//成品库编号
    private String Products_requirement;
    private String Details;


    public String getManufacture_no() {
        return Manufacture_no;
    }
    public void setManufacture_no(String manufacture_no) { this.Manufacture_no = manufacture_no == null ? null : manufacture_no.trim(); }

    public String getStaff_no_design() {
        return Staff_no_design;
    }
    public void setStaff_no_design(String staff_no_design) { this.Staff_no_design = staff_no_design == null ? null : staff_no_design.trim(); }

    public Timestamp getDeadline() {
        return Deadline;
    }
    public void setDeadline(Timestamp deadline) {
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        this.Deadline = deadline == null ? nousedate : deadline;
    }

    public String getProgress() {
        return Progress;
    }
    public void setProgress(String progress) { this.Progress = progress == null ? null : progress.trim(); }

    public String getStock_no_raw_material() {
        return Stock_no_raw_material;
    }
    public void setStock_no_raw_material(String stock_no_raw_material) { this.Stock_no_raw_material = stock_no_raw_material == null ? null : stock_no_raw_material.trim(); }

    public String getRaw_materials_requirement() {
        return Raw_materials_requirement;
    }
    public void setRaw_materials_requirement(String raw_materials_requirement) { this.Raw_materials_requirement = raw_materials_requirement == null ? null : raw_materials_requirement.trim(); }

    public String getWorkshop() {
        return Workshop;
    }
    public void setWorkshop(String workshop) { this.Workshop = workshop == null ? null : workshop.trim(); }

    public String getStock_no_products() {
        return Stock_no_products;
    }
    public void setStock_no_products(String stock_no_products) { this.Stock_no_products = stock_no_products == null ? null : stock_no_products.trim(); }

    public String getProducts_requirement() {
        return Products_requirement;
    }
    public void setProducts_requirement(String products_requirement) { this.Products_requirement = products_requirement == null ? null : products_requirement.trim(); }

    public String getDetails() {
        return Details;
    }
    public void setDetails(String details) { this.Details = details == null ? null : details.trim(); }


    public Manufacture_Design() {

    }

    public Manufacture_Design(String Manufacture_no,            String Staff_no_design,
                              Timestamp Deadline,               String Progress,
                              String Stock_no_raw_material,
                              String Raw_materials_requirement,
                              String Workshop,                  String Stock_no_products,
                              String Products_requirement,      String Details) {
        this.Manufacture_no=Manufacture_no;
        this.Staff_no_design=Staff_no_design;
        this.Deadline=Deadline;
        this.Progress=Progress;
        this.Stock_no_raw_material=Stock_no_raw_material;
        this.Raw_materials_requirement=Raw_materials_requirement;
        this.Workshop=Workshop;
        this.Stock_no_products=Stock_no_products;
        this.Products_requirement=Products_requirement;
        this.Details=Details;
    }
}

