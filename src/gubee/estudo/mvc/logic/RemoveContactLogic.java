package gubee.estudo.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gubee.estudo.jdbc.dao.ContactDao;
import gubee.estudo.web.Contact;

public class RemoveContactLogic implements Logic{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Contact c = new Contact();		
		c.setId(Long.parseLong(req.getParameter("id")));		
		ContactDao cdao = new ContactDao();		
		cdao.remove(c);	
		
		return "mvc?logic=ListContactLogic";
	}
	
	

}
