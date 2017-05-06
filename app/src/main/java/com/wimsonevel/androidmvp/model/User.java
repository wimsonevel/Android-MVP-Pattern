package com.wimsonevel.androidmvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wim on 12/31/16.
 */

public class User implements Parcelable {

    private String email;

    public User(String email) {
        this.email = email;
    }

    protected User(Parcel in) {
        this.email = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
    }

}
