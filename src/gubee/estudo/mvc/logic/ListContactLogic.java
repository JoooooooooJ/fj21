package gubee.estudo.mvc.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gubee.estudo.jdbc.dao.ContactDao;
import gubee.estudo.web.Contact;

public class ListContactLogic implements Logic {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ThreadLocal<HttpServletRequest> connection = (ThreadLocal<HttpServletRequest>) req;
		
        List<Contact> contacts = new ContactDao(connection).getList();

        req.setAttribute("contacts", contacts);

        return "WEB-INF/views/list-contact.jsp";
	}

}
