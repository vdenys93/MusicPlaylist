package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
		else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = dao.searchForListDetailsById(tempId);
				dao.deleteList(listToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("No button clicked");
			}
			finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request,response);
			}
		}
		else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = dao.searchForListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("month", listToEdit.getDateCreated().getMonth());
				request.setAttribute("day", listToEdit.getDateCreated().getDayOfMonth());
				request.setAttribute("year", listToEdit.getDateCreated().getYear());
				
				request.setAttribute("playlistName", listToEdit.getListName());
				
				SongHelper daoForItems = new SongHelper();
				
				request.setAttribute("allSongs", daoForItems.showAllSongs());
				
				if(daoForItems.showAllSongs().isEmpty()) {
					request.setAttribute("allSongs", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			}
			catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
		else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.html").forward(request, response);
		}
	}

}
