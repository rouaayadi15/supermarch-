package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import model.user;
import service.UserService;

@WebServlet("/user")
public class UserController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException {

        String action = req.getParameter("action");

        UserService service = new UserService();

        // 🔹 REGISTER
        if ("register".equals(action)) {

            user u = new user();

            u.setNom(req.getParameter("nom"));
            u.setPrenom(req.getParameter("prenom"));
            u.setTel(req.getParameter("tel"));
            u.setEmail(req.getParameter("email"));
            u.setAdresse(req.getParameter("adresse"));

            service.register(u);

            res.sendRedirect("login.jsp");
        }

        // 🔹 LOGIN
        else if ("login".equals(action)) {

            String email = req.getParameter("email");
            String tel = req.getParameter("tel");

            boolean ok = service.login(email, tel);

            if (ok) {
                HttpSession session = req.getSession();
                session.setAttribute("idUser", 1); // demo

                res.sendRedirect("home.jsp");
            } else {
                res.sendRedirect("login.jsp?error=1");
            }
        }
    }
}