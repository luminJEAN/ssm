package com.lm.ssm.service;

import com.lm.ssm.entity.Emp;
import com.sun.tools.internal.ws.processor.model.Model;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface EmpService {
    List<Emp> getAll();
    Emp getUserById(String id);
    int saveEmp(Emp emp);
    int deleteEmp(String id);
    int updateEmp(Emp emp);
    Emp getEmpInfo(String username, String password);
    Map<String,Object> register(@RequestBody Map<String,Object> params);
}
