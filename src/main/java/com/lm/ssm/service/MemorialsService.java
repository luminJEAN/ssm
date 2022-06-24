package com.lm.ssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.ssm.entity.Memorials;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface MemorialsService {
    List<Memorials> getMemorialsAll(Memorials memorials, HttpSession session);
    PageInfo<Memorials> getMemorialsAllByPage(int currentPage, int size, Memorials memorials, HttpSession session);
    Memorials getMemorialsById(@Param("id") String id);
    Map<String, Object> saveMemorials(Map<String,Object> params, HttpSession session);
    int deleteMemorials(@Param("id") String id);
    int updateMemorials(Memorials memorials);
    int applyMemorials(String id, String requestBody);

}
