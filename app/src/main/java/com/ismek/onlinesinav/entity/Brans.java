package com.ismek.onlinesinav.entity;

import java.util.Set;

public class Brans{

    private int bransId;

    private String bransAdi;

    private int kontenjan;

    private Set<Kullanici> kullanicilar;

    private Set<Sorular> sorulars;

    public int getBransId() {
        return bransId;
    }

    public void setBransId(int bransId) {
        this.bransId = bransId;
    }

    public String getBransAdi() {
        return bransAdi;
    }

    public void setBransAdi(String bransAdi) {
        this.bransAdi = bransAdi;
    }

    public int getKontenjan() {
        return kontenjan;
    }

    public void setKontenjan(int kontenjan) {
        this.kontenjan = kontenjan;
    }

    public Set<Kullanici> getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(Set<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public Set<Sorular> getSorulars() {
        return sorulars;
    }

    public void setSorulars(Set<Sorular> sorulars) {
        this.sorulars = sorulars;
    }
}