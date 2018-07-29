package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Brans implements Parcelable{

    private long bransId;

    private String bransAdi;

    private Integer kontenjan;

    private Set<Sorular> sorulars;

    private List<Sinav> sinav = new ArrayList<Sinav>();

    public Brans() {}

    protected Brans(Parcel in) {
        bransId = in.readLong();
        bransAdi = in.readString();
        if (in.readByte() == 0) {
            kontenjan = null;
        } else {
            kontenjan = in.readInt();
        }
        sinav = in.createTypedArrayList(Sinav.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(bransId);
        dest.writeString(bransAdi);
        if (kontenjan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(kontenjan);
        }
        dest.writeTypedList(sinav);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Brans> CREATOR = new Creator<Brans>() {
        @Override
        public Brans createFromParcel(Parcel in) {
            return new Brans(in);
        }

        @Override
        public Brans[] newArray(int size) {
            return new Brans[size];
        }
    };

    public long getBransId() {
        return bransId;
    }

    public void setBransId(long bransId) {
        this.bransId = bransId;
    }

    public String getBransAdi() {
        return bransAdi;
    }

    public void setBransAdi(String bransAdi) {
        this.bransAdi = bransAdi;
    }

    public Integer getKontenjan() {
        return kontenjan;
    }

    public void setKontenjan(Integer kontenjan) {
        this.kontenjan = kontenjan;
    }


    public Set<Sorular> getSorulars() {
        return sorulars;
    }

    public void setSorulars(Set<Sorular> sorulars) {
        this.sorulars = sorulars;
    }

    public List<Sinav> getSinav() {
        return sinav;
    }

    public void setSinav(List<Sinav> sinav) {
        this.sinav = sinav;
    }
}