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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SongHelper sh = new SongHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String playlistName = request.getParameter("playlistName");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		String[] selected = request.getParameterValues("allSongsToAdd");
		List<Song> selectedSongsInList = new ArrayList<Song>();
		
		// Make sure something was selected
		if(selected != null && selected.length > 0) {
			for(int i = 0; i < selected.length ; ++i ) {
				System.out.println(selected[i]);
				Song c = sh.searchForSongById(Integer.parseInt(selected[i]));
				selectedSongsInList.add(c);
			}
		}
		
		Playlist p = new Playlist(playlistName);
		ListDetails mpd = new ListDetails(listName, ld, p);
		mpd.setListOfSongs(selectedSongsInList);
		ListDetailsHelper mpdh = new ListDetailsHelper();
		mpdh.insertNewListDetails(mpd);
		
		System.out.println(mpd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
