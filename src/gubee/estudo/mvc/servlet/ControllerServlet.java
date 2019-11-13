package gubee.estudo.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gubee.estudo.mvc.logic.Logic;

@SuppressWarnings("serial")
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramters = req.getParameter("logic");
		String className = "gubee.estudo.mvc.logic." + paramters; 
		
		try {
			Class<?> c = Class.forName(className);
			
			Logic logic = (Logic) c.newInstance();
			String page = logic.execute(req, resp);
			
			req.getRequestDispatcher(page).forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	

}
