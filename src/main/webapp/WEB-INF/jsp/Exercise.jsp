<%@ page import="java.util.List" %>
<%@ page import="com.chamcode.model.Chuong" %><%--
  Created by IntelliJ IDEA.
  User: Hau
  Date: 1/29/2018
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
} else {%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exercise</title>
    <!-- Bootstrap CSS -->
    <jsp:include page="include/Lib.jsp"></jsp:include>

    <script>

        $(document).ready(function () {
            $("#viewexercise").hide();
            $("#tb").hide();
            $("#tb1").hide();
            $("#btnGoTo").hide();
            $("#sel1").on('change', function () {
                $("#tb").show();
                $("#browsers option").remove();
                var val = $("#sel1").val();
                if (val != '') {
                    $.ajax({
                        type: "GET",
                        url: "/Exercise/GetTheoChuong?chuong=" + val,
                        contentType: "utf-8",
                        success: function (data) {
                            $("#tb").hide();
                            var ds = data.split('|');
                            ds.forEach(function (value, index) {
                                var opt = document.createElement('option');
                                opt.value = value.split('`')[0];
                                opt.innerHTML = (index + 1) + '.' + value.split('`')[1];
                                $("#browsers").append(opt);
                            });


                        },
                        error: function (err) {
                        }
                    });
                }
            });
            // $("#monhoc").on('change',function () {
            //    alert($("#monhoc").val());
            // });

            $("#search-exercise").on('click', function () {
                var mbc = $("#baicode").val();
                $("#tb1").show();
                if (mbc !== '') {
                    $.ajax({
                        type: "GET",
                        url: "/Exercise/GetTheoMa?mbc=" + mbc,
                        contentType: "utf-8",
                        success: function (data) {
                            $("#tb1").hide();
                            var ds = data.split('`');
                            $("#mabaicode").html(ds[0] + '. ' + ds[1]);
                            $("#noidung").html(ds[2]);
                            $("#input").html(ds[3]);
                            $("#output").html(ds[4]);
                            $("#inputvidu").html(ds[5]);
                            $("#outputvidu").html(ds[6]);
                            $("#mbc").html(ds[0]);
                            $("#viewexercise").show();
                            $("#btnGoTo").show();
                        },
                        error: function (err) {
                        }
                    });
                }
            });

            $('#btnGoTo').on('click', function () {
                var mbc = $("#baicode").val();
                window.location.href = "/IDE/GoToIDE?mbc=" + mbc;
            });
        });
    </script>
</head>
<body style="font-family: monospace">

<jsp:include page="include/menu.jsp"></jsp:include>
<div class="container">
    <%List<Chuong> list = (List<Chuong>) session.getAttribute("chuong");%>


    <div class="col-lg-9">
        <!--phần content cho tất cả trang. Ngoại trừ trang code sẽ có giao diện khác-->
        <div class="form-group">
            <label for="sel1">Choose chapter:</label>
            <select class="form-control" id="sel1">
                <option value="">Select the chapter</option>
                <%for (Chuong chuong : list) {%>
                <option value="<%=chuong.getChuong()%>"><%=chuong.getChuong()%>. <%=chuong.getTenchuong()%>
                </option>
                <%}%>
            </select>
        </div>


        <div class="form-group">
            <p style="color: red" id="tb">Loading...</p>
            <label for="browsers">Input exercise code or choose exercise:</label>
            <input id="baicode" class="form-control" list="browsers">
            <datalist id="browsers">

            </datalist>
        </div>
        <div class="form-group">
            <button class="btn btn-default" id="search-exercise"><span class="glyphicon glyphicon-search"></span> Search
            </button>
            <button class="btn btn-primary" id="btnGoTo"><span class="glyphicon glyphicon-send"></span> Go to with
                exercise <b id="mbc"></b>
            </button>
            <p style="color: red" id="tb1">Loading...</p>
        </div>

        <div id="viewexercise">
            <p>
            <h3 style="text-align: center" id="mabaicode"></h3></p>
            <hr>

            <p id="noidung"></p>
            <hr>

            <p>
            <h3>Input: </h3><h4 id="input"></h4></p>
            <p>
            <h3>Output: </h3><h4 id="output"></h4></p>
            <hr>

            <h3 style="text-align: center">Example</h3>
            <p>
            <h3>Input: </h3><h4 id="inputvidu"></h4></p>
            <p>
            <h3>Output: </h3><h4 id="outputvidu"></h4></p>
        </div>

    </div>
    <div class="col-lg-3">
        <jsp:include page="include/Profile.jsp"></jsp:include>

    </div>

</div>

<div class="footer">Trường Đại học Nông Lâm thành phố Hồ Chí Minh.</div>
</body>
</html>
<%}%>