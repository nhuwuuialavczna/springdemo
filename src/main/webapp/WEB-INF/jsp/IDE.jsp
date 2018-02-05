<%@ page import="com.chamcode.model.Baitapcode" %><%--
  Created by IntelliJ IDEA.
  User: Hau
  Date: 1/29/2018
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%><% if (session.getAttribute("taikhoan") == null) {
    response.sendRedirect("/");
}else{%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>IDE</title>
    <!--<link rel="stylesheet" href="css/main.css">-->
    <link rel="stylesheet" href="../boostrap/css/bootstrap.css">
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../boostrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../editor/doc/docs.css">
    <link rel="stylesheet" href="../editor/lib/codemirror.css">
    <link rel="stylesheet" href="../editor/lib/footer.css">
    <%--<script src="../boostrap/js/bootstrap.js"></script>--%>
    <!-- styles the fullscreen and search features -->
    <link rel="stylesheet" href="../editor/addon/display/fullscreen.css">
    <link rel="stylesheet" href="../editor/addon/dialog/dialog.css">

    <!-- our primary themes list -->
    <link rel="stylesheet" href="../editor/theme/ambiance.css">
    <link rel="stylesheet" href="../editor/theme/eclipse.css">
    <link rel="stylesheet" href="../editor/theme/midnight.css">
    <link rel="stylesheet" href="../editor/theme/monokai.css">
    <link rel="stylesheet" href="../editor/theme/night.css">

    <!-- essential scripts for functionality -->
    <script src="../editor/lib/codemirror.js"></script>
    <script src="../editor/mode/javascript/javascript.js"></script>
    <script src="../editor/keymap/extra.js"></script>
    <script src="../editor/addon/selection/active-line.js"></script>
    <script src="../editor/addon/edit/matchbrackets.js"></script>
    <script src="../editor/addon/edit/closebrackets.js"></script>
    <script src="../editor/mode/xml/xml.js"></script>
    <script src="../editor/addon/display/fullscreen.js"></script>
    <script src="../editor/addon/search/search.js"></script>
    <script src="../editor/addon/search/searchcursor.js"></script>
    <script src="../editor/addon/dialog/dialog.js"></script>
    <!--<script type="text/javascript" src="js/caretposition.js"></script>-->
    <!-- styles and scripts for things like slider tab -->
    <script src="../editor/lib/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="../editor/lib/clike.js"></script>
    <script src="../editor/lib/slideout.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.slide-out-div').tabSlideOut(
                {
                    /* ©2009 William Paoli */
                    tabHandle: '.handle',                     //class of the element that will become your tab
                    pathToTabImage: './editor/images/tab.png',//path to the image for the tab //Optionally can be set using css
                    imageHeight: '137px',                     //height of tab image           //Optionally can be set using css
                    imageWidth: '35px',                       //width of tab image            //Optionally can be set using css
                    tabLocation: 'right',                     //side of screen where tab lives, top, right, bottom, or left
                    speed: 300,                               //speed of animation
                    action: 'click',                          //options: 'click' or 'hover', action to trigger animation
                    topPos: '20px',                           //position from the top/ use if tabLocation is left or right
                    leftPos: '20px',                          //position from left/ use if tabLocation is bottom or top
                    fixedPosition: true                       //options: true makes it stick (fixed position) on scroll
                });
        });
    </script>
    <style type="text/css">
        .slide-out-div {
            padding: 5px;
            width: 375px;
            background: #EDEDED;
            border: 2px solid #FF7519;
            z-index: 2; /* hack for IE's unclickable tabSlideOut*/
        }

    </style>

    <script>

        $(document).ready(function () {
            $("#run").on('click', function () {
                $("#play").submit();
            });
        });

    </script>
    <%
        if (session.getAttribute("taikhoan") == null) {
            response.sendRedirect("/");
        }
    %>
</head>
<%
    Baitapcode baitapcode = (session.getAttribute("baicodehientai") != null) ? (Baitapcode) session.getAttribute("baicodehientai") : null;
    if (baitapcode == null) response.sendRedirect("/");
%>
<body style="font-family: monospace">
<jsp:include page="include/menu.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div id="viewexercise">
                <p>
                <h3 style="text-align: center" id="mabaicode"><%=baitapcode.getMabaicode()%>
                    . <%=baitapcode.getTenbaicode()%>
                </h3></p>
                <hr>

                <p id="noidung"><%=baitapcode.getNoidung()%>
                </p>
                <hr>

                <p>
                <h3>Input: </h3><h4 id="input"><%=baitapcode.getInput()%>
            </h4></p>
                <p>
                <h3>Output: </h3><h4 id="output"><%=baitapcode.getOutput()%>
            </h4></p>
                <hr>

                <h3 style="text-align: center">Example</h3>
                <p>
                <h3>Input: </h3><h4 id="inputvidu"><%=baitapcode.getInputvidu()%>
            </h4></p>
                <p>
                <h3>Output: </h3><h4 id="outputvidu"><%=baitapcode.getOutputvidu()%>
            </h4></p>
            </div>
        </div>


        <div class="col-sm-8">
            <form action="/IDE/ChamDiem" method="post" id="play">
                <textarea name="code"
                          id="code">${code}</textarea>
            </form>
            <br>
            <label for="select">Select theme</label>
            <select name="themeset" class="form-control" onchange="selectTheme()" id="select">
                <option>ambiance</option>
                <option>eclipse</option>
                <option>midnight</option>
                <option>monokai</option>
                <option>night</option>
            </select><br>
            <div id="debug">
                <button id="run" class="btn btn-info"><span class="glyphicon glyphicon-play"></span> Run</button>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <h3>Result:</h3>
                    <p id="re">${thongbao}</p>
                </div>
            </div>
        </div>

    </div>

</div>
<div style="background-color: black;color: white;padding: 1rem;text-align: center" class="footer">Trường Đại học Nông
    Lâm thành phố Hồ Chí Minh.
</div>
</body>


<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    // disable various key functions
    $(document).on("keypress", 'form', function (e) {
        var mykeycode = e.keyCode || e.which;
        if (mykeycode == 13) { // ENTER --> form submit
            e.preventDefault();
            return false;
        }
        /* BUG: PREVENTS 'r' FROM FIRING!
        if (mykeycode == 114) { // F3 --> document search
            e.preventDefault();
            return false;
        }
        */
    });
    editor = CodeMirror.fromTextArea(document.getElementById("code"), {
        lineNumbers: true,
        styleActiveLine: true,
        matchBrackets: true,
        mode: "text/x-java",
        extraKeys: {
            "F12": function (cm) {
                cm.setOption("fullScreen", !cm.getOption("fullScreen"));
                editor.refresh();
            },
            "F11": function () {
                if ((document.fullScreenElement && document.fullScreenElement !== null) ||
                    (!document.mozFullScreen && !document.webkitIsFullScreen)) {
                    if (document.documentElement.requestFullScreen) {
                        document.documentElement.requestFullScreen();
                    } else if (document.documentElement.mozRequestFullScreen) {
                        document.documentElement.mozRequestFullScreen();
                    } else if (document.documentElement.webkitRequestFullScreen) {
                        document.documentElement.webkitRequestFullScreen(Element.ALLOW_KEYBOARD_INPUT);
                    }
                }
                else {
                    if (document.cancelFullScreen) {
                        document.cancelFullScreen();
                    } else if (document.mozCancelFullScreen) {
                        document.mozCancelFullScreen();
                    } else if (document.webkitCancelFullScreen) {
                        document.webkitCancelFullScreen();
                    }
                }
                editor.refresh();
            },
            "F4": function () {
                openApplet();
            },
            "F3": function () {
                getImportPaste();
            },
            "F2": function () {
                // document.forms[0].submit();
                postForCompile();
            }
        }
    });
    // clear editor on CTRL+K combination
    var map = [];
    onkeydown = onkeyup = function (e) {
        e = e || event;
        map[e.keyCode] = e.type == 'keydown';
        if (map[17] && map[75]) {
            editor.value = '';
        }
    };
    var input = document.getElementById("select");

    function selectTheme() {
        var theme = input.options[input.selectedIndex].innerHTML;
        editor.setOption("theme", theme);
    }

    //var choice = document.location.search && decodeURIComponent(document.location.search.slice(1));
    var theme = input.options[input.selectedIndex].innerHTML;
    if (theme) {
        input.value = theme;
        editor.setOption("theme", theme);
    }
    //use all available space
    var browserHeight = document.documentElement.clientHeight;
    editor.getWrapperElement().style.height = (browserHeight - (210 + 10)) + 'px';
    editor.refresh();
    window.onresize = function () {
        var browserHeight = document.documentElement.clientHeight;
        editor.getWrapperElement().style.height = (browserHeight - (210 + 10)) + 'px';
        editor.refresh();
    };
    // if we have some kind of error message
    if (typeof(data.errormsg) != "undefined") {
        alert(data.errormsg);
    }

    function getImportPaste() {
        window.importme = prompt("Import a Gist URL?");
        if (window.importme) {
            $.post("index.html", {
                    'code': editor.doc.getValue(),
                    'passargs': $('input:text[name=passargs]').val(),
                    'importme': window.importme,
                    'respond': 'respond'
                },
                function (data) {
                    window.clearInterval(waiting);
                    $("#buildout").val(data.buildout);
                    $("#execsout").val(data.execsout);
                    window.webapple = data.webapple;
                    window.noinputs = data.noinputs;
                }
            );
            $("#buildout").val("importing");
            $("#execsout").val("validating");
            waiting = setInterval(function () {
                $("#buildout").val($("#buildout").val() + ".");
                $("#execsout").val($("#execsout").val() + ".");
            }, 500);
        }
    }

    function postForCompile() {
        $.post("index.html", {
                'code': editor.doc.getValue(),
                'passargs': $('input:text[name=passargs]').val(),
                'respond': 'respond'
            },
            function (data) {
                window.clearInterval(waiting);
                $("#buildout").val(data.buildout);
                $("#execsout").val(data.execsout);
                window.webapple = data.webapple;
                window.noinputs = data.noinputs;
            }
        );
        $("#buildout").val("compiling");
        $("#execsout").val("executing");
        waiting = setInterval(function () {
            $("#buildout").val($("#buildout").val() + ".");
            $("#execsout").val($("#execsout").val() + ".");
        }, 500);
    }

    function postForPaste() {
        $.post("index.html", {
                'code': editor.doc.getValue(),
                'paste': 'paste'
            },
            function (data) {
                window.clearInterval(waiting);
                $("#buildout").val(data.buildout);
                $("#execsout").val(data.execsout);
            }
        );
        $("#buildout").val("pasting code to server");
        $("#execsout").val("waiting for response");
        waiting = setInterval(function () {
            $("#buildout").val($("#buildout").val() + ".");
            $("#execsout").val($("#execsout").val() + ".");
        }, 250);
        delete window.webapple;
    }

    function textForDownload() {
        $("#buildout").val("compiling");
        $("#execsout").val("packaging");
        waiting = setInterval(function () {
            $("#buildout").val($("#buildout").val() + ".");
            $("#execsout").val($("#execsout").val() + ".");
        }, 500);
        setTimeout(function () {
            clearInterval(waiting);
            $("#buildout").val("Successfully created .zip archive for download.");
            $("#execsout").val("If no .class or .jar files exist then program did not compile!");
        }, 2000);
        delete window.webapple;
    }

    function openApplet() {
        if (typeof window.webapple != 'undefined' && window.webapple != '') {
            window.open(window.webapple, window.webapple, "width=800, height=600");
        }
    }
</script>

</html>
<%}%>