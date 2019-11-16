package com.example.ssmspringboot.dao.mappers;

import com.example.ssmspringboot.dao.Example.ClientExample;
import com.example.ssmspringboot.domain.Client;
import com.example.ssmspringboot.service.Service.ClientService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface ClientMapper{
    int exist_or_not(@Param("Client_no")String Client_no);

    int updateByExampleSelective(@Param("record") Client record, @Param("example") ClientExample example);//包括主键在内需要修改，但是内容可以为空
    int updateByExample(@Param("record") Client record, @Param("example") ClientExample example);//连主键也要修改

    int countByExample(ClientExample example);
    int countBy_Name_and_Password(@Param("Client_name")String name,@Param("Password")String password);

    int deleteByExample(ClientExample example);
    int deleteByPrimaryKey(String Staff_no);

    int insert(Client record);//不可以为空的Client插入
    int insertSelective(Client record);//部分插入内容，除了主键以外可以为空

    int updateByPrimaryKeySelective(Client record);//部分内容可以空
    int updateByPrimaryKey(Client record);//整体Client不得为空

    Client selectByPrimaryKey(String Client_no);
    Client selectBy_Name_and_Password(@Param("Client_name")String name,@Param("Password")String password);

    String select_Biggest_Client_no();

    List<Client> selectByExample(ClientExample example);
    List<Client> selectBy_partName_or_partNo(@Param("part1")String part1,@Param("part2")String part2);
    List<Client> orderBy_Credit();
    List<Client> orderBy_Client_type();
}
