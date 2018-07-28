package com.ismek.onlinesinav.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Brans{

    private long bransId;

    private String bransAdi;

    private Integer kontenjan;

    private Set<Sorular> sorulars;

    private List<Sinav> sinav = new ArrayList<Sinav>();

    public Brans() {}

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