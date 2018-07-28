package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class KullaniciToSinav implements Parcelable {

    private int ktsId;

    private String ogrCevap;

    private boolean isOnay;

    private boolean isDurum;

    private Integer mPuan;

    private Integer sinavPuan;

    private String ipAdresi;

    private Kullanici kullanici;

    private Sinav sinav;

    private List<MulakatCevaplari> mulakatcevaplari;

    private SinavSonuc sinavsonuc;

    protected KullaniciToSinav(Parcel in) {
        ktsId = in.readInt();
        ogrCevap = in.readString();
        isOnay = in.readByte() != 0;
        isDurum = in.readByte() != 0;
        if (in.readByte() == 0) {
            mPuan = null;
        } else {
            mPuan = in.readInt();
        }
        if (in.readByte() == 0) {
            sinavPuan = null;
        } else {
            sinavPuan = in.readInt();
        }
        ipAdresi = in.readString();
        sinav = in.readParcelable(Sinav.class.getClassLoader());
    }

    public static final Creator<KullaniciToSinav> CREATOR = new Creator<KullaniciToSinav>() {
        @Override
        public KullaniciToSinav createFromParcel(Parcel in) {
            return new KullaniciToSinav(in);
        }

        @Override
        public KullaniciToSinav[] newArray(int size) {
            return new KullaniciToSinav[size];
        }
    };

    public int getKtsId() {
        return ktsId;
    }

    public void setKtsId(int ktsId) {
        this.ktsId = ktsId;
    }

    public String getOgrCevap() {
        return ogrCevap;
    }

    public void setOgrCevap(String ogrCevap) {
        this.ogrCevap = ogrCevap;
    }

    public boolean isOnay() {
        return isOnay;
    }

    public void setOnay(boolean onay) {
        isOnay = onay;
    }

    public boolean isDurum() {
        return isDurum;
    }

    public void setDurum(boolean durum) {
        isDurum = durum;
    }

    public Integer getmPuan() {
        return mPuan;
    }

    public void setmPuan(Integer mPuan) {
        this.mPuan = mPuan;
    }

    public Integer getSinavPuan() {
        return sinavPuan;
    }

    public void setSinavPuan(Integer sinavPuan) {
        this.sinavPuan = sinavPuan;
    }

    public String getIpAdresi() {
        return ipAdresi;
    }

    public void setIpAdresi(String ipAdresi) {
        this.ipAdresi = ipAdresi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }


    public Sinav getSinav() {
        return sinav;
    }
    public void setSinav(Sinav sinav) {
        this.sinav = sinav;
    }


    public List<MulakatCevaplari> getMulakatcevaplari() {
        return mulakatcevaplari;
    }

    public void setMulakatcevaplari(List<MulakatCevaplari> mulakatcevaplari) {
        this.mulakatcevaplari = mulakatcevaplari;
    }

    public SinavSonuc getSinavsonuc() {
        return sinavsonuc;
    }

    public void setSinavsonuc(SinavSonuc sinavsonuc) {
        this.sinavsonuc = sinavsonuc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ktsId);
        parcel.writeString(ogrCevap);
        parcel.writeByte((byte) (isOnay ? 1 : 0));
        parcel.writeByte((byte) (isDurum ? 1 : 0));
        if (mPuan == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(mPuan);
        }
        if (sinavPuan == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(sinavPuan);
        }
        parcel.writeString(ipAdresi);
        parcel.writeParcelable(sinav, i);
    }
}
