package com.example.ssmspringboot.service.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.ssmspringboot.dao.Example.StaffExample;
import com.example.ssmspringboot.dao.mappers.StaffMapper;
import com.example.ssmspringboot.datasource.exception.JshException;
import com.example.ssmspringboot.datasource.units.Tools;
import com.example.ssmspringboot.domain.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface StaffService {

    int update_Password_By_PrimaryKey(String Staff_no,String OldPassword,String NewPassword,String NewPassword_again);
    //返回：1（旧密码错误）；2（新密码存在空值）；3（两个新密码冲突）；4（密码未变更）；5（MD5转化失败）；6（修改成功）

    int Register_new_Staff(String name,String password,String password_again);
    //返回：1（密码空）；2（两次密码不一致）；3（已经注册的用户名与密码）；4（人员注册过多，超过上限一百万）；5（添加过程失败）；6（注册成功）

    Staff Staff_Log_in(String name,String password);
    //返回：null（密码错误，或者用户不存在）;非null（登录成功，返回职工信息Staff类）

    List<Staff> getAll_Staff()throws Exception;
    //全员信息

    List<Staff> selectBy_partName_or_partNo(String part);
    //模糊查询

    List<Staff> orderBy_Authority();
    //按照权限高低排序

    List<Staff> select_Department_orderBy_Busy(String Department);
    //选择一个部门（销售，会计等），按照他们人员繁忙程度（闲->忙）排序

    /***********************************************************************************/

    int updateByPrimaryKey(Staff staff);//Staff任意数据不可以为空，否则会覆盖数据库原本数据
    int updateByPrimaryKeySelective(Staff staff);//更新的Staff，除了主键以外均可以为null，null部分数据库不更新

    int deleteByPrimaryKey(String Staff_no);//用主键删除

    int insert(Staff staff);//Staff任何数据都不可以null
    int insert_Staff_details(Staff staff);//Staff部分内容可以null，加入表内为默认补全数据，eg.Password设置为"123456"
    int insertSelective(Staff record);//Staff部分内容可以null，加入表内就是null


    int countByExample();//最好不要用这个
    boolean exist_or_not(String Staff_no);//用主键判断是否存在

    Staff selectByPrimaryKey(String Staff_no);//用主键选人
}