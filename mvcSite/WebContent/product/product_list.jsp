<%@page import="com.sun.javafx.geom.PickRay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	ArrayList<ProductInfo> productList = (ArrayList<ProductInfo>) request.getAttribute("productList");
	ArrayList<ProductCtgrSmall> smallList = (ArrayList<ProductCtgrSmall>) request.getAttribute("smallList");
	ArrayList<ProductBrand> brandList = (ArrayList<ProductBrand>) request.getAttribute("brandList");

	String name = "", chkBrd = "", sp = "", ep = "", sch = pageInfo.getSch();
	int pr1 = 0, pr2 = 0;

	if (sch != null && !sch.equals("")) { // 검색조건 : &sch=ntest,bB1:B2:B3,p100000~200000
		String[] arrSch = sch.split(",");
		for (int i = 0; i < arrSch.length; i++) {
			char c = arrSch[i].charAt(0);
			if (c == 'n') {
				name = arrSch[i].substring(1);
			} else if (c == 'b') {
				chkBrd = arrSch[i].substring(1);
			} else if (c == 'p') {
				sp = arrSch[i].substring(1, arrSch[i].indexOf('~'));
				ep = arrSch[i].substring(arrSch[i].indexOf('~') + 1);
			}
		}
	}
%>
<style>
.bigCtgr {
	width: 100px;
	height: 30px;
	font-size: 1.5em;
	background: #efefef;
	text-align: center;
	border: 1px solid #c1c1c1;
	margin: 10px;
	padding: 5px;
	display: inline-block;
}

#pcb {
	background: lightgreen;
}

del {
	font-size: 0.8em;
	color: #a0a0a0;
}

.saleStock {
	font-size: 0.8em;
}
</style>
<script>
	function initSch() { //	검색조건(상품명, 브랜드, 가격대)들을 모두 없애주는 함수
		var frm = document.frm2;
		frm.pdt.value = "";
		frm.sp.value = "";
		frm.ep.value = "";
		var arr = frm.brand; //	brand라는 이름의 컨트롤들을 배열로 받아옴
		for (var i = 1; i < arr.length; i++) {
			arr[i].checked = false;
		}
	}
	function makeSch() { //	검색 폼의 조건들을 쿼리스트링 sch의 값으로 만듦
		var frm = document.frm2; //	&sch=ntest,bB1:B2:B3,p100000~200000
		var sch = "";

		var pdt = frm.pdt.value.trim(); // 검색어
		if (pdt != "")
			sch += "n" + pdt; // sch=n검색어

		var arr = frm.brand; //	brand라는 이름의 컨트롤들을 배열로 받아옴
		var isFirst = true; //	brand 체크박스들 중 첫번째로 선택한 체크박스인지 여부를 저장할 변수
		for (var i = 1; i < arr.length; i++) {
			if (arr[i].checked) {
				if (isFirst) { // 첫번째로 선택한 체크박스이면
					isFirst = false;
					if (sch != "")
						sch += ","; // 기존에 검색어가 있을 경우
					sch += "b" + arr[i].value;
				} else {
					sch += ":" + arr[i].value;
				}
			}
		} // sch=n검색어,b브랜드(들)

		var sp = parseInt(frm.sp.value), ep = parseInt(frm.ep.value); // 가격대
		if (sp != "" || ep != "") { // 가격대중 하나라도 값이 있으면
			if (sch != "")
				sch += ",";
			if (sp > ep && (sp != "" && ep != ""))
				sch += "p" + ep + "~" + sp;
			else
				sch += "p" + sp + "~" + ep;
			
			
		} // sch=n검색어,b브랜드(들),p최저가~최고가
		document.frm1.sch.value = sch;
		document.frm1.submit(); // sch=n검색어,p최저가~최고가
	}
</script>
<h2>상품 목록</h2>
<div class="bigCtgr"
	<%if (pageInfo.getPcb() != null && pageInfo.getPcb().equals("AA")) {%>
	id="pcb" <%}%>>
	<a href="productList?pcb=AA">구두</a>
</div>
<div class="bigCtgr"
	<%if (pageInfo.getPcb() != null && pageInfo.getPcb().equals("BB")) {%>
	id="pcb" <%}%>>
	<a href="productList?pcb=BB">운동화</a>
</div>
<%
	if (smallList.size() > 0) { // 소분류 목록이 있으면(검색조건에 대분류가 있으면)
		out.println("<br /><br />");
		for (ProductCtgrSmall ps : smallList) {
%>
<a
	href="productList?pcb=<%=ps.getPcb_id()%>&pcs=<%=ps.getPcs_id() + pageInfo.getObargs() + pageInfo.getVargs()%>"><%=ps.getPcs_name()%></a>
&nbsp;&nbsp;&nbsp;
<%
	}
	}
%>
<hr />
<table width="800">
	<tr>
		<td width="150" valign="top">
			<!-- 검색 조건으로 링크를 걸기 위한 쿼리스트링용 컨트롤들의 집합 -->
			<form name="frm1">
				<input type="hidden" name="pcb" value="<%=pageInfo.getPcb()%>">
				<%
					if (pageInfo.getPcs() != null && !pageInfo.getPcs().equals("")) {
				%>
				<input type="hidden" name="pcs" value="<%=pageInfo.getPcs()%>">
				<%
					}
				%>
				<input type="hidden" name="ob" value="<%=pageInfo.getOb()%>">
				<input type="hidden" name="v" value="<%=pageInfo.getV()%>">
				<input type="hidden" name="sch" value="">
			</form> <!-- 검색 조건 입력 폼 -->
			<form name="frm2">
				<input type="hidden" name="brand" value="">
				<div>
					<input type="text" name="pdt" id="pdt" placeholder="상품명 검색"
						value="<%=name%>" /><br />
					<fieldset>
						<legend>브랜드</legend>
						<%
							for (ProductBrand brand : brandList) {
						%>
						<input type="checkbox" name="brand" id="<%=brand.getPb_id()%>"
							value="<%=brand.getPb_id()%>"
							<%if (chkBrd.indexOf(brand.getPb_id()) >= 0) {%>
							checked="checked" <%}%> /><label for="<%=brand.getPb_id()%>"><%=brand.getPb_name()%></label><br />
						<%
							}
						%>
					</fieldset>
					<fieldset>
						<legend>가격대</legend>
						<input type="text" name="sp" class="price" value="<%=sp%>"
							placeholder="최저가" onkeyup="onlyNum(this);" /> ~ <input
							type="text" name="ep" class="price" value="<%=ep%>"
							placeholder="최고가" onkeyup="onlyNum(this);" />
					</fieldset>
					<input type="button" value="상품 검색" class="btn" onclick="makeSch();" />
					<input type="button" value="조건 초기화" class="btn"
						onclick="initSch();" />
				</div>
			</form>
		</td>
		<td width="*" valign="top">
			<!-- 상품 목록 및 페이징 영역 --> <%
 	if (pageInfo.getPcnt() > 0) { //	검색된 상품목록이 있을 경우	//	보기방식(목록형, 갤러리형)이미지 지정
 		String imgList = "/mvcSite/img/ico_l.png";
 		String imgGall = "/mvcSite/img/ico_g.png";
 		if (pageInfo.getV().equals("g"))
 			imgGall = "/mvcSite/img/ico_g_on.png";
 		else
 			imgList = "/mvcSite/img/ico_l_on.png";

 		String lnk = "productList?cpage=1" + pageInfo.getSchargs(); // 정렬 및 보기 방식용 공통 링크
 %>
			<p align="right">
				<select name="ob"
					onchange="location.href='<%=lnk + pageInfo.getVargs()%>&ob=' + this.value;">
					<option value="a" <%if (pageInfo.getOb().equals("a")) {%>
						selected="selected" <%}%>>신상품</option>
					<option value="b" <%if (pageInfo.getOb().equals("b")) {%>
						selected="selected" <%}%>>인기순</option>
					<option value="c" <%if (pageInfo.getOb().equals("c")) {%>
						selected="selected" <%}%>>낮은 가격순</option>
					<option value="d" <%if (pageInfo.getOb().equals("d")) {%>
						selected="selected" <%}%>>높은 가격순</option>
					<option value="e" <%if (pageInfo.getOb().equals("e")) {%>
						selected="selected" <%}%>>평점 높은순</option>
					<option value="f" <%if (pageInfo.getOb().equals("f")) {%>
						selected="selected" <%}%>>리뷰 많은 순</option>
					<option value="g" <%if (pageInfo.getOb().equals("g")) {%>
						selected="selected" <%}%>>조회수 높은 순</option>
				</select> &nbsp;&nbsp;&nbsp;&nbsp; <img src="<%=imgList%>" width="18"
					height="22" align="absmiddle" class="hand"
					onclick="location.href='<%=lnk + pageInfo.getObargs()%>&v=l';" />
				<img src="<%=imgGall%>" width="18" height="22" align="absmiddle"
					class="hand"
					onclick="location.href='<%=lnk + pageInfo.getObargs()%>&v=g';" />
			</p>
			<hr />
			<table width="100%" cellpadding="15" cellspacing="0">
				<%
					if (pageInfo.getV().equals("g")) { // 보기방식이 겔러리형일 경우
							int i = 0;
							for (; i < productList.size(); i++) {
								ProductInfo pi = productList.get(i);
								String stock = pi.getStock() + "ea";
								if (pi.getStock() > 0)
									lnk = "productView?piid=" + pi.getPi_id(); // 재고가 남았으면
								else {
									lnk = "javascript:alert('현재 재고가 없습니다.');";
									stock = "품절(SOLE OUT)";
								}
								String price = pi.getPi_price() + "원";
								if (pi.getPi_dc() > 0)
									price = Math.round(pi.getPi_price() * (1 - pi.getPi_dc())) + "원";
								price = "<del>" + pi.getPi_price() + "</del>&nbsp;&nbsp;&nbsp;" + price;

								if (i % 4 == 0)
									out.println("<tr>");
				%>
				<td width="25%" align="center" onmouseover="this.bgColor='#efefef';" onmouseout="this.bgColor='';"><a href="<%=lnk%>"> <img
						src="/mvcSite/product/pdt_img/<%=pi.getPi_img1()%>" width="150"
						height="150" border="0" /> <br /><%=pi.getPi_name()%>
				</a> <br /><%=price%><br /> <span class="saleStock">판매 : <%=pi.getPi_sale()%>ea
						/ 재고 : <%=stock%></span></td>
				<%
					if (i % 4 == 3)
									out.println("</tr>");
							}
							if (i % 4 > 0) {
								for (int j = 0; j < (4 - (i % 4)); j++) {
									out.println("<td width='25%'></td>");
								}
								out.println("</tr>");
							}
						} else { // 보기방식이 목록형일 경우

							for (ProductInfo pi : productList) {
								String stock = pi.getStock() + "ea";
								if (pi.getStock() > 0)
									lnk = "productView?piid=" + pi.getPi_id(); // 재고가 남았으면
								else {
									lnk = "javascript:alert('현재 재고가 없습니다.');";
									stock = "품절(SOLE OUT)";
								}
								String price = pi.getPi_price() + "원";
								if (pi.getPi_dc() > 0)
									price = Math.round(pi.getPi_price() * (1 - pi.getPi_dc())) + "원";
								price = "<del>" + pi.getPi_price() + "</del><br />" + price;
				%>
				<tr align="center" onmouseover="this.bgColor='#efefef';" onmouseout="this.bgColor='';">
					<td width="25%"><a href="<%=lnk%>"><img	src="/mvcSite/product/pdt_img/<%=pi.getPi_img1()%>" width="50" height="50" border="0" /></a></td>
					<td width="*" align="left">&nbsp;&nbsp; <a href="<%=lnk%>"><%=pi.getPi_name()%></a></td>
					<td width="20%"><%=price%></td>
					<td width="20%">판매 : <%=pi.getPi_sale()%>ea<br />재고 : <%=stock%></td>
				</tr>
				<%
					}
						}
						out.println("</table>");
						out.println("<p align='center'>"); // 페이징 영역을 보여줄 p태그

						String qs = pageInfo.getSchargs() + pageInfo.getObargs() + pageInfo.getVargs();
						   // 페이징 역역 링크에서 사용할 쿼리 스트링의 콩통 부분 (검색 조건들, 정렬방식, 보기방식)
						   
						   if (pageInfo.getCpage() == 1) {
						      out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;");
						   } else {
						      out.println("<a href='productList?cpage=1" + qs + "'>[&lt;&lt;]</a>&nbsp;");
						      out.println("<a href='productList?cpage=" + (pageInfo.getCpage() - 1) + qs + "'>[&lt;]</a>&nbsp;");
						   }
						   
						   int spage = (pageInfo.getCpage() - 1) / pageInfo.getBsize() * pageInfo.getBsize() + 1;
						   for (int i = 1, j = spage; i <= pageInfo.getBsize() && j <= pageInfo.getPcnt(); i++, j++){
						      // i : 블록에서 보여줄 체이지의 개수만큼 루프를 돌릴 조건으로 사용되는 변수
						      // j : 실제 출력할 페이지번호로 전체 페이지 개수 마지막 ㅍ페이지 번호를 넘지 않게 사용해야함
						      if (pageInfo.getCpage() == j) {
						         out.println("&nbsp;<strong>" + j + "</strong>&nbsp;");
						      } else {
						         out.println("&nbsp;<a href='productList?cpage=" + j + qs  + "'>" + j + "</a>&nbsp;");
						      }
						   }
						   if (pageInfo.getCpage() == pageInfo.getPcnt()) {
						      out.println("[&gt;]&nbsp;&nbsp;&nbsp;[&gt;&gt;]&nbsp;&nbsp;");
						      
						   } else {
						      out.println("&nbsp;<a href='productList?cpage=" + (pageInfo.getCpage() + 1) + qs + "'>[&gt;]</a>");
						      out.println("&nbsp;<a href='productList?cpage=" + pageInfo.getPcnt() + qs + "'>[&gt;&gt;]</a>");
						   }
						out.println("<p>");
					} else { //	검색된 상품목록이 없을 경우
						out.println("검색된 상품이 없습니다.");
					}
				%>
			
		</td>
	</tr>
</table>
</body>
</html>