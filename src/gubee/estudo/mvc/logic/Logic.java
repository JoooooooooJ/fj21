package gubee.estudo.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logic {
	
	String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
