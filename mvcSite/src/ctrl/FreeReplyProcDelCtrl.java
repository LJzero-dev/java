package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;

@WebServlet("/freeReplyProcDel")
public class FreeReplyProcDelCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FreeReplyProcDelCtrl() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (loginInfo == null) {
			out.println("<script>");
			out.println("alert('로그인 후 사용하실 수 있습니다.')");
			out.println("</script>");
			out.close();
		}
		FreeReplyProcSvc freeReplyProcSvc = new FreeReplyProcSvc();
		int result = freeReplyProcSvc.replyDel(Integer.parseInt(request.getParameter("fridx")));
		out.println(result);
	}
}