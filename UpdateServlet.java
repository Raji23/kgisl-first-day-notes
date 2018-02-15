import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {


	private String id;
	private String name;
	private String description;
	private String quantity;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String myid= request.getParameter("id");

        
        try{
          
        Class.forName("com.mysql.jdbc.Driver");
         
                  Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"book","root","");
                             PreparedStatement statement;        
                             String query ="UPDATE listproduct SET id=?,name=?,description=?,quantity=?where id="+myid;
                             statement = con.prepareStatement(query);
                             statement.setString(1, id);
                             statement.setString(2, name);
                             statement.setString(3, description);
                             statement.setString(4, quantity);
                             int i=statement.executeUpdate();
                             out.println(i);
                          if(i>0)
                          {
                            out.println("You are sucessfully updated");
                            
                          }
                          

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
    }

}