/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public abstract class AbstractService<T , Id extends Serializable> implements InterfaceService<T, Id> {

   private SessionFactory sessionFactory;
    
    @SuppressWarnings("ProtectedField")
    protected Class<T> clazz;

    public AbstractService(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }    
    
    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Transactional
    @Override
    public void save(T entity) {
        currentSession().saveOrUpdate(entity);
    }
    
    @Transactional
    @Override
    public void update(T entity) {
        currentSession().update(entity);
    }
    
    @Transactional
    @Override
    public void delete(T entity) {
        currentSession().delete(entity);
    }
    
    @Transactional (readOnly=true)
    @SuppressWarnings("unchecked")
    @Override
    public T find(Id kode) {
        return (T) currentSession().get(clazz, kode);
    }
    
    @Transactional (readOnly=true)
    @Override
    public List<T> findAll() {
        return currentSession().createCriteria(clazz).list();
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public Integer countRows() {
        Long totalRow = (Long) currentSession()
                .createCriteria(clazz)
                .setProjection(Projections.rowCount())
                .uniqueResult();

        return totalRow.intValue();
    }
    
}
