<%@ page import="java.util.List" %>
<%@ page import="com.chamcode.model.Taikhoan" %>
<%@ page import="com.chamcode.model.Bainop" %>
<%@ page import="com.chamcode.model.Binhluan" %>
<%@ page import="com.chamcode.model.Monthuthach" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
} else {%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Comment</title>
    <jsp:include page="include/Lib.jsp"></jsp:include>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!--MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body style="font-family: monospace">
<%
    List<Binhluan> ds = (List<Binhluan>) session.getAttribute("comment");
    List<Monthuthach> monthuthachList = (List<Monthuthach>) session.getAttribute("monhoc");
%>

<jsp:include page="include/menu.jsp"></jsp:include>
<div class="container">
    <button class="btn btn-danger" data-toggle="collapse" data-target="#demo">New question</button>
    <hr>
    <div id="demo" class="collapse">
        <form action="/Comment/Add" method="get">
            <textarea class="form-control" name="bl"></textarea><br>
            <div class="row">
                <div class="col-lg-5">
                    <select name="monhoc" class="form-control">
                        <%for (Monthuthach monthuthach : monthuthachList) {%>
                        <option value="<%=monthuthach.getMamonhoc()%>"><%=monthuthach.getMamonhoc()%>
                        </option>
                        <%}%>
                    </select>
                </div>
                <div class="col-lg-5">
                    <input type="submit" class="btn bg-primary" value="Add question"></input>
                </div>
            </div>

        </form>
    </div>
    <hr>
    <table width="100%" class="table table-striped table-bordered table-hover"
           id="dataTables-example">
        <col width="5%">
        <col width="55%">
        <col width="10%">
        <col width="10%">
        <col width="20%">
        <thead>
        <tr>
            <th>STT</th>
            <th>Question</th>
            <th>Category</th>
            <th>User</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody id="than">
        <%
            for (int i = 0; i < ds.size(); i++) {
                Binhluan bl = ds.get(i);
        %>
        <tr>
            <td><%=i + 1%>
            </td>
            <td title="<%=bl.getBinhluan()%>"><a
                    href="/Comment/Get?mbl=<%=bl.getMabinhluan()%>"><%=(bl.getBinhluan().length() > 50) ? bl.getBinhluan().substring(0, 50) + "..." : bl.getBinhluan()%>
            </a>
            </td>
            <td><%=bl.getLoai()%>
            </td>
            <td><%=bl.getUsername()%>
            </td>
            <td><%=bl.getThoigian()%>
            </td>
        </tr>
        <%}%>
        </tbody>

    </table>

</div>
<div class="footer">Trường Đại học Nông Lâm thành phố Hồ Chí Minh.</div>
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<%--<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>--%>
<!--<script src="../lib/model.js"></script>-->
<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>
</body>
</html>
<%}%>
