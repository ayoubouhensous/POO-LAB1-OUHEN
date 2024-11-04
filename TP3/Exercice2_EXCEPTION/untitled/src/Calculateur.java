public class Calculateur {

    public Calculateur(){};

    public void testRacineCarree(int entier) throws RacineCarreeException{

        if(entier<0){
            throw new RacineCarreeException(entier);
        }
    }

    public static void main(String[] args) {


        Calculateur cal = new Calculateur();
        try {
            cal.testRacineCarree(-85);
        }catch(RacineCarreeException e){
            e.printStackTrace();
        }
        try {
            cal.testRacineCarree(-5);
        }catch(RacineCarreeException e){
            e.printStackTrace();
        }


    }
}
