package com.ismek.onlinesinav.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.Set;

public class Role implements Parcelable {

    private long roleId;

    private String roles;

    private List<Kullanici> kullanicilar;

    public List<Kullanici> getKullanicilar() {
        return kullanicilar;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setKullanicilar(List<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.roleId);
        dest.writeString(this.roles);
        dest.writeTypedList(this.kullanicilar);
    }

    public Role() {
    }

    protected Role(Parcel in) {
        this.roleId = in.readLong();
        this.roles = in.readString();
        this.kullanicilar = in.createTypedArrayList(Kullanici.CREATOR);
    }

    public static final Parcelable.Creator<Role> CREATOR = new Parcelable.Creator<Role>() {
        @Override
        public Role createFromParcel(Parcel source) {
            return new Role(source);
        }

        @Override
        public Role[] newArray(int size) {
            return new Role[size];
        }
    };
}