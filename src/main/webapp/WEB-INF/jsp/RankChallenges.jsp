<%@ page import="java.util.List" %>
<%@ page import="com.chamcode.model.Taikhoan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
} else {%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ranking challenges</title>
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
<%List<Taikhoan> ds = (List<Taikhoan>) session.getAttribute("rank-challenges");%>

<jsp:include page="include/menu.jsp"></jsp:include>
<div class="container">
    <table width="100%" class="table table-striped table-bordered table-hover"
           id="dataTables-example">
        <col width="15%">
        <col width="17%">
        <col width="17%">
        <col width="17%">
        <col width="17%">
        <col width="17%">
        <thead>
        <tr>
            <th>STT</th>
            <th>Username</th>
            <th>Score</th>
            <th>Best achievements</th>
            <th>Group</th>
            <th>Level</th>
        </tr>
        </thead>
        <tbody id="than">
        <%
            for (int i = 0; i < ds.size(); i++) {
                Taikhoan taikhoan = ds.get(i);
        %>
        <tr>
            <td><%=i+1%>
            </td>
            <td><%=taikhoan.getUsername()%>
            </td>
            <td><%=taikhoan.getDiemthuthach()%>
            </td>
            <td><%=taikhoan.getThanhtichthuthach()%>
            </td>
            <td><%=taikhoan.getRole()%>
            </td>
            <td><%=taikhoan.getLevel()%>
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