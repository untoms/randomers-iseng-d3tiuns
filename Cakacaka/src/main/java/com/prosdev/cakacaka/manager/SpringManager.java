/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.manager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class SpringManager {
    
    private final ApplicationContext applicationContext;

    public SpringManager() {
        ClassPathXmlApplicationContext  cpxac=new ClassPathXmlApplicationContext("spring.xml");
        cpxac.registerShutdownHook();
        this.applicationContext=cpxac;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    public <T> T getBean(Class<T> requireType) throws BeansException{
        return applicationContext.getBean(requireType);
    }
    
    public <T> T getBean(String name,Class<T> requireType) throws BeansException{
        return applicationContext.getBean(name,requireType);
    }
    
    private static SpringManager INSTANCE;

    public static SpringManager getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SpringManager();
        }
        return SpringManager.INSTANCE;
    }
    
    
        
}
