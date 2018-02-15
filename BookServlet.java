import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    // @Resource("jdbc/YourDB") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
    private DataSource dataSource;
    private BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            public List<Book> listAllBook() throws SQLException {
                List<Book> listBook = new ArrayList<>();
                 
                String sql = "SELECT * FROM booklist";
                 
                connect();
                 
                Statement statement = jdbcConnection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                 
                while (resultSet.next()) {
                    int id = resultSet.getInt("book_id");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    float price = resultSet.getFloat("price");
                     
                    Book book = new Book(id, title, author, price);
                    listBook.add(book);
                }
            }
                resultSet.close();
                statement.close();
                 
                disconnect();
                 
            return listBook;
        }
        
    }

        
}

