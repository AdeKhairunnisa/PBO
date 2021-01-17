/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author ASUS
 */
public class books {
   private String nama;
   private String ttl;
   private String kelamin;
   private String agama;
   private String status;
   private String jabatan;
   private String divisi;

    public books(String nama, String ttl, String kelamin, String agama, String status, String jabatan, String divisi) {
        this.nama = nama;
        this.ttl = ttl;
        this.kelamin = kelamin;
        this.agama = agama;
        this.status = status;
        this.jabatan = jabatan;
        this.divisi = divisi;
    }

    books(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNama() {
        return nama;
    }

    public String getTtl() {
        return ttl;
    }

    public String getKelamin() {
        return kelamin;
    }

    public String getAgama() {
        return agama;
    }

    public String getStatus() {
        return status;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getDivisi() {
        return divisi;
    }
           
           
   
   
}
