package com.qf.Servicer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.entity.Student;

public interface IStuIServicer  extends IService<Student> {

    int insert(Student student);

    int  lists(Integer id, Student student);
}
