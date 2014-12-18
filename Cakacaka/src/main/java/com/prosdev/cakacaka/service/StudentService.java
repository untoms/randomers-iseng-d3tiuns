/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.service;

import com.prosdev.cakacaka.entity.Gender;
import com.prosdev.cakacaka.entity.Student;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface StudentService extends InterfaceService<Student, String> {
    
    int find(Gender gender);    
    List<Student> findAll(Gender gender);    
}