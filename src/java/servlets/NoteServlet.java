/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.NoteService;
import domainmodel.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 679918
 */
public class NoteServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     NoteService ns = new NoteService();
        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            int selectedNoteId = Integer.parseInt(request.getParameter("selectedNoteId"));
            try {
                Note note = ns.get(selectedNoteId);
                request.setAttribute("selectedNote", note);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ArrayList<Note> notes = null;        
        try {
            notes = (ArrayList<Note>) ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }
        

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    String action = request.getParameter("action");
        String noteId = request.getParameter("noteId");
        String dateCreated = request.getParameter("dateCreated");
        String contents = request.getParameter("contents");
        int noteIdInt = -1;
        
        if (noteId != null) {
            noteIdInt = Integer.parseInt(noteId);
        }
        
        NoteService ns = new NoteService();

        try {
            if (action.equals("delete")) {
                int selectedNoteId = Integer.parseInt(request.getParameter("selectedNoteId"));
                ns.delete(selectedNoteId);
            } else if (action.equals("edit")) {
                ns.update(noteIdInt, contents);
            } else if (action.equals("add")) {
                ns.insert(contents);
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Whoops.  Could not perform that action.");
        }
        
        ArrayList<Note> notes = null;
        try {
            notes = (ArrayList<Note>) ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }
}
