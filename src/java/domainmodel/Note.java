/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 679918
 */
public class Note implements Serializable{
    
    private int noteId;
    private Date dateCreated;
    private String contents;
    
    public Note(){
    }
    public Note(Date dateCreated, String contents){
        this.dateCreated = dateCreated;
        this.contents = contents;
    }
    public Note(int noteId, String contents){
        this.noteId = noteId;
        this.contents = contents;
    }
    public Note(int noteId, Date dateCreated, String contents) {
        this.noteId = noteId;
        this.dateCreated = dateCreated;
        this.contents = contents;
    }
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
