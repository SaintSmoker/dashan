package com.example.ssmspringboot.domain;

import lombok.Data;

@Data
public class Raw_Materials_Criteria {
    private String Material_no;
    private String Material_name;
    private String Material_type;
    private String Guarantee_period;


    public String getMaterial_no() {return Material_no;}
    public void setMaterial_no(String material_no) {this.Material_no = material_no == null ? null : material_no.trim();}

    public String getMaterial_type() {return Material_type;}
    public void setMaterial_type(String material_type) {this.Material_type = material_type == null ? null : material_type.trim();}

    public String getMaterial_name() {return Material_name;}
    public void setMaterial_name(String material_name) {this.Material_name = material_name == null ? null : material_name.trim();}

    public String getGuarantee_period() {return Guarantee_period;}
    public void setGuarantee_period(String guarantee_period) {this.Guarantee_period = guarantee_period == null ? null : guarantee_period.trim();}

    public Raw_Materials_Criteria(){

    }

    public Raw_Materials_Criteria(String Material_no,   String Material_name,
                                  String Material_type, String Guarantee_period){
        this.Material_no=Material_no;
        this.Material_name=Material_name;
        this.Material_type=Material_type;
        this.Guarantee_period=Guarantee_period;
    }
}
