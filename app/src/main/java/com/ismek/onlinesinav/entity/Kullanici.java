package com.ismek.onlinesinav.entity;

import java.util.Date;

public class Kullanici {
	private Integer kullaniciId;

	private String tcNo;

	private String adi;

	private String soyadi;

	private String telefon;

	private String mail;

	private Date dogumTarihi;

	private String cinsiyet;
	
	public Integer getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(Integer kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public String getTcNo() {
		return tcNo;
	}
	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
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

	@Override
	public String toString() {
		return "Kullanici{" +
				"kullaniciId=" + kullaniciId +
				", tcNo='" + tcNo + '\'' +
				", adi='" + adi + '\'' +
				", soyadi='" + soyadi + '\'' +
				", telefon='" + telefon + '\'' +
				", mail='" + mail + '\'' +
				", dogumTarihi=" + dogumTarihi +
				", cinsiyet='" + cinsiyet + '\'' +
				'}';
	}
}