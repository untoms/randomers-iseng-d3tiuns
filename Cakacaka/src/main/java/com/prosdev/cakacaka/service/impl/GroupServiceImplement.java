/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.service.impl;

import com.prosdev.cakacaka.entity.Group;
import com.prosdev.cakacaka.service.AbstractService;
import com.prosdev.cakacaka.service.GroupService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class GroupServiceImplement extends AbstractService<Group, Integer>  implements GroupService{

    public GroupServiceImplement() {
        super(Group.class);
    }
    
}
