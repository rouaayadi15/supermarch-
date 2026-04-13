package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.panier;
import model.produit;
import util.DBConnection;
public class panierDAO {
    public void addToCart(int idUser, int idProduit, int quantity) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO panier(id_user,id_produit,quantity) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUser);
            ps.setInt(2, idProduit);
            ps.setInt(3, quantity);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Object[]> getCartByUser(int idUser) {

        List<Object[]> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT p.nom, p.prix, pa.quantity, p.id " +
                "FROM panier pa " +
                "JOIN produit p ON pa.id_produit = p.id " +
                "WHERE pa.id_user=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUser);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String nom = rs.getString(1);
                double prix = rs.getDouble(2);
                int qty = rs.getInt(3);
                int idProduit = rs.getInt(4);

                Object[] row = { nom, prix, qty, idProduit };

                list.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteItem(int idUser, int idProduit) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM panier WHERE id_user=? AND id_produit=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idUser);
            ps.setInt(2, idProduit);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateQuantity(int idUser, int idProduit, int quantity) {

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "UPDATE panier SET quantity=? WHERE id_user=? AND id_produit=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, idUser);
            ps.setInt(3, idProduit);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getTotal(int idUser) {

        double total = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT p.prix, pa.quantity " +
                "FROM panier pa " +
                "JOIN produit p ON pa.id_produit = p.id " +
                "WHERE pa.id_user=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUser);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double prix = rs.getDouble(1);
                int qty = rs.getInt(2);

                total += prix * qty;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public void clearCart(int idUser) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM panier WHERE id_user=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUser);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}