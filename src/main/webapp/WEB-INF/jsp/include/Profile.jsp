<%@ page import="com.chamcode.model.Taikhoan" %><%--
  Created by IntelliJ IDEA.
  User: Hau
  Date: 1/28/2018
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Taikhoan taikhoan =(Taikhoan)session.getAttribute("taikhoan");%>
<div class="panel panel-danger">
    <div class="panel-heading">Profile</div>
    <div class="panel-body">
        <p>Username: <b  style="color: red;float: right" id="username"><%=taikhoan.getUsername()%></b></p>
        <p>Accede: <b id="accede" style="color: red;float: right"><%=taikhoan.getThoigiangianhap()%></b></p>
        <p>Score exercise: <b style="float: right" id="score-exercise"><%=taikhoan.getDiembaitap()%></b></p>
        <p>Score challenges: <b style="float: right" id="score-challenges"><%=taikhoan.getDiemthuthach()%></b></p>
        <p>Name: <b style="float: right" id="name"><%=taikhoan.getTen()%></b></p>
        <p>Level: <b style="color: red;float: right" id="level"><%=taikhoan.getLevel()%></b></p>
        <p>Group: <b style="float: right" id="role"><%=taikhoan.getRole()%></b></p>
        <p>Birth: <b style="float: right" id="namsinh"><%=taikhoan.getNamsinh()%></b></p>
        <hr>
        <a href="/Profile" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Go to profile</a>
        <hr>
    </div>
</div>
