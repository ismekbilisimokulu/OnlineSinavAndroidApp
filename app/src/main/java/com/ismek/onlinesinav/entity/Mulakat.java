package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Mulakat implements Parcelable {

    private int mulakatId;

    private String mSorulari;

   /* @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private MulakatCevaplari mulakatcevaplari;
    */

    public int getMulakatId() {
        return mulakatId;
    }

    public void setMulakatId(int mulakatId) {
        this.mulakatId = mulakatId;
    }

    public String getmSorulari() {
        return mSorulari;
    }

    public void setmSorulari(String mSorulari) {
        this.mSorulari = mSorulari;
    }
/*
	public MulakatCevaplari getMulakatcevaplari() {
		return mulakatcevaplari;
	}
	public void setMulakatcevaplari(MulakatCevaplari mulakatcevaplari) {
		this.mulakatcevaplari = mulakatcevaplari;
	}
*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mulakatId);
        dest.writeString(this.mSorulari);
    }

    public Mulakat() {
    }

    protected Mulakat(Parcel in) {
        this.mulakatId = in.readInt();
        this.mSorulari = in.readString();
    }

    public static final Parcelable.Creator<Mulakat> CREATOR = new Parcelable.Creator<Mulakat>() {
        @Override
        public Mulakat createFromParcel(Parcel source) {
            return new Mulakat(source);
        }

        @Override
        public Mulakat[] newArray(int size) {
            return new Mulakat[size];
        }
    };
}