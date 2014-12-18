/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka.entity;

/**
 *
 * @author Administrator
 */
public enum Gender {

    MALE("Boy"),
    FEMALE("Girl");
    
    private final String nama;

    private Gender(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
