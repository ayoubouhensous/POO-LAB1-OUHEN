import java.util.List;

public interface IMetierProduit {

    public void add(Produit p);
    public List<Produit> getAll();
    public List<Produit> findByNom(String nom);
    public Produit findById(long id);
    public void delete(long id);

}
