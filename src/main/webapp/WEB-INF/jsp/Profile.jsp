<%@ page import="com.chamcode.model.Taikhoan" %><%--
  Created by IntelliJ IDEA.
  User: Hau
  Date: 1/28/2018
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
} else {%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%
        Taikhoan taikhoanSS = (Taikhoan) session.getAttribute("taikhoan");
        Taikhoan taikhoan = (Taikhoan) session.getAttribute("profile");
    %>
    <title>Profile</title>
    <jsp:include page="include/Lib.jsp"></jsp:include>
    <script>
        $(document).ready(function () {
            $(".changeFB").on('click', function () {
                $("#notify").html('Changing...');
                var fb = $("#fb").val();
                var email = $("#email").val();
                var ten = $("#ten").val();
                var gioithieu = $("#gioithieu").val();
                var hinhanh = $("#image").val();
                $.ajax({
                    type: "get",
                    url: "/Profile/ChangeFaceBook?fb=" + fb + "&email=" + email + "&ten=" + ten + "&gioithieu=" + gioithieu + "&hinhanh=" + hinhanh,
                    contentType: "utf-8",
                    success: function (data) {
                        $("#notify").html('');

                    },
                    error: function (err) {
                        $("#notify").html('There was an error');
                    }
                });
            });

            $("#btnChangePass").on('click', function () {
                $("#btnChangePass").html('Changing...');
                var old = $("#old").val();
                var pass = $("#new").val();
                var repass = $("#renew").val();

                var oldss = '<%=taikhoan.getPassword()%>';
                if (oldss != old) {
                    $("#notifychangepass").html("Old pass and new pass don't match");
                } else if (pass !== repass) {
                    $("#notifychangepass").html("New pass and renew pass don't match");
                } else {
                    $("#notifychangepass").html();
                    $.ajax({
                        type: "get",
                        url: "/Profile/ChangePass?pass=" + pass,
                        contentType: "utf-8",
                        success: function (data) {
                            $("#btnChangePass").html('Change');
                            window.location.reload();
                        },
                        error: function (err) {
                            $("#notify").html('There was an error');
                        }
                    });
                }
            });
            <%if (!taikhoanSS.getUsername().equals(taikhoan.getUsername())) {%>
            $("#changeE").hide();
            $('#changeIMG').hide();
            $('#changeFB').hide();
            $("#changname").hide();
            <%}%>

        });
    </script>
</head>
<body style="font-family: monospace">
<jsp:include page="include/menu.jsp"></jsp:include>
<div class="container">
    <br>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <div class="row">
                            <div class="col-lg-8"><input
                                        <%if(!taikhoanSS.getUsername().equals(taikhoan.getUsername())){%>readonly="readonly"<%}%>
                                        type="text" id="ten" class="form-control "
                                        value="<%=taikhoan.getTen()%>"><br></div>
                            <div class="col-lg-4">
                                <button id="changname" class="btn btn-primary changeFB">Change</button>
                            </div>

                        </div>


                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img id="img" alt="<%=taikhoan.getTen()%>"
                                                                            src="<%=taikhoan.getHinhanh()%>"
                                                                            class="img-circle img-responsive"></div>

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Username:</td>
                                    <td><%=taikhoan.getUsername()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Score exercise</td>
                                    <td><%=taikhoan.getDiembaitap()%>
                                    </td>
                                </tr>
                                <tr>
                                <tr>
                                    <td>Score challenges</td>
                                    <td><%=taikhoan.getDiemthuthach()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Accede</td>
                                    <td><%=taikhoan.getThoigiangianhap()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Best achievements</td>
                                    <td><%=taikhoan.getThanhtichthuthach()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Facebook</td>
                                    <td>
                                        <input <%if(!taikhoanSS.getUsername().equals(taikhoan.getUsername())){%>readonly="readonly"<%}%>
                                               type="text" value="<%=taikhoan.getFacebook()%>" id="fb"
                                               class="form-control"></td>
                                    <td>
                                        <button class="btn btn-success changeFB" id="changeFB"><span></span> Change
                                        </button>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Email</td>
                                    <td>
                                        <input <%if(!taikhoanSS.getUsername().equals(taikhoan.getUsername())){%>readonly="readonly"<%}%>
                                               type="text" value="<%=taikhoan.getEmail()%>" id="email"
                                               class="form-control"></td>
                                    <td>
                                        <button class="btn btn-success changeFB" id="changeE"><span></span> Change
                                        </button>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Image account</td>
                                    <td>
                                        <input <%if(!taikhoanSS.getUsername().equals(taikhoan.getUsername())){%>readonly="readonly"<%}%>
                                               type="text" value="<%=taikhoan.getHinhanh()%>" id="image"
                                               class="form-control"></td>
                                    <td>
                                        <button class="btn btn-success changeFB" id="changeIMG"><span></span> Change
                                        </button>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Level</td>
                                    <td><%=taikhoan.getLevel()%>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Group</td>
                                    <td><%=taikhoan.getRole()%>
                                    </td>
                                </tr>
                                </tbody>
                            </table>

                            <button data-toggle="collapse" data-target="#About" class="btn btn-primary">About</button>
                            <br>
                            <div id="About" class="collapse">
                                <textarea <%if(!taikhoanSS.getUsername().equals(taikhoan.getUsername())){%>readonly="readonly"<%}%>
                                          id="gioithieu" class="form-control"><%=taikhoan.getGioithieu()%></textarea>
                            </div>
                            <hr>
                            <%if (taikhoanSS.getUsername().equals(taikhoan.getUsername())) {%>
                            <button data-toggle="collapse" data-target="#Change-password" class="btn btn-primary">Change
                                password
                            </button>
                            <br><br>
                            <div id="Change-password" class="collapse">
                                <input class="form-control" type="text" id="old" placeholder="Old pass"><br>
                                <input class="form-control" type="text" placeholder="New pass" id="new"><br>
                                <input class="form-control" type="text" placeholder="Re-new pass" id="renew"><br>
                                <p style="color: red" id="notifychangepass"></p>
                                <button id="btnChangePass" class="btn btn-success">Chang pass</button>
                                <hr>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button"
                       class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                    <p style="color: red" id="notify"></p>
                </div>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
<%}%>