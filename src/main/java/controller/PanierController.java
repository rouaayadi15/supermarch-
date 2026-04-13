package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import service.PanierService;

@WebServlet("/addCart")
public class PanierController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException {

        int idProduit = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        HttpSession session = req.getSession();
        Integer idUser = (Integer) session.getAttribute("idUser");

        if (idUser == null) {
            idUser = 1; 
        }

        PanierService service = new PanierService();
        service.addToCart(idUser, idProduit, quantity);

        res.sendRedirect("panier");
    }
}