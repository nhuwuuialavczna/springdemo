<%--
  Created by IntelliJ IDEA.
  User: Hau
  Date: 1/28/2018
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
} else {%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Introduce</title>
    <jsp:include page="include/Lib.jsp"></jsp:include>
</head>
<body style="font-family: monospace">
<%--<%--%>
<%--if (session.getAttribute("taikhoan") == null) {--%>
<%--response.sendRedirect("/");--%>
<%--}--%>
<%--%>--%>
<jsp:include page="include/menu.jsp"></jsp:include>

<div class="container">
    <div class="col-lg-3">
        <jsp:include page="include/NewExercise.jsp"></jsp:include>
    </div>

    <div class="col-lg-6">
        <p>Chào mừng đến với hệ thống luyện code</p>
        <p>Hiện tại các chức năng đang trên đà hoàn thiện các bạn gặp bất kì lỗi gì hãy liên hệ với tôi qua <a
                href="https://www.facebook.com/profile.php?id=100009115420843">Facebook</a></p>
        <p>Chức năng đăng kí tài khoản sẽ không được thực hiện. Các bạn có thể liên hệ tôi để tạo tài khoản</p>
        <p>Hệ thống challenges đã hoàn thiện. Nếu bạn không có, có thể liên hệ tôi để mở khóa chức năng</p>

    </div>

    <div class="col-lg-3">
        <jsp:include page="include/Profile.jsp"></jsp:include>
    </div>
</div>

</div>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
<%}%>