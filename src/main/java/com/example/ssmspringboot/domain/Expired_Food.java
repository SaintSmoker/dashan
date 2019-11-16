package com.example.ssmspringboot.domain;

import lombok.Data;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Expired_Food {
    private String Food_no;
    private String Food_type;
    private String Food_name;
    private Timestamp Expired_date;
    private String Loss_num;//数字+"--"+单位
    private Long Loss_money;
    private String Processing_method;


    public String getFood_no() {
        return Food_no;
    }
    public void setFood_no(String food_no) {this.Food_no = food_no == null ? null : food_no.trim(); }

    public String getFood_type() {
        return Food_type;
    }
    public void setFood_type(String food_type) {this.Food_type = food_type == null ? null : food_type.trim(); }

    public String getFood_name() {
        return Food_name;
    }
    public void setFood_name(String food_name) {this.Food_name = food_name == null ? null : food_name.trim(); }

    public Timestamp getExpired_date() {
        return Expired_date;
    }
    public void setExpired_date(Timestamp expired_date) {
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        this.Expired_date = expired_date == null ? nousedate : expired_date;
    }

    public String getLoss_num() {
        return Loss_num;
    }
    public void setLoss_num(String loss_num) {this.Loss_num = loss_num == null ? null : loss_num.trim(); }

    public Long getLoss_money() {
        return Loss_money;
    }
    public void setLoss_money(Long loss_money) {
        Loss_money = loss_money;
    }

    public String getProcessing_method() {
        return Processing_method;
    }
    public void setProcessing_method(String processing_method) {;this.Processing_method = processing_method == null ? null : processing_method.trim(); }

    public Expired_Food() {

    }

    public Expired_Food(String Food_no,	            String Food_type,	    String Food_name,
                        Timestamp Expired_date,	    String Loss_num,	    Long Loss_money,
                        String Processing_method) {
        this.Food_no=Food_no;
        this.Food_type=Food_type;
        this.Food_name=Food_name;
        this.Expired_date=Expired_date;
        this.Loss_num=Loss_num;
        this.Loss_money=Loss_money;
        this.Processing_method=Processing_method;
    }
}
