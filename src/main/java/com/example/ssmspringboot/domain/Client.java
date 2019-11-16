package com.example.ssmspringboot.domain;

import lombok.Data;

@Data
public class Client {
    String Client_no;
    String Client_name;
    String Password;
    String Client_type;
    Long Credit;
    String Details;

    public String getClient_no() { return Client_no; }
    public void setClient_no(String client_no) {this.Client_no = client_no == null ? null : client_no.trim(); }

    public String getClient_name() {return Client_name;}
    public void setClient_name(String client_name) {this.Client_name = client_name == null ? null : client_name.trim(); }

    public String getPassword() {return Password; }
    public void setPassword(String password) {this.Password = password == null ? null : password.trim();}

    public String getClient_type() {return Client_type;}
    public void setClient_type(String client_type) {this.Client_type = client_type == null ? null : client_type.trim();}

    public Long getCredit() {return Credit;}
    public void setCredit(Long creidt) {Credit = creidt;}

    public String getDetails() {return Details;}
    public void setDetails(String details) {this.Details = details == null ? null : details.trim();}

    public Client() {

    }

    public Client(String Client_no,	    String Client_name,	    String Password,
                  String Client_type,	Long Credit,	        String Details) {
        this.Client_no=Client_no;
        this.Client_name=Client_name;
        this.Password=Password;
        this.Client_type=Client_type;
        this.Credit=Credit;
        this.Details=Details;
    }
}
