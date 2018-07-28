package com.ismek.onlinesinav.entity;

import java.util.Date;
import java.util.List;

public class Sorular {

    private long soruId;

    private String soru;

    private String secenekler;

    private String secenekSayisi;

    private String cevap;

    private Date eklemeTarihi;

    private Integer soruPuan;

    private Integer isOnay;

    private Integer isAktif;

    private String zorlukSeviyesi;

    private Kullanici kullanici;

    private List<Brans> brans;

    private SoruAnaliz soruanaliz;

    public Sorular() {}

    public long getSoruId() {
        return soruId;
    }

    public void setSoruId(long soruId) {
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

    public Date getEklemeTarihi() {
        return eklemeTarihi;
    }

    public void setEklemeTarihi(Date eklemeTarihi) {
        this.eklemeTarihi = eklemeTarihi;
    }

    public Integer getSoruPuan() {
        return soruPuan;
    }

    public void setSoruPuan(Integer soruPuan) {
        this.soruPuan = soruPuan;
    }

    public Integer getIsOnay() {
        return isOnay;
    }

    public void setIsOnay(Integer isOnay) {
        this.isOnay = isOnay;
    }

    public Integer getIsAktif() {
        return isAktif;
    }

    public void setIsAktif(Integer isAktif) {
        this.isAktif = isAktif;
    }

    public String getZorlukSeviyesi() {
        return zorlukSeviyesi;
    }

    public void setZorlukSeviyesi(String zorlukSeviyesi) {
        this.zorlukSeviyesi = zorlukSeviyesi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Brans> getBrans() {
        return brans;
    }

    public void setBrans(List<Brans> brans) {
        this.brans = brans;
    }

    public SoruAnaliz getSoruanaliz() {
        return soruanaliz;
    }

    public void setSoruanaliz(SoruAnaliz soruanaliz) {
        this.soruanaliz = soruanaliz;
    }

}