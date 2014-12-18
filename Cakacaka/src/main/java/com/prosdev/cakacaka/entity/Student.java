/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Administrator
 */
@Entity
@Table (name = "Mahasiswa")
public class Student implements Serializable{
    
    @Id
    @Column (name = "nim", nullable = false, length = 8)
    private String nim;
    
    @Column (name = "name", nullable = false, length = 100)
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(name = "info", nullable = true, length = 255)
    private String info;
    
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Student_Group", joinColumns =
    @JoinColumn(name = "nim", nullable = false), inverseJoinColumns =
    @JoinColumn(name = "group_id", nullable = false))
    private final List<Group> groups = new ArrayList<>(0);
    
    @Transient
    private String group;
    
    @Transient
    private Boolean choosen=false;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nim);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.nim, other.nim)) {
            return false;
        }
        return true;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public void addGroup(Group group) {
        if (!groups.contains(group)) {
            groups.add(group);
        }
    }

    public void deleteGroup(Group group) {
        if (groups.contains(group)) {
            groups.remove(group);
        }
    }
  
    public void deleteGroup() {
        groups.clear();
    }

    public List<Group> getDaftarGroup() {
        return Collections.unmodifiableList(groups);
    }

    public Boolean getChoosen() {
        return choosen;
    }

    public void setChoosen(Boolean choosen) {
        this.choosen = choosen;
    }

    @Override
    public String toString() {
        return getName();
    }
}
