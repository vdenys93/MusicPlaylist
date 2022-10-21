package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Playlist;
import model.Song;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListDetailsHelper dao = new ListDetailsHelper();
		SongHelper sh = new SongHelper();
		PlaylistHelper ph = new PlaylistHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String playlistName = request.getParameter("playlistName");
		
		// Find new playlist
		Playlist newPlaylist = ph.findPlaylist(playlistName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			
			// Songs we want to add are selected
			String[] selected = request.getParameterValues("allSongsToAdd");
			List<Song> selectedSongsInList = new ArrayList<Song>();
			
			for(int i = 0; i < selected.length ; ++i ) {
				System.out.println(selected[i]);
				Song c = sh.searchForSongById(Integer.parseInt(selected[i]));
				selectedSongsInList.add(c);
			}
			listToUpdate.setListOfSongs(selectedSongsInList);
		}
		catch(NullPointerException n) {
			
			// Set to empty list if nothing was selected
			List<Song> selectedItemsInList = new ArrayList<Song>();
			listToUpdate.setListOfSongs(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setDateCreated(ld);
		listToUpdate.setPlaylist(newPlaylist);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
