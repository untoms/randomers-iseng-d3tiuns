/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prosdev.cakacaka;

/**
 *
 * @author bustomi
 */
public class Random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        String kel[][]=new String[10][5];
        String nama[]={
        "Nur            ",
        "Adhi           ",
        "Nurul          ",
        "Octavia        ",
        "Offika         ",
        "Ovy            ",
        "Ari            ",
        "Pradipta       ",
        "Puguh          ",
        "Rajendra       ",
        "Ratna          ",
        "Rhaka          ",
        "Richa          ",
        "Richard        ",
        "Riny           ",
        "Rizky          ",
        "Rofiquzzaki    ",
        "Rosalia        ",
        "Rosyidan       ",
        "Ryan           ",
        "Ryan           ",
        "Sarah          ",
        "Sasmita        ",
        "Sendy          ",
        "Shoim          ",
        "Sonia          ",
        "Sylvia         ",
        "Teguh          ",
        "Titik          ",
        "Tony           ",
        "Tryanda        ",
        "Vichi          ",
        "Wahyu          ",
        "Wasis          ",
        "Widyanida      ",
        "Winda          ",
        "Windy          ",
        "Wisnu          ",
        "Wiwin          ",
        "Yefta          ",
        "Yogi           ",
        "Yunindya       ",
        "Yunita         ",
        "Yunni          ",
        "Maya           ",
        "Bustomi        ",
        "Fandi          ",
        "Fuaad          ",
        "Aden           "
        };
        boolean sudah[]=new boolean[nama.length];

        for (int i = 0; i <= 9; i++) {
            System.out.print("keompok :"+(i+1)+"\t");
            for (int j = 0; j <= 4; j++) {
                int b = 0;
                do {  
                    if (i==9 && j==4) {
                        break;
                    }
                    b=(int)(Math.random()*sudah.length);
                } while (sudah[b]==true);   
                kel[i][j]=nama[b];
                sudah[b]=true; 
                System.out.print("nama :"+nama[b]+"\t");
            } 
            System.out.println();
        }
    }
}
