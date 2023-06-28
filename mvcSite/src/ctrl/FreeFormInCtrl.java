package ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/freeFormIn")
public class FreeFormInCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FreeFormInCtrl() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bbs/free_form_in.jsp");	// �� ��� ���� ���̹Ƿ� ���� Service�� Dao Ŭ���� ���� �ٷ� View�� �ش��ϴ� jsp ���Ϸ� �̵�
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
