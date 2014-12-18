/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.service.impl;

import com.prosdev.cakacaka.entity.Course;
import com.prosdev.cakacaka.service.AbstractService;
import com.prosdev.cakacaka.service.CourseService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class CourseServiceImplement extends AbstractService<Course, String>  implements CourseService{

    public CourseServiceImplement() {
        super(Course.class);
    }
    
}
