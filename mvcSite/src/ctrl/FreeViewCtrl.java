package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;	// 댓글 목록을 위한 ArrayList 사용을 위해 import
import svc.*;
import vo.*;


@WebServlet("/freeView")
public class FreeViewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FreeViewCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String schtype = request.getParameter("schtype"), keyword = request.getParameter("keyword");
		String args = "?cpage=" + request.getParameter("cpage");
		if (schtype != null && !schtype.equals("") && keyword != null && !keyword.equals("")) {
			args += "&schtype=" + schtype + "&keyword=" + keyword;
		}
		int flidx = Integer.parseInt(request.getParameter("flidx"));
		FreeProcSvc freeProcSvc = new FreeProcSvc();
		freeProcSvc.readUpdate(flidx);	// 사용자가 선택한 게시글의 조회수를 증가시키는 메소드 호출
		
		FreeList freeList = freeProcSvc.getFreeInfo(flidx);	// 사용자가 선택한 게시글의 내용들을 FreeList형 인스턴스로 받아옴
		if (freeList == null) {	// 게시글이 없으면
			response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('존재하지 않는 게시글입니다.');");
    		out.println("location.replace('freeList');");
    		out.println("</script>");
		} else {				// 게시글이 있으면
			request.setAttribute("args", args);
			request.setAttribute("freeList", freeList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bbs/free_view.jsp");
			dispatcher.forward(request, response);
		}
	}
}
