/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilaimhs;

import java.lang.*;
import java.text.*;
/**
 *
 * @author root
 */
public class Main {
    private int irendah[];
    private int tengah[];
    private int tinggi[];
    private int sangattinggi[];
    private String status [];
    private double kebenaran;
    
    public Main() {
    }
    
    
    public void setInterval(int[][] interval) {
        this.irendah = interval[0];
        this.tengah = interval[1];
        this.tinggi = interval[2];
        this.sangattinggi = interval[3];
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
    
    
    
    public static void main(String[] args) {
        Main m = new Main();
        //interval 2xVal;
        int interval[][] = {{0,50},
            {40,70},
            {60,90},
            {80,100}
        };
        String status []= {"Kurang","Cukup","Baik","Sangat Baik"};
        
        m.setInterval(interval);
        m.setStatus(status);
        
        int x=76;
        
        double kebenaran=0;
        System.out.println(x);
        if (x<=interval[1][0]
                ||x>=interval[1][0]&&x<=interval[0][1]
                ||x>=interval[0][0]) {//kurang
            if (x<=interval[1][0]) {
                kebenaran=1;
  //              System.out.println("st "+kebenaran);
            }else if (x>=interval[1][0]&&x<=interval[0][1]) {
                kebenaran=(double)(x-interval[1][0])/50;
//                kebenaran=0.5;
//                System.out.print("lv ");System.out.printf("%.2f",kebenaran);
//                System.out.println("k "+kebenaran);
            }else if (x==interval[0][0]) {
                kebenaran=0;
            }
            System.out.println(status[0]+" - "+kebenaran);
        }
        if (x<=interval[1][0]&&x>=interval[1][1]
                ||x>=interval[1][0]&&x<=(interval[0][1]+5)
                ||x>=(interval[0][1]+5)&&x<=(interval[1][1])) {//cukup
            if (x<=interval[1][0]&&x>=interval[1][1]){
                kebenaran=0;
            }else if(x>=interval[1][0]&&x<=(interval[0][1]+5)){
                kebenaran=(double)(x-interval[1][0])/15;
            }else if(x>=(interval[0][1]+5)&&x<=(interval[1][1])){
                kebenaran=(double)(interval[1][1]-x)/15;
            }
            System.out.println(status[1]+" - "+kebenaran);
        }
        if (x<=interval[2][1]&&x>=interval[2][1]
                ||x>=interval[2][0]&&x<=(interval[1][1]+5)
                ||x>=(interval[1][1]+5)&&x<=(interval[2][1])) {//baik
            if (x<=interval[2][1]&&x>=interval[2][1]){
                kebenaran=0;
                
            }else if(x>=interval[2][0]&&x<=(interval[1][1]+5)){
                kebenaran=(double)(x-interval[2][0])/15;
                
            }else if(x>=(interval[1][1]+5)&&x<=(interval[2][1])){
                kebenaran=(double)(interval[2][1]-x)/15;
                
            }
            System.out.println(status[2]+" - "+kebenaran);
//if (x<=interval[1][0]||x>=interval[1][0]&&x<=interval[0][1]||x>=interval[0][0]) {
            //System.out.println(status[0]);
        }
        if (x<=interval[3][0]
                ||x>=interval[2][0]&&x<=interval[2][1]
                ||x>=interval[2][1]){
            if(x<=interval[3][0]){
                kebenaran=0;
                
            }else if(x>=interval[2][0]&&x<=interval[2][1]){
                kebenaran=(double)(x-interval[2][0])/10;
                
            }else if(x>=interval[2][1]){
                kebenaran=1;
                
            }
            System.out.println(status[3]+" - "+kebenaran);
        }
    }
}
