package com.example.ssmspringboot.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Order_Form {
    private String Order_no;
    private String Client_no;
    private String Staff_no;//销售部负责人
    private Timestamp Order_Create_date;
    private Long Order_sum_amount;
    private String Progress;
    private Long Liquidated_damages;//违约金
    private Long Check;


    public String getOrder_no() {return Order_no;}
    public void setOrder_no(String order_no) {this.Order_no = order_no == null ? null : order_no.trim();}

    public String getClient_no() {return Client_no;}
    public void setClient_no(String client_no) {this.Client_no = client_no == null ? null : client_no.trim();}

    public String getStaff_no() {return Staff_no;}
    public void setStaff_no(String staff_no) {this.Staff_no = staff_no == null ? null : staff_no.trim();}

    public Timestamp getOrder_Create_date() {return Order_Create_date;}
    public void setOrder_Create_date(Timestamp order_Create_date) {
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        this.Order_Create_date = order_Create_date == null ? nousedate : order_Create_date;
    }

    public Long getOrder_sum_amount() {return Order_sum_amount;}
    public void setOrder_sum_amount(Long order_sum_amount) {Order_sum_amount = order_sum_amount;}

    public String getProgress() {return Progress;}
    public void setProgress(String progress) {this.Progress = progress == null ? null : progress.trim();}

    public Long getLiquidated_damages() {return Liquidated_damages;}
    public void setLiquidated_damages(Long liquidated_damages) {Liquidated_damages = liquidated_damages;}

    public Long getCheck() {return Liquidated_damages;}
    public void setCheck(Long check) {Check = check;}

    public Order_Form() {

    }

    public Order_Form(String Order_no,	        String Client_no,	        String Staff_no,
                      Timestamp Order_Create_date,	Long Order_sum_amount,
                      String Progress,	        Long Liquidated_damages,    Long Check) {
        this.Order_no=Order_no;
        this.Client_no=Client_no;
        this.Staff_no=Staff_no;
        this.Order_Create_date=Order_Create_date;
        this.Order_sum_amount=Order_sum_amount;
        this.Progress=Progress;
        this.Liquidated_damages=Liquidated_damages;
        this.Check=Check;
    }
}
