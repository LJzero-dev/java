package servletex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("�α��� ���� �ʱ�ȭ");
	}
	
	@Override
	public void destroy() {
		System.out.println("�α��� ���� �Ҹ�");
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		if (userid.equals(userpw)) {
			resp.sendRedirect("/main.jsp");
			System.out.println("�α��� ����!");
		} else {
			resp.sendRedirect("/login.jsp");
			System.out.println("�α��� ����!");
		}
	}
}

