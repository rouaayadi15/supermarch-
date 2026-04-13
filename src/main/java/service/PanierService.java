package service;
import java.util.List;
import dao.panierDAO;

public class PanierService {

    panierDAO dao = new panierDAO();
    public void addToCart(int idUser, int idProduit, int quantity) {
        dao.addToCart(idUser, idProduit, quantity);
    }

    public List<Object[]> getCart(int idUser) {
        return dao.getCartByUser(idUser);
    }

    public void deleteItem(int idUser, int idProduit) {
        dao.deleteItem(idUser, idProduit);
    }

    public void updateQuantity(int idUser, int idProduit, int quantity) {
        dao.updateQuantity(idUser, idProduit, quantity);
    }

    public double getTotal(int idUser) {
        return dao.getTotal(idUser);
    }

    public void clearCart(int idUser) {
        dao.clearCart(idUser);
    }
}