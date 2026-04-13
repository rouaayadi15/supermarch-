package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import service.PanierService;

@WebServlet("/panier")
public class PanierViewController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        HttpSession session = req.getSession();
        Integer idUser = (Integer) session.getAttribute("idUser");

        if (idUser == null) {
            idUser = 1;
        }

        PanierService service = new PanierService();

        List<Object[]> cart = service.getCart(idUser);
        double total = service.getTotal(idUser);

        req.setAttribute("cart", cart);
        req.setAttribute("total", total);

        req.getRequestDispatcher("jsp/panier.jsp").forward(req, res);
    }
}