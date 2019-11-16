package com.example.ssmspringboot.domain;

import lombok.Data;

@Data
public class Staff {
    private String Staff_no;
    private String Staff_name;
    private String Password;
    private String Department;
    private String Workshop;
    private Long Authority;
    private Long Busy;
    private String Position;
    private String Details;

    public String getStaff_no() {
        return Staff_no;
    }
    public void setStaff_no(String staff_no) {
        this.Staff_no = staff_no == null ? null : staff_no.trim();
    }

    public String getStaff_name() {
        return Staff_name;
    }
    public void setStaff_name(String staff_name) {
        this.Staff_name = staff_name == null ? null : staff_name.trim();
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password == null ? null : password.trim();
    }

    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        this.Department = department == null ? null : department.trim();
    }

    public String getWorkshop() {
        return Workshop;
    }
    public void setWorkshop(String workshop) {
        this.Workshop = workshop == null ? null : workshop.trim();
    }

    public Long getAuthority() {
        return Authority;
    }
    public void setAuthority(Long authority) {
        Authority = authority;
    }

    public Long getBusy() {
        return Busy;
    }
    public void setBusy(Long busy) {
        Busy = busy;
    }

    public String getPosition() {
        return Position;
    }
    public void setPosition(String position) {
        this.Position = position == null ? null : position.trim();
    }

    public String getDetails() {
        return Details;
    }
    public void setDetails(String details) {
        this.Details = details == null ? null : details.trim();
    }

    public Staff() {

    }

    public Staff(String Staff_no,	    String Staff_name,	    String Password,
                 String Department,	    String Workshop,	    Long Authority,
                 Long Busy,             String Position,        String Details) {
        this.Staff_no=Staff_no;
        this.Staff_name=Staff_name;
        this.Password=Password;
        this.Department=Department;
        this.Workshop=Workshop;
        this.Authority=Authority;
        this.Busy=Busy;
        this.Position=Position;
        this.Details=Details;
    }
}