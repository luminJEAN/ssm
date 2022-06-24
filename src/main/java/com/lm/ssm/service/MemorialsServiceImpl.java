package com.lm.ssm.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.ssm.entity.Emp;
import com.lm.ssm.entity.Memorials;
import com.lm.ssm.mapper.MemorialsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("Memorials")
public class MemorialsServiceImpl implements MemorialsService {
    @Autowired
    private MemorialsMapper memorialsMapper;
    @Override
    public List<Memorials> getMemorialsAll(Memorials memorials, HttpSession session) {
        Emp emp = (Emp) session.getAttribute("loginUser");
        int empId = emp.getEmpId();
        memorials.setEmpId(empId);
        System.out.println(123);
        System.out.println(memorials);
        return memorialsMapper.getMemorialsAll(memorials);
    }


    @Override
    public Memorials getMemorialsById(String id) {
        return memorialsMapper.getMemorialsById(id);
    }

    @Override
    public Map<String, Object> saveMemorials(Map<String,Object> params,HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Memorials memorials = JSON.parseObject(JSON.toJSONString(params), Memorials.class);
        Emp emp = (Emp) session.getAttribute("loginUser");
        System.out.println("loginUser = " + emp);
        memorials.setMemorialsStatus(0);
        memorials.setEmpId(emp.getEmpId());
        Date totay = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dayStr = sdf.format(totay);
        memorials.setMemorialsCreateTime(dayStr);
        System.out.println("service");
        System.out.println(memorials);
        int result = memorialsMapper.saveMemorials(memorials);
        if (result == 1) {
            map.put("code",200);
            map.put("message", "成功了");
        } else {
            map.put("code",500);
            map.put("message", "失败了");
        }
        return map;
    }

    @Override
    public int deleteMemorials(String id) {
        return memorialsMapper.deleteMemorials(id);
    }

    @Override
    public int updateMemorials(Memorials memorials) {
        return memorialsMapper.updateMemorials(memorials);
    }

    @Override
    public int applyMemorials(String id, String requestBody) {
        return memorialsMapper.applyMemorials(id,requestBody);
    }

    @Override
    public PageInfo<Memorials> getMemorialsAllByPage(int currentPage, int size, Memorials memorials, HttpSession session) {
        Emp emp = (Emp) session.getAttribute("loginUser");
        int empId = emp.getEmpId();
        memorials.setEmpId(empId);
        PageHelper.startPage(currentPage,size);

        List<Memorials> memList = memorialsMapper.getMemorialsAll(memorials);
        System.out.println(124);
        System.out.println(memList);
        PageInfo<Memorials> pageInfo = new PageInfo<>(memorialsMapper.getMemorialsAll(memorials));
//        PageInfo pageInfo = new PageInfo(lists);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
