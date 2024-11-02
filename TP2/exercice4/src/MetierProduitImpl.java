import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit{
    private List<Produit> produits;

    public MetierProduitImpl() {
        produits = new ArrayList<Produit>();
    }

    @Override
    public void add(Produit p) {
        produits.add(p);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public List<Produit> findByNom(String nom) {
        List<Produit> result = new ArrayList<>();
        for (Produit p : produits) {
            if(p.getNom().toLowerCase().equals(nom.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {

        produits.removeIf(p -> p.getId() == id);
    }
}
