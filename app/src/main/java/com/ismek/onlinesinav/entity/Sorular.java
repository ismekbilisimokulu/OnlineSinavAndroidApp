package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class Sorular implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.soruId);
        dest.writeString(this.soru);
        dest.writeString(this.secenekler);
        dest.writeString(this.secenekSayisi);
        dest.writeString(this.cevap);
        dest.writeLong(this.eklemeTarihi != null ? this.eklemeTarihi.getTime() : -1);
        dest.writeValue(this.soruPuan);
        dest.writeValue(this.isOnay);
        dest.writeValue(this.isAktif);
        dest.writeString(this.zorlukSeviyesi);
        dest.writeParcelable(this.kullanici, flags);
        dest.writeTypedList(this.brans);
        dest.writeParcelable(this.soruanaliz, flags);
    }

    protected Sorular(Parcel in) {
        this.soruId = in.readLong();
        this.soru = in.readString();
        this.secenekler = in.readString();
        this.secenekSayisi = in.readString();
        this.cevap = in.readString();
        long tmpEklemeTarihi = in.readLong();
        this.eklemeTarihi = tmpEklemeTarihi == -1 ? null : new Date(tmpEklemeTarihi);
        this.soruPuan = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isOnay = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isAktif = (Integer) in.readValue(Integer.class.getClassLoader());
        this.zorlukSeviyesi = in.readString();
        this.kullanici = in.readParcelable(Kullanici.class.getClassLoader());
        this.brans = in.createTypedArrayList(Brans.CREATOR);
        this.soruanaliz = in.readParcelable(SoruAnaliz.class.getClassLoader());
    }

    public static final Parcelable.Creator<Sorular> CREATOR = new Parcelable.Creator<Sorular>() {
        @Override
        public Sorular createFromParcel(Parcel source) {
            return new Sorular(source);
        }

        @Override
        public Sorular[] newArray(int size) {
            return new Sorular[size];
        }
    };
}