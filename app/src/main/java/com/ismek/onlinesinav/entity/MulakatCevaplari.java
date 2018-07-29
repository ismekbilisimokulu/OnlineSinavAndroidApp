package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class MulakatCevaplari implements Parcelable {

    private long mCevapId;

    private String cevap;

    private KullaniciToSinav ktsId;

    private Mulakat mulakat;



    public long getmCevapId() {
        return mCevapId;
    }

    public void setmCevapId(long mCevapId) {
        this.mCevapId = mCevapId;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }


    public KullaniciToSinav getKtsId() {
        return ktsId;
    }

    public void setKtsId(KullaniciToSinav ktsId) {
        this.ktsId = ktsId;
    }

    public Mulakat getMulakat() {
        return mulakat;
    }

    public void setMulakat(Mulakat mulakat) {
        this.mulakat = mulakat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mCevapId);
        dest.writeString(this.cevap);
        dest.writeParcelable(this.ktsId, flags);
        dest.writeParcelable(this.mulakat, flags);
    }

    public MulakatCevaplari() {
    }

    protected MulakatCevaplari(Parcel in) {
        this.mCevapId = in.readLong();
        this.cevap = in.readString();
        this.ktsId = in.readParcelable(KullaniciToSinav.class.getClassLoader());
        this.mulakat = in.readParcelable(Mulakat.class.getClassLoader());
    }

    public static final Parcelable.Creator<MulakatCevaplari> CREATOR = new Parcelable.Creator<MulakatCevaplari>() {
        @Override
        public MulakatCevaplari createFromParcel(Parcel source) {
            return new MulakatCevaplari(source);
        }

        @Override
        public MulakatCevaplari[] newArray(int size) {
            return new MulakatCevaplari[size];
        }
    };
}
