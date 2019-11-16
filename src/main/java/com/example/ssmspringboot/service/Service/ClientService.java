package com.example.ssmspringboot.service.Service;

import com.example.ssmspringboot.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    int update_Password_By_PrimaryKey(String Client_no,String OldPassword,String NewPassword,String NewPassword_again);
    //返回：1（旧密码错误）；2（新密码存在空值）；3（两个新密码冲突）；4（密码未变更）；5（MD5转化失败）；6（修改成功）

    int Register_new_Client(String name,String password,String password_again);
    //返回：1（密码空）；2（两次密码不一致）；3（已经注册的用户名与密码）；4（人员注册过多，超过上限一百万）；5（添加过程失败）；6（注册成功）

    Client Client_Log_in(String name, String password);
    //返回：null（密码错误，或者用户不存在）;非null（登录成功，返回职工信息client类）

    List<Client> getAll_Client()throws Exception;
    //全员信息

    List<Client> selectBy_partName_or_partNo(String part);

    List<Client> orderBy_Credit();
    List<Client> orderBy_Client_type();

    /***********************************************************************************/

    int updateByPrimaryKey(Client client);//Client任意数据不可以为空，否则会覆盖数据库原本数据
    int updateByPrimaryKeySelective(Client client);//更新的Client，除了主键以外均可以为null，null部分数据库不更新

    int deleteByPrimaryKey(String client_no);//用主键删除

    int insert(Client client);//Client任何数据都不可以null
    int insert_Client_details(Client client);//Client部分内容可以null，加入表内为默认补全数据，eg.Password设置为"123456"
    int insertSelective(Client record);//Client部分内容可以null，加入表内就是null


    int countByExample();//最好不要用这个
    boolean exist_or_not(String Client_no);//用主键判断是否存在

    Client selectByPrimaryKey(String Client_no);//用主键选人


}
