package com.ismek.onlinesinav.entity;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Sinav implements Parcelable{

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

    protected Sinav(Parcel in) {
        sinavId = in.readInt();
        sinavAdi = in.readString();
        sinavSuresi = in.readInt();
        soruSayisi = in.readInt();
        sinavSalonu = in.readString();
        katkiYuzdesi = in.readFloat();
        isAktif = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sinavId);
        dest.writeString(sinavAdi);
        dest.writeInt(sinavSuresi);
        dest.writeInt(soruSayisi);
        dest.writeString(sinavSalonu);
        dest.writeFloat(katkiYuzdesi);
        dest.writeByte((byte) (isAktif ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Sinav> CREATOR = new Creator<Sinav>() {
        @Override
        public Sinav createFromParcel(Parcel in) {
            return new Sinav(in);
        }

        @Override
        public Sinav[] newArray(int size) {
            return new Sinav[size];
        }
    };

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