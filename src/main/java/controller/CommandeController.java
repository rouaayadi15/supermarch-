package controller;
hello
import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/commande")
public class CommandeController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException {

        double total = 100; 

        if (req.getParameter("etudiant") != null) {
            total = total - (total * 0.15);
        }

        String coupon = req.getParameter("coupon");

        if (coupon != null && coupon.equals("PROMO10")) {
            total = total - 10;
        }

        System.out.println("TOTAL FINAL = " + total);

        res.sendRedirect("success.jsp");
    }
}
