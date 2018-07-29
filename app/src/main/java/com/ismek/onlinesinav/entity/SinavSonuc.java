package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SinavSonuc implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.sSonucId);
        dest.writeValue(this.dSayisi);
        dest.writeValue(this.ySayisi);
        dest.writeValue(this.bosSayisi);
        dest.writeValue(this.sonPuan);
        dest.writeParcelable(this.kts, flags);
    }

    public SinavSonuc() {
    }

    protected SinavSonuc(Parcel in) {
        this.sSonucId = in.readLong();
        this.dSayisi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.ySayisi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.bosSayisi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sonPuan = (Integer) in.readValue(Integer.class.getClassLoader());
        this.kts = in.readParcelable(KullaniciToSinav.class.getClassLoader());
    }

    public static final Parcelable.Creator<SinavSonuc> CREATOR = new Parcelable.Creator<SinavSonuc>() {
        @Override
        public SinavSonuc createFromParcel(Parcel source) {
            return new SinavSonuc(source);
        }

        @Override
        public SinavSonuc[] newArray(int size) {
            return new SinavSonuc[size];
        }
    };
}
