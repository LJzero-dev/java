package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

@WebServlet("/cartView")
public class CartViewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CartViewCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		if (loginInfo == null) {
			response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('다시 로그인 하세요.');");
    		out.println("location.href'login_form?url=cartView';");
    		out.println("</script>");
    		out.close();
		}		
		CartProcSvc cartProcSvc = new CartProcSvc();
		ArrayList<OrderCart> cartList = cartProcSvc.getCartList(loginInfo.getMi_id());
		
		request.setAttribute("cartList", cartList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order/cart_view.jsp");
		dispatcher.forward(request, response);
	}
}