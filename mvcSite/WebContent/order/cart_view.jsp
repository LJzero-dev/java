<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_inc/inc_head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<OrderCart> cartList = (ArrayList<OrderCart>)request.getAttribute("cartList");
int max = 10;
%>
<style>
#list td { border-bottom:1px solid black; }
</style>
<script>
function chkAll(all) {	// '전체 선택' 체크박스 클릭 시 모든 체크박스에 대한 체크 여부를 처리하는 함수
	var arr = document.frmCart.chk;
	for (var i = 1; i < arr.length; i++) {
		arr[i].checked = all.checked;
	}
}
function chkOne(one) {	// 특정 체크박스 클릭 시 체크 여부에 따른 '전체 선택' 체크박스의 체크 여부를 처리하는 함수
	var frm = document.frmCart;
	var all = frm.all;	// '전체 선택' 체크 박스
	if (one.checked) {	// 특정 체크박스를 체크 했을 경우
		var arr = document.frmCart.chk;
		var isChk = true;
		for (var i = 1; i < arr.length; i++) {
			if (!arr[i].checked) {
				isChk = false;	break;
			}
		}
		all.checked = isChk;
	} else {			// 특정 체크박스를 체크 해제 했을 경우
		all.checked = false;
	}
}
function cartDel(ocidx) {	// 장바구니 내 특정 상품을 삭제하는 함수
	if(confirm("정말 삭제하시겠습니까?")) {
		$.ajax({
			type : "POST", url : "/mvcSite/careProcDel", data : {"ocidx" : ocidx}, success : function(chkRs) {
				if (chkRs == 0) {
					alert("상품 삭제에 실패했습니다.\n다시 시도하세요.");
				}
				location.reload();
			}
		});
	}
}
function getSelectedChk() {	// 체크박스들 중 선택된 체크박스들의 값(value)들을 쉼표로 구분하여 문자열로 리턴하는 함수
	var chk = document.frmCart.chk;
	var idxs = "";	//	chk컨트롤 배열에서 선택된 체크박스의 값들을 누적 저장할 변수
	for (var i = 1; i < chk.length; i++) {
		if (chk[i].checked) idxs += "," + chk[i].value;
	}
	return idxs.substring(1);
}
function chkDel() {	// 사용자가 선택한 상품(들)을 삭제하는 함수
	var ocidx = getSelectedChk();
	//	선택한 체크박스의 oc_idx 값들이 쉼표를 기준으로 '1,2,3,4' 형태의 문자열로 저장됨
	if (ocidx == "")	alert("삭제할 상품을 선택하세요.");
	else				cartDel(ocidx);
}
</script>
<h2>장바구니</h2>
<form name="frmCart" action="orderForm" method="post">
	<input type="hidden" name="chk" />
	<input type="hidden" name="kind" value="c" />
	<input type="checkbox" name="all" id="all" checked="checked" onclick="chkAll(this);"/><label for="all">전체 선택</label>
	<% if (cartList.size() > 0) { 	 // 장바구니에 담긴 상품이 있을 경우
		int total = 0;				// 총 구매 가격의 누적값을 저장할 변수
		out.println("<table width='800' cellpadding='5' cellspacing='0' id='list'>");
		for (OrderCart oc : cartList) {
			int ocidx = oc.getOc_idx();
			%>
			<tr align="center" onmouseover="this.bgColor='#efefef';" onmouseout="this.bgColor='';">
				<td width="5%">
					<input type="checkbox" name="chk" value="<%=ocidx %>" onclick="chkOne(this);" checked="checked" />
				</td>
				<td width="15%">
					<a href="productView?piid=<%=oc.getPi_id() %>"><img src="/mvcSite/product/pdt_img/<%=oc.getPi_img1()%>" width="50" height="40" /></a>
				</td>
				<td width="20%">
					<a href="productView?piid=<%=oc.getPi_id() %>" /><%=oc.getPi_name() %></a>
				</td>
				<td width="25%">
					<select name="size">
						<% 	for (ProductStock ps : oc.getStockList()) {
							String txt = ps.getPs_size() + "mm (재고 : " + ps.getPs_stock() + "개)";
							String slt = "";
							if (ps.getPs_idx() == oc.getPs_idx()) {
								slt = " selected='selected' ";
								max = ps.getPs_stock();
								if (max > 10)	max = 10;
							}
							
							if (ps.getPs_stock() > 0) {	// 재고량이 있을 경우에만 보여줌
								%>
								<option value="<%=oc.getPs_idx() %>" <%=slt %>><%=txt %></option>
								<%
							}
						 } %>
					</select>
				</td>
				<td width="10%">
					<select name="cnt">
						<% for (int i = 1; i <= max ; i++) {
							String slt = "";
							if (oc.getOc_cnt() == i) slt = " selected='selected' ";
							%>
							<option value="<%=i %>" <%=slt %>><%=i %></option>
							<%
							}
						%>
					</select>
				</td>
				<td width="15%">
					<%=oc.getPi_price() * oc.getOc_cnt() %>
				</td>
				<td width="*">
					<input type="button" value="삭제" onclick="cartDel(<%=oc.getOc_idx() %>);" />
				</td>
			</tr>
			<%
			total += oc.getPi_price() * oc.getOc_cnt();
		}
		%>
		</table>
		<p align="right" style="width:800px; font-size: 1.8em;" >총 구매 가격 : <%=total %></p>
		<p align="center" style="width:800px; font-size: 1.3em;" >
			<input type="button" value="선택한 상품 삭제" onclick="chkDel();" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="선택한 상품 구매" onclick="chkBuy();" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="전체 상품 구매" onclick="allBuy();" />
		</p>
	<% } else {	// 장바구니에 담긴 상품이 없을 경우 %>
	<p style="width:800px; text-align:center;">장바구니에 담긴 상품이 없습니다.</p>
	<% } %>
</form>
</body>
</html>