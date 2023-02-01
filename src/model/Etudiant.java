package library;

public class Etudiant {

    private int id;
    private String nom;

    public Etudiant(int Id, String Nom) {
        this.id = Id;
        this.nom = Nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

}
