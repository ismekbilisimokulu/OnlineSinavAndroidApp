package com.ismek.onlinesinav.entity;

public class SinavSonuc {

    private long sSonucId;

    private Integer dSayisi;

    private Integer ySayisi;

    private Integer bosSayisi;

    private Integer sonPuan;

    private KullaniciToSinav kts;

    public long getsSonucId() {
        return sSonucId;
    }

    public void setsSonucId(long sSonucId) {
        this.sSonucId = sSonucId;
    }

    public Integer getdSayisi() {
        return dSayisi;
    }

    public void setdSayisi(Integer dSayisi) {
        this.dSayisi = dSayisi;
    }

    public Integer getySayisi() {
        return ySayisi;
    }

    public void setySayisi(Integer ySayisi) {
        this.ySayisi = ySayisi;
    }

    public Integer getBosSayisi() {
        return bosSayisi;
    }

    public void setBosSayisi(Integer bosSayisi) {
        this.bosSayisi = bosSayisi;
    }

    public Integer getSonPuan() {
        return sonPuan;
    }

    public void setSonPuan(Integer sonPuan) {
        this.sonPuan = sonPuan;
    }

    public KullaniciToSinav getKts() {
        return kts;
    }

    public void setKts(KullaniciToSinav kts) {
        this.kts = kts;
    }
}
