package com.lm.ssm.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.ssm.entity.Emp;
import com.lm.ssm.entity.Memorials;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemorialsMapper {
    List<Memorials> getMemorialsAll(Memorials memorials);
    List<Memorials> getMemorialsAllByPage(@Param("currentPage") int currentPage, @Param("size") int size, @Param("String") String query);
    Memorials getMemorialsById(@Param("id") String id);
    int saveMemorials(Memorials memorials);
    int deleteMemorials(@Param("id") String id);
    int updateMemorials(Memorials memorials);
    int applyMemorials(String id, String requestBody);
}
