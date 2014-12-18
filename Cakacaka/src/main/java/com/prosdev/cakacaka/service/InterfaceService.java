/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface InterfaceService <T, Id extends Serializable>{
    
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T find(Id kode);
    List<T> findAll();   
    Integer countRows();
}
