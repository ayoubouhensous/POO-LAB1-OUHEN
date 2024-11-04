public class Evaluateur {

    public Evaluateur(){};

    public void verifierNote(int note) throws NoteInvalideException{
        if(note < 0 || note > 20){
            throw new NoteInvalideException(note);
        }
    }

    public static void main(String[] args) {
        Evaluateur e = new Evaluateur();
        try {
            e.verifierNote(15);
        }catch (NoteInvalideException ex){
            System.out.println(ex.getMessage());
        }
        try {
            e.verifierNote(25);
        }catch (NoteInvalideException ex){
            System.out.println(ex.getMessage());
        }
    }
}
