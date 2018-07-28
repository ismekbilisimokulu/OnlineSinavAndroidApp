package com.ismek.onlinesinav.entity;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class Sinav implements Parcelable{

    private long sinavId;

    private String sinavKodu;

    private Date sinavTarihi;

    private Integer sinavSuresi;

    private Integer soruSayisi;

    private Date bsSaati;

    private String sinavSalonu;

    private float katkiYuzdesi;

    private Date olusturmaTarihi;

    private boolean isAktif;

    private Kullanici ogretmenId;

    private Brans bransId;

    private List<Sorular> sorulars;

    private List<KullaniciToSinav> kullanicitosinav;


    public  Sinav(Parcel in) {
        sinavId = in.readLong();
        sinavKodu = in.readString();
        if (in.readByte() == 0) {
            sinavSuresi = null;
        } else {
            sinavSuresi = in.readInt();
        }
        if (in.readByte() == 0) {
            soruSayisi = null;
        } else {
            soruSayisi = in.readInt();
        }
        sinavSalonu = in.readString();
        katkiYuzdesi = in.readFloat();
        isAktif = in.readByte() != 0;
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

    public Sinav() {

    }

    public long getSinavId() {
        return sinavId;
    }

    public void setSinavId(long sinavId) {
        this.sinavId = sinavId;
    }

    public String getSinavKodu() {
        return sinavKodu;
    }

    public void setSinavKodu(String sinavKodu) {
        this.sinavKodu = sinavKodu;
    }

    public Date getSinavTarihi() {
        return sinavTarihi;
    }

    public void setSinavTarihi(Date sinavTarihi) {
        this.sinavTarihi = sinavTarihi;
    }

    public Integer getSinavSuresi() {
        return sinavSuresi;
    }

    public void setSinavSuresi(Integer sinavSuresi) {
        this.sinavSuresi = sinavSuresi;
    }

    public Integer getSoruSayisi() {
        return soruSayisi;
    }

    public void setSoruSayisi(Integer soruSayisi) {
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

    public boolean isAktif() {
        return isAktif;
    }

    public void setAktif(boolean aktif) {
        isAktif = aktif;
    }

    public Kullanici getOgretmenId() {
        return ogretmenId;
    }

    public void setOgretmenId(Kullanici ogretmenId) {
        this.ogretmenId = ogretmenId;
    }

    public Brans getBransId() {
        return bransId;
    }

    public void setBransId(Brans bransId) {
        this.bransId = bransId;
    }

    public List<Sorular> getSorulars() {
        return sorulars;
    }

    public void setSorulars(List<Sorular> sorulars) {
        this.sorulars = sorulars;
    }

    public List<KullaniciToSinav> getKullanicitosinav() {
        return kullanicitosinav;
    }

    public void setKullanicitosinav(List<KullaniciToSinav> kullanicitosinav) {
        this.kullanicitosinav = kullanicitosinav;
    }

    public static Creator<Sinav> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(sinavId);
        parcel.writeString(sinavKodu);
        if (sinavSuresi == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(sinavSuresi);
        }
        if (soruSayisi == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(soruSayisi);
        }
        parcel.writeString(sinavSalonu);
        parcel.writeFloat(katkiYuzdesi);
        parcel.writeByte((byte) (isAktif ? 1 : 0));
    }
}