package com.ismek.onlinesinav.entity;

public class Mulakat {

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
}