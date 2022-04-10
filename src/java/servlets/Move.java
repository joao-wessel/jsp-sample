package servlets;

import dao.StatisticsDao;
import entities.LastMatch;
import entities.Player;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Move", urlPatterns = {"/move"})
public class Move extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Player loggedPlayer = (Player) getServletContext().getAttribute("loggedPlayer");
        StatisticsDao statisticsDao = (StatisticsDao) getServletContext().getAttribute("StatisticsDao");

        int playerMove = Integer.parseInt(request.getParameter("player-move"));
        int computerMove = computerChoice();
        int match = winner(playerMove, computerMove);

        statisticsDao.updateStatistics(loggedPlayer, match);

        LastMatch lastMatch = new LastMatch(playerMove, computerMove, match);

        getServletContext().setAttribute("lastMatch", lastMatch);

        response.sendRedirect("statistics.jsp");
    }

    public int computerChoice() {
        Random random = new Random();
        int move = random.nextInt(3) + 1;
        return move;
    }

    public int winner(int playerMove, int computerMove) {
        int result;
        if (playerMove == 1 && computerMove == 3 || playerMove == 2 && computerMove == 1
                || playerMove == 3 && computerMove == 2) {

            result = 1;
        } else if (computerMove == 1 && playerMove == 3 || computerMove == 2 && playerMove == 1
                || computerMove == 3 && playerMove == 2) {

            result = 0;

        } else {
            result = 3;
        }
        return result;
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