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
		int cpage = 1, spage = 0, psize = 12, bsize = 10, rcnt = 0, pcnt = 0;
		if (request.getParameter("cpage") != null) cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String where = "", schargs = "";	// �˻����� �۾� : ��з�, �Һз�, ���ݴ�, ��ǰ��, �귣��
		String pcb = request.getParameter("pcb");	// ��з� ����
		String pcs = request.getParameter("pcs");	// ��з� ����
		String sch = request.getParameter("sch");	// �˻�����(���ݴ�p, ��ǰ��n, �귣��b)

		if (pcb != null && !pcb.equals("")) {
			 where += " and left(a.pcs_id,2) = '" + pcb + "' ";
			 schargs += "&pcb=" + pcb;
		}
		if (pcs != null && !pcs.equals("")) {
			where += " and pcs_id = '" + pcs + "' ";
			schargs += "&pcs=" + pcs;
		}
		if (sch != null && !sch.equals("")) {	// �˻����� : &sch=ntest,bB1:B2:B3,p100000~200000
			schargs += "&sch=" + sch;
			String[] arrSch = sch.split(",");
			for (int i = 0; i < arrSch.length; i++) {
				char c = arrSch[i].charAt(0);
				if (c == 'n') {			// ��ǰ�� �˻��� ���(n�˻���)
					where += " and a.pi_name like '%" + arrSch[i].substring(1) + "%' ";
				} else if (c == 'b') {	// �귣�� �˻��� ���(b�귣��1:�귣��2)	" and (a.pb_id = '��1' || a.pb_id = '��2')"
					String[] arr = arrSch[i].substring(1).split(":");
					where += " and (";
					for (int j = 0; j < arr.length; j++) {
						where += (j == 0 ? "" : " or ") + "a.pb_id = '" + arr[j] + "' ";
					} 
					where += ") ";					
				} else if (c == 'p') {	// ���ݴ� �˻��� ���(p���۰�~���ᰡ)
					String sp = arrSch[i].substring(1, arrSch[i].indexOf('~'));
					if (sp != null && !sp.equals(""))	where += " and a.pi_price >= " + sp;
					String ep = arrSch[i].substring(arrSch[i].indexOf('~') + 1);
					if (ep != null && !ep.equals(""))	where += " and a.pi_price <= " + ep;
				}
			}
		}
		String orderBy = " order by ";	// ��� ���� ����
		String ob = request.getParameter("ob");		// ���� ����
		if (ob == null || ob.equals("")) ob = "a"; 	// ob�� ���ų� ������ ���
		String obargs = "&ob=" + ob;	// ���� ������ ���� ������Ʈ��
		switch (ob) {
		case "a" : 		// ��� ����(�⺻��)
			orderBy += " a.pi_date desc ";	break;
		case "b" : 		// �Ǹŷ�(�α�)��
			orderBy += " a.pi_sale desc ";	break;
		case "c" : 		// ���� ���ݼ�
			orderBy += " a.pi_price asc ";	break;
		case "d" : 		// ���� ���ݼ�
			orderBy += " a.pi_price desc ";	break;
		case "e" : 		// ���� ������
			orderBy += " a.pi_score asc ";	break;
		case "f" : 		// ���� ���� ��
			orderBy += " a.pi_review asc ";	break;
		case "g" : 		// ��ȸ�� ���� ��
			orderBy += " a.pi_read desc ";	break;
		}		
		String v = request.getParameter("v");	// ���� ���
		if (v == null || v.equals(""))	v = "l";	//	�����(l)�� ������(g)�� ��� ������ ũ��� 12�� ������
		String vargs = "&v=" + v;	// ���� ����� ���� ���� ��Ʈ��
		
		ProductProcSvc productProcSvc = new ProductProcSvc();
		rcnt = productProcSvc.getProductCount(where);	// �˻��� ��ǰ�� �� ������ ��ü ���������� ���� �� ����
		ArrayList<ProductInfo> productList = productProcSvc.getProductList(cpage, psize, where, orderBy);	// �˻��� ��ǰ�� �� ���� ���������� ������ ��ǰ ����� �޾ƿ�
		
		ArrayList<ProductCtgrSmall> smallList = new ArrayList<ProductCtgrSmall>();
		if (pcb != null && !pcb.equals("")) 	// �˻����� �� ��з��� ������
			smallList = productProcSvc.getCtgrSmallList(pcb);	// �˻������� ��з��� ���ϴ� �Һз� ����� �޾ƿ�
		ArrayList<ProductBrand> brandList = new ArrayList<ProductBrand>();
		brandList = productProcSvc.getBrandList();
		
		PageInfo pageInfo = new PageInfo();
		pcnt = rcnt / psize;
		if (rcnt % psize > 0) pcnt++;
		spage = (cpage - 1) / bsize * bsize -1;
		pageInfo.setBsize(bsize);	pageInfo.setCpage(cpage);	pageInfo.setPsize(psize);	pageInfo.setPcnt(pcnt);	pageInfo.setRcnt(rcnt);	pageInfo.setSpage(spage);		pageInfo.setObargs(obargs);	
		pageInfo.setPcb(pcb);		pageInfo.setPcs(pcs);		pageInfo.setSch(sch);		pageInfo.setOb(ob); 	pageInfo.setV(v);		pageInfo.setSchargs(schargs);	pageInfo.setVargs(vargs);
		// ����¡�� ��ũ�� ���õ� �������� PageInfo�� �ν��Ͻ��� ����	
		
		request.setAttribute("pageInfo", pageInfo);	request.setAttribute("productList", productList);	request.setAttribute("smallList", smallList);	request.setAttribute("brandList", brandList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/product_list.jsp");	// �� ��� ���� ���̹Ƿ� ���� Service�� Dao Ŭ���� ���� �ٷ� View�� �ش��ϴ� jsp ���Ϸ� �̵�
		dispatcher.forward(request, response);
	}
}





















