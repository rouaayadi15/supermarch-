package model;
public class panier {
    private int id;
    private int idUser;
    private int idProduit;
    private int quantity;
    public panier() {
    }
    public panier(int id, int idUser, int idProduit, int quantity) {
        this.id = id;
        this.idUser = idUser;
        this.idProduit = idProduit;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}