import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveAttendance")
public class SaveAttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)");
            ps.setInt(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.executeUpdate();
            response.sendRedirect("attendance-success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}