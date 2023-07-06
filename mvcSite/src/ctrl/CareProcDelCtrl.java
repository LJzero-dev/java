package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

@WebServlet("/careProcDel")
public class CareProcDelCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CareProcDelCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (loginInfo == null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� �ϼ���.');");
			out.println("location.href='login_form?url=cartView';");
			out.println("</script>");
			out.close();
		}
		String where = " where mi_id = '" + loginInfo.getMi_id() + "' ", ocidx = request.getParameter("ocidx");	// ������ ��ǰ�� ��ٱ��� �ε�����ȣ(��)
		String tmp = "";
		if (ocidx.indexOf(',') >= 0) {	// ���� ���� ��ǰ�� ������ ���	// and (oc_idx = ? or ... or oc_idx = ?)
		for (String idx : ocidx.split(",")) {
			tmp += " or oc_idx = " + idx;
		}
		where += " and (" + tmp.substring(3) + ") ";
		} else where += " and oc_idx = " + ocidx;		// �ϳ��� ��ǰ�� ������ ���
		
		CartProcSvc cartProcSvc = new CartProcSvc();
		out.println(cartProcSvc.cartDelete(where));
	}
}