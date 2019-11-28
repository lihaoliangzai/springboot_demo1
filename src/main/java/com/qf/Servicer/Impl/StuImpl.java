package com.qf.Servicer.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.Servicer.IStuIServicer;
import com.qf.dao.StuM;
import com.qf.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuImpl extends ServiceImpl<StuM, Student> implements IStuIServicer {

    @Autowired
    private StuM stuM;

    @Override
    public int insert(Student student) {
        return stuM.insert(student);
    }

    @Override
    public int  lists(Integer id, Student student) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("student",student);
        return stuM.update(student,queryWrapper);
    }


}
