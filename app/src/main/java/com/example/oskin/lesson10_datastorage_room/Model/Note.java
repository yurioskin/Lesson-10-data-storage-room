package com.example.oskin.lesson10_datastorage_room.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "note_id")
    private String mId;

    @ColumnInfo(name = "note_title")
    private String mName;

    @ColumnInfo(name = "note_content")
    private String mText;

    private int mTime;

    public Note(){
    }

    public Note(String name, String text) {
        mId = UUID.randomUUID().toString();
        mName = name;
        mText = text;
        //TODO uncomment this and add time in signature
        //mTime = time;
    }


    public void setId(String id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getText() {
        return mText;
    }

    public void setTime(int time) {
        mTime = time;
    }

    public int getTime() {
        return mTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return mTime == note.mTime &&
                Objects.equals(mId, note.mId) &&
                Objects.equals(mName, note.mName) &&
                Objects.equals(mText, note.mText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mText, mTime);
    }

    protected Note(Parcel in) {
        mId = in.readString();
        mName = in.readString();
        mText = in.readString();
        mTime = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mText);
        dest.writeInt(mTime);
    }

    @SuppressWarnings("unused")
    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}