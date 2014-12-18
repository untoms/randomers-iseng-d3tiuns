/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.prosdev.cakacaka.view.panel.tablemodel;

import com.prosdev.cakacaka.entity.Student;


/**
 *
 * @author PacuL
 */
public class TableModelStudent extends ParentTableModel<Student>{
    
    private String [] columnNames={"#","NIM","NAME","GENDER","GROUP"};

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getNim();
            case 2 : return getList().get(rowIndex).getName();             
            case 3 : return getList().get(rowIndex).getGender();
            case 4 : return getList().get(rowIndex).getGroup();   
                default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
