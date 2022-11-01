package com.example.recyclerview1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Drink implements Parcelable {
    public String name;
    public String price;
    public int logo;

    public Drink(String name, String price, int logo) {
        this.name = name;
        this.price = price;
        this.logo = logo;
    }

    protected Drink(Parcel in) {
        name = in.readString();
        price = in.readString();
        logo = in.readInt();
    }

    public static final Creator<Drink> CREATOR = new Creator<Drink>() {
        @Override
        public Drink createFromParcel(Parcel in) {
            return new Drink(in);
        }

        @Override
        public Drink[] newArray(int size) {
            return new Drink[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(price);
        parcel.writeInt(logo);
    }
}
