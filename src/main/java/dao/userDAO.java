/*package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.user;
import util.DBConnection;
public class userDAO {
    public void addUser(user u) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO user(nom,prenom,tel,email,adresse) VALUES (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getTel());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getAdresse());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String email, String tel) {

        boolean ok = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM user WHERE email=? AND tel=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, tel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }
}*/