package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.FreeList;
import vo.MemberInfo;

@WebServlet("/freeProcDel")
public class FreeProcDelCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FreeProcDelCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		int flidx = Integer.parseInt(request.getParameter("flidx"));
		String ismem = request.getParameter("ismem"), where = " and fl_idx = " + flidx;
		if (ismem == null) {	// �����Ϸ��� ���� ȸ�����̸�
			where += " and fl_writer = '" + loginInfo.getMi_id() + "'";
		} else {				// �����Ϸ��� ���� ��ȸ�� ���̸�
			where += " and fl_pw = '" + request.getParameter("fl_pw") + "'";
		}
		FreeProcSvc freeProcSvc = new FreeProcSvc();
		int result = freeProcSvc.freeDelete(where);
		
		if (result == 1) {
			response.sendRedirect("freeList");
		} else {
			response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('������ ���� �߽��ϴ�.');");
    		out.println("history.back();");
    		out.println("</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
