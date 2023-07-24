package ctrl;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import config.CtrlConfig.LoginRequired;
import svc.ScheduleSvc;
import vo.CalendarInfo;
import vo.MemberInfo;
import vo.ScheduleInfo;

@Controller
public class ScheduleCtrl {	// 일정관리 관련 모든 기능을 매핑시키는 컨트롤러 클래스
	private ScheduleSvc scheduleSvc;
	
	public void setSchduleSvc(ScheduleSvc scheduleSvc) {
		this.scheduleSvc = scheduleSvc;
	}
	@GetMapping("/schedule")
	@LoginRequired
	public String schedule(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int curYear, curMonth, curDay, schYear, schMonth, schDay, schLast;
		LocalDate today = LocalDate.now();
		curYear = today.getYear();
		curMonth = today.getMonthValue();
		curDay = today.getDayOfMonth();
		
		if (request.getParameter("schYear") == null) {	
			schYear = curYear;	schMonth = curMonth;	schDay = curDay;	
		} else {
			schYear = Integer.parseInt(request.getParameter("schYear"));	schMonth = Integer.parseInt(request.getParameter("schMonth"));	schDay = 1;	
		}
		CalendarInfo ci = new CalendarInfo();
		
		ci.setCurYear(curYear);
		ci.setCurMonth(curMonth);
		ci.setCurDay(curDay);
		ci.setSchDay(schDay);
		ci.setSchMonth(schMonth);
		ci.setSchYear(schYear);
		LocalDate edate = LocalDate.of(schYear, schMonth, 1);
		ci.setSchLast(edate.lengthOfMonth());
		ci.setsWeek(edate.getDayOfWeek().getValue());
		
		HttpSession session = request.getSession();
		MemberInfo mi = (MemberInfo)session.getAttribute("loginInfo");
		List<ScheduleInfo> scheduleList = scheduleSvc.getScheduleList(mi.getMi_id(), schYear, schMonth);
		
		
		request.setAttribute("ci", ci);
		request.setAttribute("scheduleList", scheduleList);
		return "schedule/schedule";
	}
	@GetMapping("/scheduleInForm")
	public String scheduleInForm(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int y = Integer.parseInt(request.getParameter("y"));
		int m = Integer.parseInt(request.getParameter("m"));
		int d = Integer.parseInt(request.getParameter("d"));
		
		CalendarInfo ci = new CalendarInfo();
		ci.setSchYear(y);	ci.setSchMonth(m);	ci.setSchDay(d);
		LocalDate schDate = LocalDate.of(y, m, d);
		ci.setSchLast(schDate.lengthOfMonth());
		ci.setCurYear(LocalDate.now().getYear());
				
		request.setAttribute("ci", ci);
		return "schedule/scheduleInForm";
	}
	@PostMapping("/scheduleInProc")
	public String scheduleInProc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ScheduleInfo si = new ScheduleInfo(0, ((MemberInfo)request.getSession().getAttribute("loginInfo")).getMi_id(), request.getParameter("si_date"), request.getParameter("si_time"), request.getParameter("content"), null);
		if (scheduleSvc.scheduleInsert(si) != 1) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('일정 등록에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return "redirect:/schedule?schYear=" + request.getParameter("si_date").substring(0,4) + "&schMonth=" + request.getParameter("si_date").substring(5,7);
	}
}
