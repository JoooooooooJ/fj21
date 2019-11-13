package gubee.estudo.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallAddContacts implements Logic {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "WEB-INF/jsp/add-contact.jsp";
	}

}
