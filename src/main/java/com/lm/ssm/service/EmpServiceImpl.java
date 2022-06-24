package com.lm.ssm.service;


import com.alibaba.fastjson.JSON;
import com.lm.ssm.entity.Emp;
import com.lm.ssm.mapper.EmpMapper;
import com.lm.ssm.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("EmpService")
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getAll() {
        System.out.println(empMapper);
        List<Emp> dep = empMapper.getAll();
        System.out.println("select one");
        System.out.println(dep);
        return dep;
    }

    @Override
    public Emp getEmpInfo(String username, String password){
        return empMapper.getEmpInfo(username,password);
    }

    @Override
    public Emp getUserById(String id) {
        return empMapper.getUserById(id);
    }

    @Override
    public int saveEmp(Emp emp) {
        return empMapper.saveEmp(emp);
    }

    @Override
    public int deleteEmp(String id) {
        return empMapper.deleteEmp(id);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public Map<String, Object> register(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        Emp emp = JSON.parseObject(JSON.toJSONString(params), Emp.class);
        try {
            emp.setLoginPassword(EncryptUtils.md5(emp.getLoginPassword(),"kakalukalulukaka"));
            System.out.println(emp);
            int result = empMapper.saveEmp(emp);
            if (result==1) {
                map.put("code", "200");
                map.put("message", "成功了");
            } else {
                map.put("code", "500");
                map.put("message", "失败了");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("message", e.getMessage());
        }

        return map;
    }
}
