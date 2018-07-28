package com.ismek.onlinesinav.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Kullanici{

    private long kullaniciId;

    private String tcNo;

    private String ad;

    private String soyAdi;

    private String telefon;

    private String mail;

    private Date dogumTarihi;

    private String cinsiyet;

    private List<Role> roles;

    private List<Brans> branslar;

    private List<Sorular> sorular;

    private List<Sinav> sinav = new ArrayList<Sinav>();

    private List<KullaniciToSinav> kullaniciToSinav;

    public Kullanici() {


    }

    public long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAdi() {
        return soyAdi;
    }

    public void setSoyAdi(String soyAdi) {
        this.soyAdi = soyAdi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Brans> getBranslar() {
        return branslar;
    }

    public void setBranslar(List<Brans> branslar) {
        this.branslar = branslar;
    }

    public List<Sorular> getSorular() {
        return sorular;
    }

    public void setSorular(List<Sorular> sorular) {
        this.sorular = sorular;
    }

    public List<Sinav> getSinav() {
        return sinav;
    }

    public void setSinav(List<Sinav> sinav) {
        this.sinav = sinav;
    }

    public List<KullaniciToSinav> getKullaniciToSinav() {
        return kullaniciToSinav;
    }

    public void setKullaniciToSinav(List<KullaniciToSinav> kullaniciToSinav) {
        this.kullaniciToSinav = kullaniciToSinav;
    }
}