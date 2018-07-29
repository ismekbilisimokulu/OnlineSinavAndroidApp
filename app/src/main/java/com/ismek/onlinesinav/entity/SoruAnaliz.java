package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SoruAnaliz implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.analizId);
        dest.writeValue(this.dogruSayisi);
        dest.writeValue(this.yanlisSayisi);
        dest.writeValue(this.bosSayisi);
        dest.writeParcelable(this.soru, flags);
    }

    public SoruAnaliz() {
    }

    protected SoruAnaliz(Parcel in) {
        this.analizId = in.readLong();
        this.dogruSayisi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.yanlisSayisi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.bosSayisi = (Integer) in.readValue(Integer.class.getClassLoader());
        this.soru = in.readParcelable(Sorular.class.getClassLoader());
    }

    public static final Parcelable.Creator<SoruAnaliz> CREATOR = new Parcelable.Creator<SoruAnaliz>() {
        @Override
        public SoruAnaliz createFromParcel(Parcel source) {
            return new SoruAnaliz(source);
        }

        @Override
        public SoruAnaliz[] newArray(int size) {
            return new SoruAnaliz[size];
        }
    };
}
