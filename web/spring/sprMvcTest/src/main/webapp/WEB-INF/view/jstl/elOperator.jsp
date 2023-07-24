<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL Operator</h2>
\${5 + 7} = ${5 + 7}<br />
\${8 - 4} = ${8 - 4}<br />
\${6 * 3} = ${6 * 3}<br />
\${9 / 3} = ${9 / 3}<br />
\${9 div 3} = ${9 div 3}<br />
\${10 % 3} = ${10 % 3}<br />
\${10 mod 3} = ${10 mod 3}<br />
<hr />
\${10 == 9} = ${10 == 9}<br />
\${10 eq 9} = ${10 eq 9}<br />
\${10 != 9} = ${10 != 9}<br />
\${10 ne 9} = ${10 ne 9}<br />
\${7 < 8} = ${7 < 8}<br />
\${7 lt 8} = ${7 lt 8}<br />
\${7 > 8} = ${7 > 8}<br />
\${7 gt 8} = ${7 gt 8}<br />
\${15 <= 9} = ${15 <= 9}<br />
\${15 le 9} = ${15 le 9}<br />
\${7 >= 2} = ${7 >= 2}<br />
\${7 ge 2} = ${7 ge 2}<br />
\${5 + 3 == 8 ? 8 : 10} = ${5 + 3 == 8 ? 8 : 10}<br />
</body>
</html>