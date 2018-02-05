<%@ page import="com.chamcode.model.Binhluan" %>
<%@ page import="com.chamcode.model.Traloibinhluan" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.chamcode.model.Taikhoan" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: JINX_NHI
  Date: 2/2/2018
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
} else {%>
<html>
<head>
    <%
        Binhluan binhluan = (Binhluan) session.getAttribute("binhluan");
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
    %>
    <title><%=binhluan.getBinhluan()%>
    </title>
    <jsp:include page="include/Lib.jsp"></jsp:include>
</head>
<body style="font-family: monospace">
<jsp:include page="include/menu.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h3><%=binhluan.getBinhluan()%>
            </h3>
        </div><!-- /col-sm-12 -->
    </div><!-- /row -->
    <hr>
    <div class="row">
        <%
            List<Traloibinhluan> ds = (List<Traloibinhluan>) session.getAttribute("tlbl");
            ds.sort((s1, s2) -> s2.getThoigian().compareTo(s1.getThoigian()));
        %>
        <%if (!ds.isEmpty()) {%>
        <%for (Traloibinhluan tl : ds) {%>
        <div class="col-lg-12">
            <div class="col-lg-1">
                <div title="<%=tl.getUsername()%>" class="thumbnail">
                    <img class="img-responsive user-photo"
                         src="<%=tl.getBinhluanByMabinhluan().getTaikhoanByUsername().getHinhanh()%>">
                </div><!-- /thumbnail -->
            </div><!-- /col-sm-1 -->

            <div class="col-lg-11">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong><%=tl.getUsername()%>
                        </strong> <span class="text-muted"><%=tl.getThoigian()%></span>
                    </div>
                    <div class="panel-body">
                        <%=tl.getCautraloi()%>
                    </div><!-- /panel-body -->
                </div><!-- /panel panel-default -->
            </div><!-- /col-sm-5 -->
        </div>
        <%}%>
        <%} else {%>
        <h4>No anwser for question</h4>
        <%}%>
        <h3>Your answer:</h3>
        <hr>
        <div class="col-lg-12">
            <div class="col-lg-1">
                <div title="<%=taikhoan.getUsername()%>" class="thumbnail">
                    <img class="img-responsive user-photo" src="<%=taikhoan.getHinhanh()%>">
                </div><!-- /thumbnail -->
            </div><!-- /col-sm-1 -->

            <div class="col-lg-11">
                <form action="/Comment/AddAns" method="get">
                <textarea class="form-control" id="binhl" name="tl" rows="3"></textarea><br>
                <input type="submit" style="float: right" id="bl" class="btn btn-primary">Comment</input>
                </form>
            </div><!-- /col-sm-5 -->
        </div>
    </div><!-- /row -->

</div>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
<%}%>