package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.produit;
import util.DBConnection;
public class produitDAO {
    public List<produit> getByCategory(String categorie) {
        List<produit> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM produit WHERE categorie=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categorie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                produit p = new produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrix(rs.getDouble("prix"));
                p.setCategorie(rs.getString("categorie"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<produit> getAll() {

        List<produit> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM produit";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                produit p = new produit();

                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrix(rs.getDouble("prix"));
                p.setCategorie(rs.getString("categorie"));
                p.setImage(rs.getString("image"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addProduit(produit p) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO produit(nom,prix,categorie,image) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setString(3, p.getCategorie());
            ps.setString(4, p.getImage());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduit(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM produit WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}