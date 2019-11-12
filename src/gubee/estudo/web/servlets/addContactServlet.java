package gubee.estudo.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gubee.estudo.jdbc.dao.ContatosDao;
import gubee.estudo.web.Contato;

@WebServlet("/AddContact")
public class addContactServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6875294096039595127L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		Contato c = new Contato();
		
		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("email"));
		c.setAddress(req.getParameter("address"));
		Calendar birthday; 		
        Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("birthday"));
				birthday = Calendar.getInstance();
	            birthday.setTime(date);
			} catch (ParseException e) {
				
				out.println("erro ao converter data");
				return;
			}
		c.setBirthday(Calendar.getInstance());
		
		
		ContatosDao cdao = new ContatosDao();		
		cdao.add(c);

		
		out.println("<html>\r\n	"
				+ "<body>\r\n" + 
				"		<h1> Contato de "+c.getName()+" salvo com sucesso </h1>\r\n" + 
				"	</body>\r\n" + 
				" </html>");      
	}


}
