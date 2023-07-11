package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.OrderProcSvc;
import vo.MemberInfo;
import vo.OrderInfo;

@WebServlet("/orderEnd")
public class OrderEndCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderEndCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String oiid = request.getParameter("oiid");
		HttpSession session = request.getSession();
		MemberInfo mi = (MemberInfo)request.getAttribute("loginInfo");
		String miid = mi.getMi_id();
		
		OrderProcSvc orderProcSvc = new OrderProcSvc();
		
		OrderInfo orderInfo = orderProcSvc.getOrderInfo(miid, oiid); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
