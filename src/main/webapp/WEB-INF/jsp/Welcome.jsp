<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="boostrap/css/bootstrap.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script>

        $(document).ready(function () {

            $("#notify").hide();

            $("#login").on('click', function () {
                if ($("#login-username").val().length === 0 || $("#login-password").val().length === 0) {
                    $("#notify-message").html('Username or password is not empty !');
                    $("#notify").show();
                } else {
                    //gọi ajax
                    $("#notify-message").html('Login...');
                    $("#notify-message").css('color', 'blue');
                    $("#notify").show();
                    var username = $("#login-username").val();
                    var password = $("#login-password").val();
                    $.ajax({
                        type: "POST",
                        url: "/Login?username="+username+"&password="+password,
                        contentType: "utf-8",
                        success: function (data) {
                            if(data!='OK'){
                                $("#notify-message").html(data);
                                $("#notify").show();
                            }else{
                                wind
                            }
                        },
                        error:function(err){
                            $("#notify-message").html('There was an error');
                            $("#notify").show();

                        }
                    });

                }

            });


            $("#loginform").on('keydown', function (e) {
                if (e.keyCode === 13) {
                    $("#login").click();
                }
            });

        });

    </script>
    <title>Login</title>
</head>
<body>
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">Require login first</div>
            </div>

            <div style="padding-top:30px" class="panel-body">

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form id="loginform" method="post" action="" class="form-horizontal" role="form">

                    <div style="margin-bottom: 25px" class="input-group" id="username">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="login-username" type="text" class="form-control" name="username" value=""
                               placeholder="username" required>
                    </div>

                    <div style="margin-bottom: 25px" class="input-group" id="password">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="login-password" type="password" class="form-control" name="password"
                               placeholder="password" required>
                    </div>

                    <div style="margin-top:10px" id="notify" class="form-group">
                        <div class="col-sm-12 controls">
                            <p id="notify-message" style="color: red"></p>
                        </div>
                    </div>

                    <div style="margin-top:10px" class="form-group">
                        <div class="col-sm-12 controls">
                            <a id="login" href="#" class="btn btn-success">Login </a>
                        </div>
                    </div>
                </form>


            </div>
        </div>
    </div>
</div>


</body>
</html>
