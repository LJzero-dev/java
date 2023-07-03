<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
ArrayList<ProductInfo> productList = (ArrayList<ProductInfo>)request.getAttribute("productList");
ArrayList<ProductCtgrSmall> smallList = (ArrayList<ProductCtgrSmall>)request.getAttribute("smallList");
ArrayList<ProductBrand> brandList = (ArrayList<ProductBrand>)request.getAttribute("brandList");

String name = "", chkBrd = "", sp = "", ep = "", sch = pageInfo.getSch();

if (sch != null && !sch.equals("")) {	// 검색조건 : &sch=ntest,bB1:B2:B3,p100000~200000
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
.bigCtgr { width:100px; height:30px; font-size:1.5em; background:#efefef; text-align:center; border:1px solid #c1c1c1; margin:10px; padding:5px; display:inline-block; }
#pcb { background:lightgreen; }
</style>
<h2>상품 목록</h2>
<div class="bigCtgr" <% if (pageInfo.getPcb() != null && pageInfo.getPcb().equals("AA")) { %> id="pcb" <% } %>><a href="productList?pcb=AA">구두</a></div>
<div class="bigCtgr" <% if (pageInfo.getPcb() != null && pageInfo.getPcb().equals("BB")) { %> id="pcb" <% } %>><a href="productList?pcb=BB">운동화</a></div>
<%
if (smallList.size() > 0) {	// 소분류 목록이 있으면(검색조건에 대분류가 있으면)
	out.println("<br /><br />");
	for (ProductCtgrSmall ps : smallList) {
%>
<a href="productList?pcb=<%=ps.getPcb_id() %>&pcs=<%=ps.getPcs_id() + pageInfo.getObargs() + pageInfo.getVargs() %>"><%=ps.getPcs_name() %></a>&nbsp;&nbsp;&nbsp;
<%
	}
}
%>
<hr />
<table width="800">
	<tr>
		<td width="150" valign="top">
			<!-- 검색 조건 입력 폼 -->
			<form name="frm2" >
				<div>
					<input type="text" name="pdt" id="pdt" placeholder="상품명 검색" value="<%=name %>" /><br />					
					<fieldset>
						<legend>브랜드</legend>
							<% for(ProductBrand brand : brandList) { %>							
								<input type="checkbox" name="brand"  id="<%=brand.getPb_id() %>" value="<%=brand.getPb_id() %>" <% if(chkBrd.indexOf(brand.getPb_id()) >= 0) { %> checked="checked" <% } %>  /><label for="<%=brand.getPb_id() %>"><%=brand.getPb_name() %></label><br />
							<% } %>
					</fieldset>
					<fieldset>
						<legend>가격대</legend>
						<input type="text" name="sp" class="price" value="<%=sp %>" placeholder="최저가" onkeyup="onlyNum(this);" /> ~ 
						<input type="text" name="ep" class="price" value="<%=ep %>" placeholder="최고가" onkeyup="onlyNum(this);" />
					</fieldset>
					<input type="button" value="상품 검색" class="btn" onclick="" />
					<input type="button" value="조건 초기화" class="btn" onclick="" />
				</div>
			</form>
		</td>
		<td width="*" valign="top">
			<!-- 상품 목록 및 페이징 영역 -->
		</td>
	</tr>
</table>
</body>
</html>