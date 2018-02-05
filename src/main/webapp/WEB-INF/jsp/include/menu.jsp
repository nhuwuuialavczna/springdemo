<%@ page import="java.util.List" %>
<%@ page import="com.chamcode.model.Monthuthach" %>
<%@ page import="com.chamcode.dao.impl.MonThuThachDAOImpl" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.chamcode.service.MonThuThachService" %>
<%@ page import="com.chamcode.model.Taikhoan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Monthuthach> ds = (List<Monthuthach>) session.getAttribute("dsthuthach");
    Taikhoan taikhoan = (Taikhoan) session.getAttribute("taikhoan");
    String active = (String) session.getAttribute("active");
%>
<nav class="navbar navbar-inverse">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">TrainingCode</a>
    </div>
    <div class="collapse navbar-collapse js-navbar-collapse">
        <ul class="nav navbar-nav">
            <li <%if(active.equals("Introduce")){%>class="active"<%}%>><a href="/Home/Introduce">Introduce</a></li>
            <li <%if(active.equals("Question")){%>class="active"<%}%>><a href="/Home/Question">Question</a></li>
            <li <%if(active.equals("RankChallenges")){%>class="active"<%}%>><a href="/Home/RankChallenges">Ranking challenges</a></li>
            <li <%if(active.equals("RankExercise")){%>class="active"<%}%>><a href="/Home/RankExercise">Ranking exercise</a></li>
            <li <%if(active.equals("Submission")){%>class="active"<%}%>><a href="/Home/Submission">Submission exercise</a></li>
            <li <%if(active.equals("ExercisePage")){%>class="active"<%}%>><a href="/ExercisePage">Exercise</a></li>
            <%--<li><a href="/GoToIDE">Goto IDE</a></li>--%>
            <%if (taikhoan.getThamgiathuthach().equals("1")) {%>
            <li <%if(active.equals("Challenges")){%>class="active"<%}%> class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Challenges
                    <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <%for (Monthuthach monthuthach : ds) {%>
                    <li><a href="/Challenges?mmh=<%=monthuthach.getMamonhoc()%>"><%=monthuthach.getTenmonhoc()%>
                    </a></li>
                    <%}%>
                </ul>
            </li>
            <%}%>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown" <%if(active.equals("Profile")){%>class="active"<%}%>>
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Account
                    <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="/Profile">Profile</a></li>
                    <li><a href="/Profile/Logout">Logout</a></li>
                </ul>
            </li>
        </ul>
    </div><!-- /.nav-collapse -->
</nav>