package com.example.ssmspringboot.domain;

import lombok.Data;

@Data
public class Refund_Application {
    private String Refund_no;
    private String Order_no;
    private String Client_no;
    private String Reason;
    private String Staff_no_checker;
    private String Progress;
    private Long Permission;
    private Long Refund_Payment;


    public String getRefund_no() {
        return Refund_no;
    }
    public void setRefund_no(String refund_no) {this.Refund_no = refund_no == null ? null : refund_no.trim(); }

    public String getOrder_no() {
        return Order_no;
    }
    public void setOrder_no(String order_no) {this.Order_no = order_no == null ? null : order_no.trim(); }

    public String getClient_no() {
        return Client_no;
    }
    public void setClient_no(String client_no) {this.Client_no = client_no == null ? null : client_no.trim(); }

    public String getReason() {
        return Reason;
    }
    public void setReason(String reason) {this.Reason = reason == null ? null : reason.trim(); }

    public String getStaff_no_checker() {
        return Staff_no_checker;
    }
    public void setStaff_no_checker(String staff_no_checker) {this.Staff_no_checker = staff_no_checker == null ? null : staff_no_checker.trim(); }

    public String getProgress() {
        return Progress;
    }
    public void setProgress(String progress) {this.Progress = progress == null ? null : progress.trim(); }

    public Long getPermission() {
        return Permission;
    }
    public void setPermission(Long permission) {
        Permission = permission;
    }

    public Long getRefund_Payment() {
        return Refund_Payment;
    }
    public void setRefund_Payment(Long refund_Payment) {
        Refund_Payment = refund_Payment;
    }


    public Refund_Application() {

    }

    public Refund_Application(String Refund_no,	        String Order_no,
                              String Client_no,	        String Reason,
                              String Staff_no_checker,	String Progress,
                              Long Permission,	        Long Refund_Payment) {
        this.Refund_no=Refund_no;
        this.Order_no=Order_no;
        this.Client_no=Client_no;
        this.Reason=Reason;
        this.Staff_no_checker=Staff_no_checker;
        this.Progress=Progress;
        this.Permission=Permission;
        this.Refund_Payment=Refund_Payment;
    }

}

