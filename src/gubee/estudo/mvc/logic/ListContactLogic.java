package gubee.estudo.mvc.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gubee.estudo.jdbc.dao.ContactDao;
import gubee.estudo.web.Contact;

public class ListContactLogic implements Logic {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		

        List<Contact> contacts = new ContactDao().getList();

        req.setAttribute("contacts", contacts);

        return "WEB-INF/jsp/list-contact.jsp";
	}

}
