<%@ page import="com.chamcode.model.Taikhoan" %>
<%@ page import="com.chamcode.model.Monthuthach" %><%--
  Created by IntelliJ IDEA.
  User: Hau
  Date: 1/28/2018
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
}else{%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Challenges</title>

    <jsp:include page="include/Lib.jsp"></jsp:include>
    <script>
        $(document).ready(function () {
            $("#hienthi").hide();
            $("#finish").hide();
            $("#giaithich").show();
            $('#finish').on('click', function () {
                window.location.href = "/Challenges/stop";
            });

            $('#next').on('click', function () {
                var a = $("input[name=optradio]:checked").val();
                $.ajax({
                    type: "GET",
                    url: "/Challenges/next?dachon=" + a,
                    contentType: "utf-8",
                    success: function (data) {
                        $("input[name=optradio]:checked").forEach(function(){
                            $(this).checked = false;
                        });

                        if (data == 'end') {
                            window.location.href = "/Challenges/stop?end=full"
                        }
                        if (data == 'fail') {
                            window.location.href = "/Challenges/stop";
                        } else {
                            var param = data.split("=");
                            var ma = param[0];
                            var cauHoi = param[1];
                            var dapAnA = param[2];
                            var dapAnB = param[3];
                            var dapAnC = param[4];
                            var dapAnD = param[5];
                            $("#cauhoi").attr('src', cauHoi);
                            $("#question-current").html(ma);
                            $("#lba").html(dapAnA);
                            $("#lbb").html(dapAnB);
                            $("#lbc").html(dapAnC);
                            $("#lbd").html(dapAnD);
                            var suss = parseInt($("#success").html().trim());
                            $("#success").html(suss + 1);

                        }

                    },
                    error: function (err) {
                    }
                });
            });

            $("#start").on('click', function () {
                $("#status").html("Processing");
                $("#start").hide();
                $("#finish").show();
                $("#hienthi").show();
                $("#giaithich").hide();
                var m = 15;
                var s = 0;
                var timeout = null;

                function start() {
                    if (s == -1) {
                        m -= 1;
                        s = 59;
                    }
                    if (m == -1) {
                        clearTimeout(timeout);
                        alert('Time-up');
                        window.location.href = "/Challenges/stop";
                        return false;
                    }
                    document.getElementById('remaining').innerHTML = m + ":" + s;
                }

                timeout = setInterval(function () {
                    s--;
                    start();
                }, 1000);
                $.ajax({
                    type: "GET",
                    url: "/Challenges/start",
                    contentType: "utf-8",
                    success: function (data) {
                        if (data == 'end') {
                            window.location.href = "/Challenges/stop?end=full"
                        }
                        var param = data.split("=");
                        var ma = param[0];
                        var cauHoi = param[1];
                        var dapAnA = param[2];
                        var dapAnB = param[3];
                        var dapAnC = param[4];
                        var dapAnD = param[5];
                        $("#cauhoi").attr('src', cauHoi);
                        $("#question-current").html(ma);
                        $("#lba").html(dapAnA);
                        $("#lbb").html(dapAnB);
                        $("#lbc").html(dapAnC);
                        $("#lbd").html(dapAnD);
                    },
                    error: function (err) {


                    }
                });
            });


        });

    </script>
</head>

<%
    Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
    Monthuthach maMonHoc = (Monthuthach) session.getAttribute("monhoc");
%>

<body style="font-family: monospace">

<jsp:include page="include/menu.jsp"></jsp:include>

<div class="container">
    <div class="col-lg-9" id="hienthi">
        <img id="cauhoi" src="#" width="100%" height="100%">
        <div class="radio" style="text-align: center">
            <label><input type="radio" name="optradio" value="A"><b id="lba">Đáp án A</b></label> <hr>
            <label><input type="radio" name="optradio" value="B"><b id="lbb">Đáp án B</b></label> <hr>
            <label><input type="radio" name="optradio" value="C"><b id="lbc">Đáp án C</b></label> <hr>
            <label><input type="radio" name="optradio" value="D"><b id="lbd">Đáp án D</b></label>
        </div>
        <div align="center">
            <button style="" id="next" class="btn bg-primary"><span class="glyphicon glyphicon-saved"></span> Next
            </button>
        </div>
    </div>

    <div class="col-lg-9" id="giaithich">
        <pre style="font-size: medium">
            - Chào mừng bạn đến với hệ thống các bài trắc nghiệm
            - Có 2 chế độ trong hệ thống:
                + bạn sẽ bị loại nếu như sai 1 câu trong lúc trả lời
                + bạn sẽ trả lời 20 câu liên tiếp rồi tính điểm.
            - Mặc định là chế độ thứ nhất. Và bạn sẽ không thay đổi được nó.
            - Chế độ 2 chỉ dành cho các trường hợp đặt biệt
            - Chọn câu trả lời đúng nhất và nhấn next.
            - Bạn có 15 phút để hoàn thành ở cả 2 chế độ.
            - Chụp ảnh màn hình lại câu không chắc chắn để có thể xem lại nó.
            - Hệ thống sẽ không cho các bạn làm lại các câu mà các bạn đã thấy.
            - Bạn có thể xóa đi bộ nhớ các câu đã làm ở Profile
            - Chú ý rằng điểm sẽ được cập nhật sau khi bạn hoàn tất.
            - Reload sẽ mất điểm các câu đã làm và không gặp lại nó nữa
            - Nếu muốn kết thúc thì bạn nhấn vào finish.
            - Mọi thắc mắc về đáp án xin liên hệ tôi.
            - Nào! Nhấn vào start và bắt đầu nào.
        </pre>
        <h3 style="color: red">${thongbao}</h3><br>
    </div>


    <div class="col-lg-3" style="padding-top: 10px">
        <div class="panel panel-primary">
            <div class="panel-heading">Information challenges</div>
            <div class="panel-body">
                <p title="Time remaining of the challenges">Time remaining: <b style="color: #1C005A;float: right"
                                                                               id="remaining">15p</b></p>
                <p title="Type of challenges">T - c: <b style="color: red;float: right"
                                                        id="typechallenges"><%=maMonHoc.getTenmonhoc()%>
                </b></p>
                <p title="Question current">Question current: <b style="color: red;float: right"
                                                                 id="question-current"></b>
                </p>
                <p title="Status current">Status: <b id="status" style="float: right">Waiting</b></p>
                <p title="Type of answer the question">Type: <b style="color: red;float: right"
                                                                id="type"><%=taikhoan.getLoaithuthach()%>
                </b></p>
                <p title="Username of you">Username: <b style="color: red;float: right"
                                                        id="username"><%=taikhoan.getUsername()%>
                </b></p>
                <p title="Time of challenges">Time: <b style="float: right" id="time">15 minutes</b></p>
                <p title="Number question success">Success: <b style="float: right" id="success">0</b></p>
                <p title="Score for you">Score: <b style="float: right" id="score"><%=taikhoan.getDiemthuthach()%>
                </b></p>
                <p title="Level for you and for question">Level: <b style="color: red;float: right"
                                                                    id="level"><%=taikhoan.getLevel()%>
                </b>
                </p>
                <button id="start" class="btn btn-primary">Start</button>
                <button id="finish" class="btn btn-danger">Finish</button>
            </div>
        </div>
    </div>

</div>

<div class="footer">Trường Đại học Nông Lâm thành phố Hồ Chí Minh.</div>
</body>
</html>
<%}%>