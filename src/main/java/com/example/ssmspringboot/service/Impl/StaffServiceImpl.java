package com.example.ssmspringboot.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.ssmspringboot.dao.Example.StaffExample;
import com.example.ssmspringboot.dao.mappers.StaffMapper;
import com.example.ssmspringboot.datasource.exception.JshException;
import com.example.ssmspringboot.datasource.units.Tools;
import com.example.ssmspringboot.domain.Staff;
import com.example.ssmspringboot.service.Service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements  StaffService{

    private Logger logger = LoggerFactory.getLogger(StaffService.class);
    @Autowired
    StaffMapper staffMapper;

    @Override
    public Staff selectByPrimaryKey(String userno) {
        return staffMapper.selectByPrimaryKey(userno);
    }

    @Override
    public boolean exist_or_not(String Staff_no){
        return staffMapper.exist_or_not(Staff_no)>0;
    }

    @Override
    public int countByExample() {
        return 0;
    }

    @Override
    public List<Staff> getAll_Staff() throws Exception {
        StaffExample example = new StaffExample();
        List<Staff> list=null;
        try{
            list=staffMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Staff> selectBy_partName_or_partNo(String part) {
        if(part==null || part.trim().compareTo("")==0)  part="";
        return staffMapper.selectBy_partName_or_partNo(part,part);
    }

    @Override
    public List<Staff> orderBy_Authority() {
        return staffMapper.orderBy_Authority();
    }

    @Override
    public List<Staff> select_Department_orderBy_Busy(String Department) {
        List<Staff> list=null;
        try{
            list=staffMapper.select_Department_orderBy_Busy(Department);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public int insert(Staff s){
        return staffMapper.insert(s);
    }

    @Override
    public int insert_Staff_details(Staff staff){
        if(staff.getStaff_no().trim().compareTo("")==0 || staff.getStaff_no()==null)
            return 0;
        staff.setStaff_no(staff.getStaff_no());
        staff.setStaff_name(staff.getStaff_name()==null?"<无名氏>":staff.getStaff_name());
        staff.setPassword(staff.getPassword()==null?"":staff.getPassword());
        staff.setDepartment(staff.getDepartment()==null?"生产车间":staff.getDepartment());
        staff.setWorkshop(staff.getWorkshop()==null?"车间A":staff.getWorkshop());
        staff.setAuthority(staff.getAuthority()==null?Long.parseLong(0+""):staff.getAuthority());
        staff.setBusy(staff.getBusy()==null?Long.parseLong(0+""):staff.getBusy());
        staff.setPosition(staff.getPosition()==null?"普通职工":staff.getPosition());
        staff.setDetails(staff.getDetails()==null?"（该职工无详细资料介绍）":staff.getDetails());

        String password = staff.getPassword();
        if(password.trim().compareTo("")==0|| password==null)
            password="123456";
        //因密码用MD5加密，需要对密码进行转化
        try {
            password = Tools.md5Encryp(password);
            staff.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        staffMapper.insert(staff);
        return 1;
    }

    @Override
    public int insertSelective(Staff record) {
        return staffMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String Staff_no){
        return staffMapper.deleteByPrimaryKey(Staff_no);
    }

    @Override
    public int updateByPrimaryKey(Staff staff){
        //传入实体类Staff，以Staff_no为检索修改，其他数据不得为空null或0
        return staffMapper.updateByPrimaryKey(staff);
    }

    @Override
    public int updateByPrimaryKeySelective(Staff staff){
        //传入实体类Staff，以Staff_no为检索修改，其他数据可以为空null或0
        return staffMapper.updateByPrimaryKeySelective(staff);
    }

    @Override
    public int update_Password_By_PrimaryKey(String Staff_no,String old, String Password,String P2) {
        String old_correct=staffMapper.selectByPrimaryKey(Staff_no).getPassword().trim();
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
        Staff s=new Staff();
        //因密码用MD5加密，需要对密码进行转化
        try {
            Password = Tools.md5Encryp(Password);
            s.setPassword(Password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
            return 5;
        }
        s.setStaff_no(Staff_no);
        staffMapper.updateByPrimaryKeySelective(s);
        return 6;
    }

    @Override
    public int Register_new_Staff(String name, String password, String password_again) {
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
        if(staffMapper.countBy_Name_and_Password(name,temp)==1) return 3;

        String select_Biggest_Staff_no=staffMapper.select_Biggest_Staff_no();
        String no="";
        int no_=Integer.parseInt(select_Biggest_Staff_no);
        boolean flag=true;
        while(flag)
        {
            no_++;  no=""+no_;
            System.out.println(no_+"");
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

        Staff s=new Staff();
        s.setStaff_no(no);
        s.setStaff_name(name);
        s.setPassword(password);
        int i=insert_Staff_details(s);
        if(i==1)    return 6;
        else        return 5;
    }

    @Override
    public Staff Staff_Log_in(String name, String password) {
        try {
            password = Tools.md5Encryp(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        if(staffMapper.countBy_Name_and_Password(name,password)!=1)return null;
        return staffMapper.selectBy_Name_and_Password(name,password);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertUser(String beanJson, HttpServletRequest request)throws Exception {
        Staff staff = JSONObject.parseObject(beanJson, Staff.class);
        String password = "123456";
        //因密码用MD5加密，需要对密码进行转化
        try {
            password = Tools.md5Encryp(password);
            staff.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        int result=0;
        try{
            result=staffMapper.insertSelective(staff);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

}