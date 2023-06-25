package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/uploadPartProc2")
@MultipartConfig(
	fileSizeThreshold = 0,
	location = "E:/ljy/web/errUploadMail/WebContent/upload"
)
public class UploadPartProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UploadPartProc2() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String uploadFiles = "";									// 업로드한 파일들의 이름을 누적하여 저장할 변수
		
		for (Part part : request.getParts()) {						// getParts() : 사용자가 보낸 데이터(컨트롤)들을 Collection<Part>에 담아 리턴, 받아온 Part 객체들을 하나씩 Part형 인스턴스 part에 담아 루프 돔
			if (part.getName().startsWith("file")) {				// part로 받아온 컨트롤의 이름이 file로 시작하는 컨트롤일 경우에만 작업
				String cd = part.getHeader("content-disposition");	// 예) form-data; name="file1"; filename="업로드하는파일명.확장자" file객체가 비었으면 form-data; name="file1"; filename=""
				String uploadName = getUploadFileName(cd);
				if (!uploadName.equals("")) {						// 업로드할 파일이 있으면
					uploadFiles += ", " + uploadName;
					part.write(uploadName);
				}
			}
		}
		if (!uploadFiles.equals(""))	uploadFiles = uploadFiles.substring(2);
		out.println("업로더" + name + "님이" + uploadFiles + "파일들을 업로드 했습니다."); 
	}
	private String getUploadFileName(String cd) {
		String uploadName = null;
		String[] arrContent = cd.split(";");

		int fIdx = arrContent[2].indexOf("\"");
		int sIdx = arrContent[2].lastIndexOf("\"");
		
		uploadName = arrContent[2].substring(fIdx + 1, sIdx);
		return uploadName;
	}
}
