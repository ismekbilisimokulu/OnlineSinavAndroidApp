package com.ismek.onlinesinav.entity;

import java.util.Date;
import java.util.Set;

public class Kullanici{

	private int kullaniciId;

	private String tcNo;

	private String ad;

	private String soyAdi;

	private String telefon;

	private String mail;

	private Date dogumTarihi;

	private String cinsiyet;

	private Set<Role> roles;

	private Set<Brans> branslar;

	public Set<Role> getRoles() {
		return roles;
	}


    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
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

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Brans> getBranslar() {
        return branslar;
    }

    public void setBranslar(Set<Brans> branslar) {
        this.branslar = branslar;
    }

}