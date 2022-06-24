package com.lm.ssm.mapper;

import com.lm.ssm.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpMapper {
    List<Emp> getAll();
    Emp getUserById(@Param("id") String id);
    int saveEmp(Emp emp);
    int deleteEmp(@Param("id") String id);
    int updateEmp(Emp emp);
    Emp getEmpInfo(@Param("username") String username, @Param("password") String password);
;}
