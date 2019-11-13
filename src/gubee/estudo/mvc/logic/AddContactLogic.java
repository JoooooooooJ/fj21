package gubee.estudo.mvc.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gubee.estudo.jdbc.dao.ContactDao;
import gubee.estudo.web.Contact;

public class AddContactLogic implements Logic{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Contact c = new Contact();
		
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
				throw new IllegalArgumentException(e);
			}
		c.setBirthday(birthday);
		
		
		ContactDao cdao = new ContactDao();		
		cdao.add(c);		
		return "WEB-INF/jsp/added-contact.jsp";


	}

}
