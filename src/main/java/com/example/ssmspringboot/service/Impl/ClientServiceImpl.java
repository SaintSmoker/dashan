package com.example.ssmspringboot.service.Impl;

import com.example.ssmspringboot.dao.Example.ClientExample;
import com.example.ssmspringboot.dao.Example.StaffExample;
import com.example.ssmspringboot.dao.mappers.ClientMapper;
import com.example.ssmspringboot.datasource.exception.JshException;
import com.example.ssmspringboot.datasource.units.Tools;
import com.example.ssmspringboot.domain.Client;
import com.example.ssmspringboot.service.Service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private Logger logger = LoggerFactory.getLogger(ClientService.class);
    @Autowired
    ClientMapper clientMapper;

    @Override
    public int update_Password_By_PrimaryKey(String Client_no, String old, String Password, String P2) {
        String old_correct=clientMapper.selectByPrimaryKey(Client_no).getPassword().trim();
        String old_input_MD5="";
        try {
            old_input_MD5 = Tools.md5Encryp(old);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
            return 5;
        }

        if(old_correct.compareTo(old_input_MD5.trim())!=0)    return 1;
        if(Password.trim().compareTo("")==0|| Password==null || P2.trim().compareTo("")==0|| P2==null)   return 2;
        if(Password.trim().compareTo(P2.trim())!=0)    return 3;
        if(Password.trim().compareTo(old.trim())==0)    return 4;
        Client s=new Client();
        //因密码用MD5加密，需要对密码进行转化
        try {
            Password = Tools.md5Encryp(Password);
            s.setPassword(Password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
            return 5;
        }
        s.setClient_no(Client_no);
        clientMapper.updateByPrimaryKeySelective(s);
        return 6;
    }

    @Override
    public int Register_new_Client(String name, String password, String password_again) {
        if(password.trim().compareTo("")==0 || password==null ||
                password_again.trim().compareTo("")==0 || password_again==null) return 1;
        if(password.compareTo(password_again)!=0) return 2;

        String temp="";
        try {
            temp = Tools.md5Encryp(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        if(clientMapper.countBy_Name_and_Password(name,temp)==1) return 3;

        String select_Biggest_Client_no=clientMapper.select_Biggest_Client_no();
        System.out.println(select_Biggest_Client_no);
        String no="";
        int no_=Integer.parseInt(select_Biggest_Client_no);
        boolean flag=true;
        while(flag)
        {
            no_++;  no=""+no_;
            //System.out.println(no_+"");
            switch (no.length())
            {
                case 1: no="00000"+no;  break;
                case 2: no="0000"+no;   break;
                case 3: no="000"+no;    break;
                case 4: no="00"+no;     break;
                case 5: no="0"+no;      break;
                case 6: break;
            }
            if(!exist_or_not(no)) flag=false;
        }
        if(no.length()>=7)  return 4;

        Client s=new Client();
        s.setClient_no(no);
        s.setClient_name(name);
        s.setPassword(password);
        System.out.println(s);
        int i=insert_Client_details(s);
        if(i==1)    return 6;
        else        return 5;
    }

    @Override
    public Client Client_Log_in(String name, String password) {
        try {
            password = Tools.md5Encryp(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        System.out.println(password);
        if(clientMapper.countBy_Name_and_Password(name,password)!=1)return null;
        return clientMapper.selectBy_Name_and_Password(name,password);
    }

    @Override
    public List<Client> getAll_Client() throws Exception {
        ClientExample example = new ClientExample();
        List<Client> list=null;
        try{
            list=clientMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Client> selectBy_partName_or_partNo(String part) {
        return clientMapper.selectBy_partName_or_partNo(part,part);
    }

    @Override
    public List<Client> orderBy_Credit() {
        return clientMapper.orderBy_Credit();
    }

    @Override
    public List<Client> orderBy_Client_type() {
        return clientMapper.orderBy_Client_type();
    }

    @Override
    public int updateByPrimaryKey(Client client) {
        return clientMapper.updateByPrimaryKey(client);
    }

    @Override
    public int updateByPrimaryKeySelective(Client client) {
        return clientMapper.updateByPrimaryKeySelective(client);
    }

    @Override
    public int deleteByPrimaryKey(String Client_no) {
        return clientMapper.deleteByPrimaryKey(Client_no);
    }

    @Override
    public int insert(Client client) {
        return clientMapper.insert(client);
    }

    @Override
    public int insert_Client_details(Client client) {
        if(client.getClient_no().trim().compareTo("")==0 || client.getClient_name()==null)
            return 0;
        client.setClient_no(client.getClient_no());
        client.setClient_name(client.getClient_name()==null?"<无名氏>":client.getClient_name());
        client.setClient_type(client.getClient_type()==null?"1":client.getClient_type());
        client.setCredit(client.getCredit()==null?Long.parseLong("1"):client.getCredit());
        client.setDetails(client.getDetails()==null?"（该客户无详细资料介绍）":client.getDetails());

        String password = client.getPassword();
        if(password.trim().compareTo("")==0|| password==null)
            password="123456";
        //因密码用MD5加密，需要对密码进行转化
        try {
            password = Tools.md5Encryp(password);
            client.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        client.setPassword(password);
        clientMapper.insert(client);
        return 1;
    }

    @Override
    public int insertSelective(Client record) {
        return clientMapper.insertSelective(record);
    }

    @Override
    public int countByExample() {
        return 0;
    }

    @Override
    public boolean exist_or_not(String Client_no) {
        return clientMapper.exist_or_not(Client_no)>0;
    }

    @Override
    public Client selectByPrimaryKey(String Client_no) {
        return clientMapper.selectByPrimaryKey(Client_no);
    }
}
