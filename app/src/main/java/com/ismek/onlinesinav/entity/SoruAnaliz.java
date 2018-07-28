package com.ismek.onlinesinav.entity;

public class SoruAnaliz {

    private long analizId;

    private Integer dogruSayisi;

    private Integer yanlisSayisi;

    private Integer bosSayisi;

    private Sorular soru;


    public long getAnalizId() {
        return analizId;
    }

    public void setAnalizId(long analizId) {
        this.analizId = analizId;
    }

    public Integer getDogruSayisi() {
        return dogruSayisi;
    }

    public void setDogruSayisi(Integer dogruSayisi) {
        this.dogruSayisi = dogruSayisi;
    }

    public Integer getYanlisSayisi() {
        return yanlisSayisi;
    }

    public void setYanlisSayisi(Integer yanlisSayisi) {
        this.yanlisSayisi = yanlisSayisi;
    }

    public Integer getBosSayisi() {
        return bosSayisi;
    }

    public void setBosSayisi(Integer bosSayisi) {
        this.bosSayisi = bosSayisi;
    }

    public Sorular getSoru() {
        return soru;
    }

    public void setSoru(Sorular soru) {
        this.soru = soru;
    }
}
