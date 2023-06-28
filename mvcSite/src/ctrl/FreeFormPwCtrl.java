package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;

@WebServlet("/freeFormPw")
public class FreeFormPwCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FreeFormPwCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String schtype = request.getParameter("schtype"), keyword = request.getParameter("keyword");
		String args = "?cpage=" + request.getParameter("cpage");
		if (schtype != null && !schtype.equals("") && keyword != null && !keyword.equals("")) {
			args += "&schtype=" + schtype + "&keyword=" + keyword;
		}
		int flidx = Integer.parseInt(request.getParameter("flidx"));
		FreeProcSvc freeProcSvc = new FreeProcSvc();
		String ismem = freeProcSvc.getIsMem(flidx);
	}
}
