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
		String kind = request.getParameter("kind");
		FreeProcSvc freeProcSvc = new FreeProcSvc();
		String ismem = freeProcSvc.getIsMem(flidx);
		
		if (ismem != null && ismem.equals("n")) {	// 해당 게시글이 비회원 글일 경우
			request.setAttribute("args", args);
			request.setAttribute("kind", kind);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bbs/free_form_pw.jsp");
			dispatcher.forward(request, response);
		} else {	// 회원글이거나 결과가 없을 경우
			response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('올바르지 않은 접근 입니다.');");
    		out.println("history.back();");
    		out.println("</script>");
		}
	}
}