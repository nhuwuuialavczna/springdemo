<%@ page import="java.util.List" %>
<%@ page import="com.chamcode.model.Baitapcode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Baitapcode> ds = (List<Baitapcode>) session.getAttribute("new-exercise");%>
<%if (ds != null) {%>
<div title="New exercise" class="panel panel-primary">
    <div class="panel-heading">New Excercise</div>
    <div class="panel-body">
        <%for (Baitapcode bt : ds) {%>
        <p><a  title="<%=bt.getTenbaicode()%>" href="/IDE/GoToIDE?mbc=<%=bt.getMabaicode()%>"><%=bt.getMabaicode()%></a> - by <a
          title="<%=bt.getTaikhoanByUsername().getTen()%>"      href="/Profile?username=<%=bt.getUsername()%>"><%=bt.getUsername()%>
        </a></p>
        <%}%>
    </div>
</div>
<%}%>