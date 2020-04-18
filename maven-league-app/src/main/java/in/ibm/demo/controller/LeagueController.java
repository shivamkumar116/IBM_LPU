package in.ibm.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeagueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String title = request.getParameter("title");
		int year = Integer.parseInt(request.getParameter("year"));
		String session = request.getParameter("session");

		if (title.length() > 8 && (year == 2019 || year == 2020)
				&& (session.equalsIgnoreCase("winter") || (session.equalsIgnoreCase("summer")))) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Success.html");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.html");
			dispatcher.forward(request, response);
		}

	}

}
