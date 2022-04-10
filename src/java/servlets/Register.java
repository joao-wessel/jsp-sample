package servlets;

import dao.StatisticsDao;
import entities.Player;
import entities.Statistics;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("player-name");

        Player loggedPlayer = new Player(name);
        Statistics playerStatistics = new Statistics();
        StatisticsDao statisticsDao = (StatisticsDao) getServletContext().getAttribute("StatisticsDao");

        if (statisticsDao == null) {
            getServletContext().setAttribute("StatisticsDao", new StatisticsDao());
            statisticsDao = (StatisticsDao) getServletContext().getAttribute("StatisticsDao");
        }

        statisticsDao.newStatistics(loggedPlayer, playerStatistics);

        getServletContext().setAttribute("loggedPlayer", loggedPlayer);

        response.sendRedirect("move.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}