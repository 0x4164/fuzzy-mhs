/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilaimhs;

/**
 *
 * @author root
 */
public class Mahasiswa {
    private double kepemimpinan;
    private double administrasi;
    private double manajemen;
    private double teamwork;
    private double partisipan;

    public Mahasiswa(double kepemimpinan, double administrasi, double manajemen, double teamwork, double partisipan) {
        this.kepemimpinan = kepemimpinan;
        this.administrasi = administrasi;
        this.manajemen = manajemen;
        this.teamwork = teamwork;
        this.partisipan = partisipan;
    }
    
    public Mahasiswa(double []arr){
        this.kepemimpinan = arr[0];
        this.administrasi = arr[1];
        this.manajemen = arr[2];
        this.teamwork = arr[3];
        this.partisipan = arr[4];
    }
    
    public void setKepemimpinan(double kepemimpinan) {
        this.kepemimpinan = kepemimpinan;
    }

    public void setAdministrasi(double administrasi) {
        this.administrasi = administrasi;
    }

    public void setManajemen(double manajemen) {
        this.manajemen = manajemen;
    }

    public void setTeamwork(double teamwork) {
        this.teamwork = teamwork;
    }

    public void setPartisipan(double partisipan) {
        this.partisipan = partisipan;
    }
    
    public double getKepemimpinan() {
        return kepemimpinan;
    }

    public double getAdministrasi() {
        return administrasi;
    }

    public double getManajemen() {
        return manajemen;
    }

    public double getTeamwork() {
        return teamwork;
    }

    public double getPartisipan() {
        return partisipan;
    }
    
    
}
