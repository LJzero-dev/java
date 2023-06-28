package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;	// ��� ����� ���� ArrayList ����� ���� import
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
		freeProcSvc.readUpdate(flidx);	// ����ڰ� ������ �Խñ��� ��ȸ���� ������Ű�� �޼ҵ� ȣ��
		
		FreeList freeList = freeProcSvc.getFreeInfo(flidx);	// ����ڰ� ������ �Խñ��� ������� FreeList�� �ν��Ͻ��� �޾ƿ�
		if (freeList == null) {	// �Խñ��� ������
			response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('�������� �ʴ� �Խñ��Դϴ�.');");
    		out.println("location.replace('freeList');");
    		out.println("</script>");
		} else {				// �Խñ��� ������
			request.setAttribute("args", args);
			request.setAttribute("freeList", freeList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bbs/free_view.jsp");
			dispatcher.forward(request, response);
		}
	}
}
