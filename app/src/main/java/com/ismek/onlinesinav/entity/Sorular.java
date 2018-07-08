package com.ismek.onlinesinav.entity;

import java.util.Date;

public class Sorular {

	private Integer soruId;

	private String soru;

	private String secenekler;

	private String secenekSayisi;

	private String cevap;

	private Date eklenmeTarihi;

	private Integer soruPuan;

	private Boolean isOnay;

	private Boolean isAktif;

	private String zorlukSeviye;

	private Integer kullaniciId;


    public Integer getSoruId() {
        return soruId;
    }

    public void setSoruId(Integer soruId) {
        this.soruId = soruId;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getSecenekler() {
        return secenekler;
    }

    public void setSecenekler(String secenekler) {
        this.secenekler = secenekler;
    }

    public String getSecenekSayisi() {
        return secenekSayisi;
    }

    public void setSecenekSayisi(String secenekSayisi) {
        this.secenekSayisi = secenekSayisi;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public Date getEklenmeTarihi() {
        return eklenmeTarihi;
    }

    public void setEklenmeTarihi(Date eklenmeTarihi) {
        this.eklenmeTarihi = eklenmeTarihi;
    }

    public Integer getSoruPuan() {
        return soruPuan;
    }

    public void setSoruPuan(Integer soruPuan) {
        this.soruPuan = soruPuan;
    }

    public Boolean getOnay() {
        return isOnay;
    }

    public void setOnay(Boolean onay) {
        isOnay = onay;
    }

    public Boolean getAktif() {
        return isAktif;
    }

    public void setAktif(Boolean aktif) {
        isAktif = aktif;
    }

    public String getZorlukSeviye() {
        return zorlukSeviye;
    }

    public void setZorlukSeviye(String zorlukSeviye) {
        this.zorlukSeviye = zorlukSeviye;
    }

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
}