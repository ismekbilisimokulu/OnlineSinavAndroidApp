package com.ismek.onlinesinav.entity;

import java.util.Set;

public class Role {
    private int roleId;

    private String roles;

    private Set<Kullanici> kullanicilar;

    public Set<Kullanici> getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(Set<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}