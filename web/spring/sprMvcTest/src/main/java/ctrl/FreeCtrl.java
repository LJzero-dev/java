package ctrl;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import svc.FreeSvc;
import vo.FreeList;
import vo.PageInfo;

@Controller
public class FreeCtrl {
	private FreeSvc freeSvc;
	public void setFreeSvc(FreeSvc freeSvc) {
		this.freeSvc = freeSvc;
	}	
	@GetMapping("/freeList")
	public String freeList(Model model, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		int cpage = 1, pcnt = 0, spage = 0, rcnt = 0, psize = 3, bsize = 4, num = 0;
		String where = " where fl_isview = 'y' ", args = "", schargs = "";
		if (request.getParameter("cpage") != null)	cpage = Integer.parseInt(request.getParameter("cpage"));	// ���Ȼ��� ������ ��������� ���� int������ ����ȯ��
		String schtype = request.getParameter("schtype"), keyword = request.getParameter("keyword");
		if (schtype == null || keyword == null) keyword = "";
		else if (!schtype.equals("") && !keyword.trim().equals("")) {
			URLEncoder.encode(keyword, "UTF-8");
			keyword = keyword.trim();
			if (schtype.equals("tc")) {	// �˻������� '����+����'�� ���
				where += " and (fl_title like '%" + keyword + "%' or fl_content like '%" + keyword + "%') ";
			} else {
				where += " and fl_" + schtype + " like '%" + keyword + "%' ";
			}
			schargs = ("&schtype=" + schtype + "&keyword=" + keyword).trim();
		}
		args = "&cpage=" + cpage + schargs;
		
		rcnt = freeSvc.getFreeListCount(where);	// �˻��� �Խñ��� �� ������ �Խñ� �Ϸù�ȣ ��°� ��ü �������� ����� ���� ��
		List<FreeList> freeList = freeSvc.getFreeList(where, cpage, psize);
		pcnt = rcnt / psize; if(rcnt % psize > 0)	pcnt++;
		spage = (cpage - 1) / bsize * bsize + 1;
		num = rcnt - (psize * (cpage - 1));
		PageInfo pi = new PageInfo();
		pi.setBsize(bsize);	pi.setCpage(cpage);	pi.setPcnt(pcnt);	pi.setRcnt(rcnt);	pi.setSpage(spage);	pi.setNum(num);	pi.setSchtype(schtype);	pi.setKeyword(keyword);	pi.setArgs(args);	pi.setSchargs(schargs);	// ����¡�� �ʿ��� ������� �˻������� PageInfo�� �ν��Ͻ��� ����		
		model.addAttribute("freeList", freeList);
		model.addAttribute("pi", pi);
		return "bbs/freeList";
	}
	@GetMapping("/freeView")
	public String freeView(Model model, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int flidx = Integer.parseInt(request.getParameter("flidx")), cpage = Integer.parseInt(request.getParameter("cpage"));
		String args = "?cpage=" + cpage, schtype = request.getParameter("schtype"), keyword = request.getParameter("keyword");				
		if (schtype != null && !schtype.equals("") & keyword != null && !keyword.equals("")) {
			URLEncoder.encode(keyword, "UTF-8");
			args += "&schtype=" + schtype + "&keyword=" + keyword;
		}		
		model.addAttribute("fl",freeSvc.getFreeInfo(flidx));
		model.addAttribute("args",args);
		return "bbs/freeView";
	}
}