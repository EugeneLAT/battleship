package lv.tsi.battleship;

import lv.tsi.battleship.model.*;

import javax.inject.Inject;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    @Inject
    private MyGame myGame;
    @Inject
    private ErrorHolder errorHolder;
    @Inject
    private GameManager gameManager;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String nick = request.getParameter("nickname");
        if(nick == null || nick.isBlank()){
            errorHolder.setMessage("User name is required");
            doGet(request, response);
            return;
        }

        User user = new User();
        user.setName(nick);
        myGame.setUser(user);

        Game game = gameManager.setupGame(user);
        myGame.setGame(game);

        if (game.isCompleted()){
            response.sendRedirect("/battleship/shipplacement");
        }else{
            response.sendRedirect("/battleship/waitregistration");
        }

        response.sendRedirect("/battleship/waitregistration");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/registration.jsp").include(request, response);

    }
}
