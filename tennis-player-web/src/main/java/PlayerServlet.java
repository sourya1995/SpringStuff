import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/player.do")
public class PlayerServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html>");
		 * out.println("<head>" + "<title>Player DB</title>" + "</head>");
		 * out.println("<body>" + "<H2>Welcome to the Tennis Players Database!</H2>" +
		 * "</body>"); out.println("</html>");
		 */
		
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		
		
	}
	private PlayerService service = new PlayerService();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html>");
		 * out.println("<head>" + "<title>Player DB</title>" + "</head>");
		 * out.println("<body>" + "<H2>Welcome to the Tennis Players Database!</H2>" +
		 * "</body>"); out.println("</html>");
		 */
		String playerName = request.getParameter("name");
		Player player = service.getPlayerByName(playerName);
		request.setAttribute("name", playerName);
		request.setAttribute("country", player.getNationality());
		request.setAttribute("dob", player.getBirthdate());
		request.setAttribute("titles", player.getTitles());
		request.getRequestDispatcher("/WEB-INF/views/info.jsp").forward(request, response);
		
		
	}
	
	
}
