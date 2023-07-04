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
		
		// 1. ��ȸ�� ���� / 2. ������ ��ǰ ���� �޾ƿ��� / 3.��ǰ�󼼺��� ȭ������ �̵�
		ProductProcSvc productProcSvc = new ProductProcSvc();
		productProcSvc.readUpdate(piid);
		ProductInfo pi = productProcSvc.getProductInfo(piid);
		
		request.setAttribute("pi", pi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product_view.jsp");
		dispatcher.forward(request, response);
	}
}