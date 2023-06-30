package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;


@WebServlet("/productList")
public class ProductListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductListCtrl() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 10, bsize = 10, rcnt = 0, pcnt = 0;
		if (request.getParameter("cpage") != null) cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String where = "";	// 검색조건 작업 : 대분류, 소분류, 가격대, 상품명, 브랜드
		String pcb = request.getParameter("pcb");	// 대분류 조건
		String pcs = request.getParameter("pcs");	// 대분류 조건
		String sch = request.getParameter("sch");	// 검색조건(가격대p, 상품명n, 브랜드b)

		if (pcb != null && !pcb.equals("")) where += " and left(a.pcs_id,2) = '" + pcb + "' ";
		if (pcs != null && !pcs.equals("")) where += " and pcs_id = '" + pcs + "' ";
		if (sch != null && !sch.equals("")) {	// 검색조건 : &sch=ntest,bB1:B2:B3,p100000~200000
			String[] arrSch = sch.split(",");
			for (int i = 0; i < arrSch.length; i++) {
				char c = arrSch[i].charAt(0);
				if (c == 'n') {			// 상품명 검색일 경우(n검색어)
					where += " and a.pi_name like '%" + arrSch[i].substring(1) + "%' ";
				} else if (c == 'b') {	// 브랜드 검색일 경우(b브랜드1:브랜드2)	" and (a.pb_id = '브1' || a.pb_id = '브2')"
					String[] arr = arrSch[i].split(":");
					where += " and (";
					for (int j = 0; j < arr.length; j++) {
						where += (j == 0 ? "" : " or ") + "a.pb_id = '" + arr[j] + "' ";
					} 
					where += ") ";					
				} else if (c == 'p') {	// 가격대 검색일 경우(p시작가~종료가)
					String sp = arrSch[i].substring(1, arrSch[i].indexOf('~'));
					if (sp != null && !sp.equals(""))	where += " and a.pi_pricd >= " + sp;
					String ep = arrSch[i].substring(arrSch[i].indexOf('~') + 1);
						where += " and a.pi_pricd <= " + ep;
				}
			}
		}
	}
}