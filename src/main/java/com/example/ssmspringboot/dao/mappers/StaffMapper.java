package com.example.ssmspringboot.dao.mappers;

import com.example.ssmspringboot.dao.Example.StaffExample;
import com.example.ssmspringboot.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    int exist_or_not(@Param("Staff_no")String Staff_no);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);//包括主键在内需要修改，但是内容可以为空
    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);//连主键也要修改

    int countByExample(StaffExample example);
    int countBy_Name_and_Password(@Param("Staff_name")String name,@Param("Password")String password);

    int deleteByExample(StaffExample example);
    int deleteByPrimaryKey(String Staff_no);

    int insert(Staff record);//不可以为空的Staff插入
    int insertSelective(Staff record);//部分插入内容，除了主键以外可以为空

    int updateByPrimaryKeySelective(Staff record);//部分内容可以空
    int updateByPrimaryKey(Staff record);//整体Staff不得为空

    List<Staff> select_Department_orderBy_Busy(@Param("Department")String Department);
    List<Staff> selectByExample(StaffExample example);
    List<Staff> selectBy_partName_or_partNo(@Param("part1")String part1,@Param("part2")String part2);
    List<Staff> orderBy_Authority();

    Staff selectByPrimaryKey(String Staff_no);
    Staff selectBy_Name_and_Password(@Param("Staff_name")String name,@Param("Password")String password);

    String select_Biggest_Staff_no();
}