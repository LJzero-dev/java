package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;


@WebServlet("/freeProcUp")
public class FreeProcUpCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FreeProcUpCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		FreeList freeList = new FreeList();
		int flidx = Integer.parseInt(request.getParameter("flidx"));
		String fl_title = request.getParameter("fl_title").trim().replace("<", "&lt");
    	String fl_content = request.getParameter("fl_content").trim().replace("<", "&lt");
    	freeList.setFl_title(fl_title);	freeList.setFl_content(fl_content);	freeList.setFl_idx(flidx);
    	
    	HttpSession session = request.getSession();
    	MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
    	
    	FreeProcSvc	freeProcSvc = new FreeProcSvc();
    	int result = freeProcSvc.freeUpdate(freeList);
    	if (result == 1) {	// ���������� ������ �Ǿ��� ���
    		response.sendRedirect("freeView" + request.getParameter("args") + "&flidx=" + flidx);
    	} else {	// ������ �ȵ��� ���
    		response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('�� ������ �����߽��ϴ�. �ٽ� �õ��� ������');");
    		out.println("history.back();");
    		out.println("</script>");
    	}
	}
}
