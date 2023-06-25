package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/callServlet")
public class CallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public CallServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // GET 방식으로 요청했을 경우 요청을 받는 메소드
    	request.setCharacterEncoding("utf-8");	//	사용자가 보낸 요청(request) 안의 모든 글자들의 인코딩을 유니코드로 지정
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	
    	response.setContentType("text/html; charset=utf-8");
    	// 요청자에게 응답(response)하기 워한 내용(Content)의 종류(type)를 지정(set)
    	PrintWriter out = response.getWriter();	//	요청자에게 응답하기 위한 출력 객체(PrintWriter)의 인스턴스 out 생성
    	
    	out.println("<html><head><title></title></head>");
    	out.println("<body>");
    	
    	if (id == null || pw == null) {
        	out.println("<script>");
        	out.println("alert('아이디나 암호가 없습니다.')");
        	out.println("history.back();");
        	out.println("</script>");
    	}else {
        	out.println("<h2>GET방식으로 받은 값 출력</h2>");
        	out.println("id : " + id + "<br/>");
        	out.println("pw : " + pw);
    	}   
    	out.println("</body></html>"); 	
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// POST 방식으로 요청했을 경우 요청을 받는 메소드
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String[] arr = request.getParameterValues("aa");	// aa 라는 이름의 컨트롤이 여럿 있을 경우 그 값은 문자열 배열로 받을 수 있음
    	
    	response.setContentType("text/html; charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	out.println("<html><head><title></title></head>");
    	out.println("<body>");
        out.println("<h2>GET방식으로 받은 값 출력</h2>");
        out.println("id : " + id + "<br/>");
        out.println("pw : " + pw + "<br/>"); 
        out.println("aa : "); 
        for (int i = 0; i < arr.length; i++) {
        	if (i > 0) out.print(", ");
        	out.print(arr[i]);
        }
    	out.println("</body></html>");
	}
}














