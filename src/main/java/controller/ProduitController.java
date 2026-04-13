package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import model.produit;
import service.ProduitService;

@WebServlet("/produits")
public class ProduitController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String cat = req.getParameter("cat");

        ProduitService service = new ProduitService();
        List<produit> list = service.getProduitsByCategory(cat);

        req.setAttribute("list", list);

        req.getRequestDispatcher("jsp/produits.jsp").forward(req, res);
    }
}