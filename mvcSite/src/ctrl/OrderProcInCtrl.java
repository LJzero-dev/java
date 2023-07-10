package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;

@WebServlet("/orderProcIn")
public class OrderProcInCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderProcInCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		if (loginInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��� �� �̿� ��Ź�帳�ϴ�.');");
			out.println("location.href='/mvcSite/';");
			out.println("</script>");
			out.close();
		}
		String miid = loginInfo.getMi_id();
		String kind = request.getParameter("kind");
		int total = Integer.parseInt(request.getParameter("total"));
		String ocidxs = request.getParameter("ocidxs");
		
		// ����� �� ���� ���� �޾ƿ���
		String oi_name = request.getParameter("oi_name").trim();
		String oi_phone = "010-" + request.getParameter("p2") + "-" + request.getParameter("p3");
		String oi_zip = request.getParameter("oi_zip").trim();
		String oi_addr1 = request.getParameter("oi_addr1").trim();
		String oi_addr2 = request.getParameter("oi_addr2").trim();
		String oi_payment = request.getParameter("oi_payment");
		
		OrderInfo oi = new OrderInfo();
		oi.setMi_id(miid);
		oi.setOi_name(oi_name);
		oi.setOi_phone(oi_phone);
		oi.setOi_zip(oi_zip);
		oi.setOi_addr1(oi_addr1);
		oi.setOi_addr2(oi_addr2);
		oi.setOi_payment(oi_payment);
		oi.setOi_pay(total);
		oi.setOi_spoint(Math.round(total * 0.02f));	// ���� ����Ʈ
		oi.setOi_status(oi.getOi_payment().equals("c") ? "a" : "b");
		
		OrderProcSvc orderProcSvc = new OrderProcSvc();
		String result = orderProcSvc.orderInsert(kind, oi, ocidxs);	// �ֹ���ȣ,���� ����� ���ڵ� ����, ����Ǿ�� �� ���ڵ� ����
	}
}






















