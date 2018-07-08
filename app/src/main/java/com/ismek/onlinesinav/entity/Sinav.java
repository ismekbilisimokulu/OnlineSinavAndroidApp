package com.ismek.onlinesinav.entity;


import java.util.Date;

public class Sinav {

    private int sinavId;

    private String sinavAdi;

    private Date sinavTarihi;


    private int sinavSuresi;


    private int soruSayisi;


    private Date bsSaati;

    private String sinavSalonu;

    private float katkiYuzdesi;

    private Date olusturmaTarihi;

    private Kullanici ogretmenId;


    private boolean isAktif;

    private Brans bransId;


    public Sinav(){}

    public int getSinavId() {
        return sinavId;
    }

    public void setSinavId(int sinavId) {
        this.sinavId = sinavId;
    }

    public String getSinavAdi() {
        return sinavAdi;
    }

    public void setSinavAdi(String sinavAdi) {
        this.sinavAdi = sinavAdi;
    }

    public Date getSinavTarihi() {
        return sinavTarihi;
    }

    public void setSinavTarihi(Date sinavTarihi) {
        this.sinavTarihi = sinavTarihi;
    }

    public int getSinavSuresi() {
        return sinavSuresi;
    }

    public void setSinavSuresi(int sinavSuresi) {
        this.sinavSuresi = sinavSuresi;
    }

    public int getSoruSayisi() {
        return soruSayisi;
    }

    public void setSoruSayisi(int soruSayisi) {
        this.soruSayisi = soruSayisi;
    }

    public Date getBsSaati() {
        return bsSaati;
    }

    public void setBsSaati(Date bsSaati) {
        this.bsSaati = bsSaati;
    }

    public String getSinavSalonu() {
        return sinavSalonu;
    }

    public void setSinavSalonu(String sinavSalonu) {
        this.sinavSalonu = sinavSalonu;
    }

    public float getKatkiYuzdesi() {
        return katkiYuzdesi;
    }

    public void setKatkiYuzdesi(float katkiYuzdesi) {
        this.katkiYuzdesi = katkiYuzdesi;
    }

    public Date getOlusturmaTarihi() {
        return olusturmaTarihi;
    }

    public void setOlusturmaTarihi(Date olusturmaTarihi) {
        this.olusturmaTarihi = olusturmaTarihi;
    }

    public Kullanici getOgretmenId() {
        return ogretmenId;
    }

    public void setOgretmenId(Kullanici ogretmenId) {
        this.ogretmenId = ogretmenId;
    }

    public boolean isAktif() {
        return isAktif;
    }

    public void setAktif(boolean aktif) {
        isAktif = aktif;
    }

    public Brans getBransId() {
        return bransId;
    }

    public void setBransId(Brans bransId) {
        this.bransId = bransId;
    }
}