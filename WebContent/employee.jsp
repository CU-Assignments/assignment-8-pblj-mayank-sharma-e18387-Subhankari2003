<%@ page import="java.sql.*" %>
<html>
<head><title>Employee List</title></head>
<body>
<h2>Employees</h2>
<%
    Connection conn = DBConnection.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
    while(rs.next()) {
        out.println(rs.getInt("id") + ": " + rs.getString("name") + " (" + rs.getString("department") + ")<br>");
    }
%>
</body>
</html>