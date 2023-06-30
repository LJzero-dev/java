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
		
		String where = "";	// �˻����� �۾� : ��з�, �Һз�, ���ݴ�, ��ǰ��, �귣��
		String pcb = request.getParameter("pcb");	// ��з� ����
		String pcs = request.getParameter("pcs");	// ��з� ����
		String sch = request.getParameter("sch");	// �˻�����(���ݴ�p, ��ǰ��n, �귣��b)

		if (pcb != null && !pcb.equals("")) where += " and left(a.pcs_id,2) = '" + pcb + "' ";
		if (pcs != null && !pcs.equals("")) where += " and pcs_id = '" + pcs + "' ";
		if (sch != null && !sch.equals("")) {	// �˻����� : &sch=ntest,bB1:B2:B3,p100000~200000
			String[] arrSch = sch.split(",");
			for (int i = 0; i < arrSch.length; i++) {
				char c = arrSch[i].charAt(0);
				if (c == 'n') {			// ��ǰ�� �˻��� ���(n�˻���)
					where += " and a.pi_name like '%" + arrSch[i].substring(1) + "%' ";
				} else if (c == 'b') {	// �귣�� �˻��� ���(b�귣��1:�귣��2)	" and (a.pb_id = '��1' || a.pb_id = '��2')"
					String[] arr = arrSch[i].split(":");
					where += " and (";
					for (int j = 0; j < arr.length; j++) {
						where += (j == 0 ? "" : " or ") + "a.pb_id = '" + arr[j] + "' ";
					} 
					where += ") ";					
				} else if (c == 'p') {	// ���ݴ� �˻��� ���(p���۰�~���ᰡ)
					String sp = arrSch[i].substring(1, arrSch[i].indexOf('~'));
					if (sp != null && !sp.equals(""))	where += " and a.pi_pricd >= " + sp;
					String ep = arrSch[i].substring(arrSch[i].indexOf('~') + 1);
						where += " and a.pi_pricd <= " + ep;
				}
			}
		}
	}
}