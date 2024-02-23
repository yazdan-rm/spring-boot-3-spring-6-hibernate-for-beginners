package com.luv2code.springboot.demosecurity.dao;

import com.luv2code.springboot.demosecurity.entity.Instructor;
import com.luv2code.springboot.demosecurity.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(Long id);
    void deleteInstructorById(Long id);
    InstructorDetail findInstructorDetailById(Long theId);
    void deleteInstructorDetailById(Long theId);
}
