package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;

@WebServlet("/freeReplyProcIn")
public class FreeReplyProcInCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FreeReplyProcInCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int flidx = Integer.parseInt(request.getParameter("flidx"));
		FreeReply freeReply = new FreeReply();
		String fr_content = request.getParameter("fr_content").trim().replace("<", "&lt;");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		String mi_id = loginInfo.getMi_id(), fr_ip = request.getRemoteAddr();
		
		freeReply.setFl_idx(flidx);	freeReply.setFr_content((fr_content));	freeReply.setFr_ip(fr_ip);	freeReply.setMi_id(mi_id);
		FreeReplyProcSvc freeReplyProcSvc = new FreeReplyProcSvc();
		int result = freeReplyProcSvc.replyInsert(freeReply);
		
		response.setContentType("text/html charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}
}
