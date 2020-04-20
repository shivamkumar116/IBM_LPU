package in.ibm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ibm.factory.MyFactory;
import in.ibm.model.ToDo;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<String> errors;

	private MyFactory factory;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		errors = new ArrayList<String>();
		String name = request.getParameter("name").toString();
		int id = 0;
		if (name.length() < 8) {
			errors.add("invalid name.");
		}
		try {

			id = Integer.parseInt(request.getParameter("id").toString());
		} catch (Exception e) {
			errors.add("todo id must be numeric");
		}

		String c_by = request.getParameter("c_by").toString();
		if (c_by.length() <= 0) {
			errors.add("completeed by field cant not be blank");
		}

		if (errors.isEmpty()) {
			ToDo todo = new ToDo(id, name, c_by);
			request.setAttribute("todo", todo);// key and value pair
			RequestDispatcher view = request.getRequestDispatcher("success.jsp");
			factory = MyFactory.getMyFactory();
			Connection con = factory.getMyConnection();
			PreparedStatement st = con.prepareStatement("Insert into todo values(?,?,?)");
			st.setInt(1, todo.getId());
			st.setString(2, todo.getName());
			st.setString(3, todo.getCompletedBy());
			int i = st.executeUpdate();
			if (i > 0)
				view.forward(request, response);

		} else {

			request.setAttribute("error", errors);// key and value pair
			RequestDispatcher view = request.getRequestDispatcher("error.jsp");
			view.forward(request, response);
		}
	}

}
