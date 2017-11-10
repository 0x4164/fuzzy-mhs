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
    private int interval[][];
    private String status[];
    private double x[];
    private String xnamakategori[];
    private double kebenaran[];
    private double xkebenaran[];
    private double xktotal;

    public void setInterval(int[][] interval) {
        this.interval = interval;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public void setXnamakategori(String[] xnamakategori) {
        this.xnamakategori = xnamakategori;
    }

    public void setKebenaran(double[] kebenaran) {
        this.kebenaran = kebenaran;
    }

    public void setXkebenaran(double[] xkebenaran) {
        this.xkebenaran = xkebenaran;
    }

    public void setXktotal(double xktotal) {
        this.xktotal = xktotal;
    }

    public int[][] getInterval() {
        return interval;
    }

    public String[] getStatus() {
        return status;
    }

    public double[] getX() {
        return x;
    }

    public String[] getXnamakategori() {
        return xnamakategori;
    }

    public double[] getKebenaran() {
        return kebenaran;
    }

    public double[] getXkebenaran() {
        return xkebenaran;
    }

    public double getXktotal() {
        return xktotal;
    }
    
    
    public double fuzz(int interval[][],String status[],double x[],String xnamakategori[],double kebenaran[],double xkebenaran[],double xktotal){
        double Z=0;
        for (int i = 0; i < x.length; i++) {
            System.out.println(xnamakategori[i]+" "+x[i]);
            //kurang
            if (x[i]<=interval[1][0]) {
                kebenaran[0]=1;
            }else if (x[i]>=interval[1][0]&&x[i]<=interval[0][1]) {
                kebenaran[0]=(double)(x[i]-interval[1][0])/50;
            }else if (x[i]>=interval[0][0]) {
                kebenaran[0]=0;
            }else{
                kebenaran[0]=0;
            }
            if (kebenaran[0]>0) {
                System.out.println(status[0]+" - "+kebenaran[0]);
            }
            //cukup
            if (x[i]<=interval[1][0]||x[i]>=interval[1][1]){
                kebenaran[1]=0;
            }else if(x[i]>=interval[1][0]&&x[i]<=(interval[0][1]+5)){
                kebenaran[1]=(double)(x[i]-interval[1][0])/15;
            }else if(x[i]>=(interval[0][1]+5)&&x[i]<=(interval[1][1])){
                kebenaran[1]=(double)(interval[1][1]-x[i])/15;
            }else{
                kebenaran[1]=0;
            }
            if (kebenaran[1]>0) {
                System.out.println(status[1]+" - "+kebenaran[1]);
            }

            //baik
            if (x[i]<=interval[2][0]&&x[i]>=interval[2][1]){
                kebenaran[2]=0;
            }else if(x[i]>=interval[2][0]&&x[i]<=(interval[1][1]+5)){
                kebenaran[2]=(double)(x[i]-interval[2][0])/15;
            }else if(x[i]>=(interval[1][1]+5)&&x[i]<=(interval[2][1])){
                kebenaran[2]=(double)(interval[2][1]-x[i])/15;
            }else{
                kebenaran[2]=0;
            }
            if (kebenaran[2]>0) {
                System.out.println(status[2]+" - "+kebenaran[2]);
            }
            //sangat baik
            if(x[i]<=interval[3][0]){
                kebenaran[3]=0;
            }else if(x[i]>=interval[1][1]&&x[i]<=interval[2][1]){
                kebenaran[3]=(double)(x[i]-interval[3][0])/10;
            }else if(x[i]>=interval[2][1]){
                kebenaran[3]=1;
            }else{
                kebenaran[3]=0;
            }
            if (kebenaran[3]>0) {
                System.out.println(status[3]+" - "+kebenaran[3]);
            }
            
            for (int j = 0; j < kebenaran.length; j++) {
//                System.out.println("ke "+kebenaran[j]);
                if (x.length==1) {
                    
                }
                if (kebenaran[j]>0) {
                    xkebenaran[i]=kebenaran[j];
                    xktotal+=kebenaran[j];
                    break;
                }
            }
            xkebenaran[i]*=x[i];
//            System.out.println(status[2]+" - "+kebenaran[2]);
            System.out.println("xk "+xkebenaran[i]+"\n");
            Z+=xkebenaran[i];
//            System.out.println(Z);
        }
        Z/=xktotal;
//        System.out.println("Z "+Z);
        return Z;
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
        
//        int x=87;
//        double x[]={70,75,89,80,70};
        double x[]={90,90,80,90,90};
        String xnamakategori[]={"Kepemimpinan","Administrasi","Manajemen","Teamwork","Partisipan"};
        double kebenaran[]={0,0,0,0};
        double xkebenaran[]=new double[x.length];
        double xktotal=0;
        double Z[]={0};
        
        m.setInterval(interval);
        m.setStatus(status);
        
        
        Z[0] = m.fuzz(interval, status, x, xnamakategori, kebenaran, xkebenaran, xktotal);

        System.out.println("Z "+Z[0]);
        
        String status2 []= {"Kurang Aktif","Cukup Aktif",
            "Aktif","Sangat Aktif"};
        Z[0] = m.fuzz(interval, status2, Z, xnamakategori, kebenaran, xkebenaran, xktotal);
    }
}
