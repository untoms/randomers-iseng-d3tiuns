/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.service.impl;

import com.prosdev.cakacaka.entity.Gender;
import com.prosdev.cakacaka.entity.Student;
import com.prosdev.cakacaka.service.AbstractService;
import com.prosdev.cakacaka.service.StudentService;
import java.util.List;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class StudentServiceImplement extends AbstractService<Student, String>  implements StudentService{

    public StudentServiceImplement() {
        super(Student.class);
    }
    
    @Transactional (readOnly=true)
    @Override
    public int find(Gender gender) {
        Long hasil= (Long) currentSession()
                .createCriteria(clazz)
                .setProjection(Projections.rowCount())
                .add(Restrictions.eq("gender", gender))
                .uniqueResult();
        return hasil.intValue() ;
    }
    
    @Transactional
    @Override
    public List<Student> findAll(Gender gender) {
        return currentSession()
                .createCriteria(clazz)
                .add(Restrictions.eq("gender", gender))
                .list();
    }
    
}
