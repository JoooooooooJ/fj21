package gubee.estudo.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallUpdateContact implements Logic {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "WEB-INF/jsp/update-contact.jsp";
	}

}
