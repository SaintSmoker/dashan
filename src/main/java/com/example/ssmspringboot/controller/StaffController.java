package com.example.ssmspringboot.controller;

import com.example.ssmspringboot.domain.Client;
import com.example.ssmspringboot.domain.Staff;
import com.example.ssmspringboot.service.Impl.StaffServiceImpl;
import com.example.ssmspringboot.service.Service.ClientService;
import com.example.ssmspringboot.service.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller	//声明这是Controller层
public class StaffController {
    //依赖注入
    @Autowired
    StaffService staffService;
    @Autowired
    ClientService clientService;

    @RequestMapping(value="/login2")
    public String login(@RequestParam(value = "Staff_name", required = false) String Staff_name,
                        @RequestParam(value = "password", required = false) String password,
                        HttpServletRequest request) throws Exception {
        Staff staff=new Staff();
        staff.setStaff_name("12345");
        staff.setPassword(password);
        System.out.println("前端"+staff);
        Staff s=staffService.Staff_Log_in(staff.getStaff_name(),staff.getPassword());
        System.out.println("DAO"+s);
        if (s!=null){
            /***************************************************************************************************/
            System.out.println("/*Staff*********************************************************************************************/");

            System.out.println(staffService.update_Password_By_PrimaryKey(s.getStaff_no(),"123456","12345","12345"));
            if(staffService.exist_or_not("123456")==false)
                staffService.Register_new_Staff("TCP/IP","23333","23333");

            List<Staff> list1=staffService.getAll_Staff();
            List<Staff> list2=staffService.select_Department_orderBy_Busy("销售");
            List<Staff> list3=staffService.selectBy_partName_or_partNo("3");
            List<Staff> list4=staffService.orderBy_Authority();


            for(int i=0;i<list1.size();i++)
                System.out.println(list1.get(i));
            System.out.println();

            for(int j=0;j<list2.size();j++)
                System.out.println(list2.get(j));
            System.out.println();

            for(int j=0;j<list3.size();j++)
                System.out.println(list3.get(j));
            System.out.println();

            for(int j=0;j<list4.size();j++)
                System.out.println(list4.get(j));



            /***************************************************************************************************/
            System.out.println("/*Client********************************************************************************************/");

            if(clientService.exist_or_not("000010")==false)
               clientService.Register_new_Client("虚拟用户A","123456","123456");

            clientService.update_Password_By_PrimaryKey("000002","123456","12345","12345");
            System.out.println(clientService.Client_Log_in("虚拟用户A","12345"));
            List<Client> list5=clientService.getAll_Client();
            List<Client> list6=clientService.orderBy_Credit();
            List<Client> list7=clientService.orderBy_Client_type();
            System.out.println();

            for(int j=0;j<list5.size();j++)
                System.out.println(list5.get(j));
            System.out.println();

            for(int j=0;j<list6.size();j++)
                System.out.println(list6.get(j));
            System.out.println();

            for(int j=0;j<list7.size();j++)
                System.out.println(list7.get(j));



            /***************************************************************************************************/
            System.out.println("/*Order_Form****************************************************************************************/");

            Date date = new Date();
            Timestamp nousedate = new Timestamp(date.getTime());
            System.out.println(nousedate.toString());



            return "success";
        }
        return "failed";
    }
}