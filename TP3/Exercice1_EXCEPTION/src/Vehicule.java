public class Vehicule {

    public Vehicule(){};

    public void testVitesse(int ent) throws TropViteException{
        if(ent>90){
            throw new TropViteException(ent);
        }
    }

    public static void main(String[] args)  {

        Vehicule v = new Vehicule();

        try {
            v.testVitesse(5);
        }
        catch (TropViteException e){
            System.out.println(e.getMessage());
        }
        try {
            v.testVitesse(95);
        }catch (TropViteException e){
            System.out.println(e.getMessage());
        }
    }
}
