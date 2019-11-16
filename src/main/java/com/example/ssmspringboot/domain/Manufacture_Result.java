package com.example.ssmspringboot.domain;

import lombok.Data;

@Data
public class Manufacture_Result {
    private String Manufacture_no;
    private String Staff_no_manufacture;
    private String Staff_no_design;
    private String Product_no;
    private String Product_num;//数字+“--”+单位


    public String getManufacture_no() { return Manufacture_no; }
    public void setManufacture_no(String manufacture_no) { this.Manufacture_no = manufacture_no == null ? null : manufacture_no.trim(); }

    public String getStaff_no_manufacture() { return Staff_no_manufacture; }
    public void setStaff_no_manufacture(String staff_no_manufacture) { this.Staff_no_manufacture = staff_no_manufacture == null ? null : staff_no_manufacture.trim();}

    public String getStaff_no_design() { return Staff_no_design; }
    public void setStaff_no_design(String staff_no_design) { this.Staff_no_design = staff_no_design == null ? null : staff_no_design.trim(); }

    public String getProduct_no() { return Product_no; }
    public void setProduct_no(String product_no) { this.Product_no = product_no == null ? null : product_no.trim(); }

    public String getProduct_num() { return Product_num; }
    public void setProduct_num(String product_num) { this.Product_num = product_num == null ? null : product_num.trim(); }

    public Manufacture_Result() {

    }

    public Manufacture_Result(String Manufacture_no,        String Staff_no_manufacture,
                              String Staff_no_design,	    String Product_no,
                              String Product_num) {
        this.Manufacture_no=Manufacture_no;
        this.Staff_no_manufacture=Staff_no_manufacture;
        this.Staff_no_design=Staff_no_design;
        this.Product_no=Product_no;
        this.Product_num=Product_num;
    }
}

