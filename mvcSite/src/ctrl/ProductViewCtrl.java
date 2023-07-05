package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;


@WebServlet("/productView")
public class ProductViewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductViewCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String piid = request.getParameter("piid");
		
		// 1. 조회수 증가 / 2. 보여줄 상품 정보 받아오기 / 3.상품상세보기 화면으로 이동
		ProductProcSvc productProcSvc = new ProductProcSvc();
		productProcSvc.readUpdate(piid);
		ProductInfo pi = productProcSvc.getProductInfo(piid);
		if (pi == null) {	// 보여주려는 상품의 옵션이 없을 경우
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 정보가 없습니다.'); history.back();");
			out.println("</script>");
			out.close();
		}
		ArrayList<ReviewList> reviewList = productProcSvc.getReviewList(piid);
		request.setAttribute("productInfo", pi);
		request.setAttribute("reviewList", reviewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product_view.jsp");
		dispatcher.forward(request, response);
	}
}