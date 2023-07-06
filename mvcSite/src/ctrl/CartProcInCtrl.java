package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import svc.*;
import vo.*;



@WebServlet("/cartProcIn")
public class CartProcInCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CartProcInCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String piid = request.getParameter("piid");
		int psidx = Integer.parseInt(request.getParameter("psidx").substring(0,request.getParameter("psidx").indexOf(":")));	// psidx는 옵션 번호와 재고량을 같이 가지고 있으므로 옵션 번호 부분만 추출하여 사용
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		if (loginInfo == null) {
    		out.println("<script>");
    		out.println("alert('다시 로그인하세요.');");
    		out.println("location.href='login_form?url=/mvcSite/productView?piid=" + piid + "';");
    		out.println("</script>");
    		out.close();
		}
		String miid = loginInfo.getMi_id();
		OrderCart oc = new OrderCart();
		oc.setMi_id(miid);	oc.setPs_idx(psidx);	oc.setPi_id(piid);	oc.setOc_cnt(cnt);	// 장바구니 테이블에 저장할 정보들을 담은 OrderCart형 인스턴스 생성
		
		CartProcSvc cartProcSvc = new CartProcSvc();
		int result = cartProcSvc.cartInsert(oc);
		
		out.println(result);
	}
}