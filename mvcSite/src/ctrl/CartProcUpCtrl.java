package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;

@WebServlet("/cartProcUp")
public class CartProcUpCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CartProcUpCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (loginInfo == null) {
    		out.println("<script>");
    		out.println("alert('글 수정에 실패했습니다. 다시 시도해 보세요');");
    		out.println("location.href='login_form?url=/mvcSite/cartView';");
    		out.println("</script>");
    		out.close();
		}
		CartProcSvc CartProcSvc = new CartProcSvc();
		out.println(CartProcSvc.cartUpdate(Integer.parseInt(request.getParameter("ocidx")),Integer.parseInt(request.getParameter("opt")),Integer.parseInt(request.getParameter("cnt")),loginInfo.getMi_id()));
	}
}