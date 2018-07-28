package com.ismek.onlinesinav.entity;

public class MulakatCevaplari {

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
}
