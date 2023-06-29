package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
import java.net.*;
import svc.*;
import vo.*;

@WebServlet("/freeFromUp")
public class FreeFromUpCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FreeFromUpCtrl() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		int flidx = Integer.parseInt(request.getParameter("flidx"));
		String args = "", ismem = request.getParameter("ismem"), where = " and fl_idx = " + flidx; // ȸ�� ��ȸ�� ��������
		if (ismem == null) {
			where += " and fl_writer = '" + loginInfo.getMi_id() + "'";
			
			String schtype = request.getParameter("schtype"), keyword = request.getParameter("keyword");
			args = "?cpage=" + request.getParameter("cpage");
			if (schtype != null && !schtype.equals("") && keyword != null && !keyword.equals("")) {
				args += "&schtype=" + schtype + "&keyword=" + keyword;
			}

		} else {
			args = request.getParameter("args");
			where += " and fl_pw = '" + request.getParameter("fl_pw") + "'";
		}
		FreeProcSvc freeProcSvc = new FreeProcSvc();
		FreeList freeInfo = freeProcSvc.getFreeListInfoUp(where);	// �����Ϸ��� �Խñ��� �������� FreeList�� �ν��Ͻ��� �޾ƿ�
		
		if (freeInfo != null) {	// �����Ϸ��� �Խñ��� ������	
			request.setAttribute("args", args);
			request.setAttribute("freeInfo", freeInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bbs/free_form_up.jsp");
			dispatcher.forward(request, response);
		} else {	// �����Ϸ��� �Խñ��� ������
			response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		if (ismem == null) 	out.println("alert('�ùٸ��� ���� ���� �Դϴ�.');");
    		else 	    		out.println("alert('��й�ȣ�� Ʋ�Ƚ��ϴ�.');");    		
    		out.println("history.back();");
    		out.println("</script>");
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
