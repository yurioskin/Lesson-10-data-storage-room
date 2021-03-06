package com.example.oskin.lesson10_datastorage_room.DatabaseManagement;

import com.example.oskin.lesson10_datastorage_room.Model.Note;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDAO {

    @Query("select * from note")
    List<Note> getNotes();

    @Query("select * from note where note_id = :NoteId")
    Note getNote(String NoteId);

    @Insert
    void addNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

}
