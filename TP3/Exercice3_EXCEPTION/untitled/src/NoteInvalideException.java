public class NoteInvalideException extends Exception{

    public NoteInvalideException(int entier){
        super("Exception de type NoteInvalideException. Note invalide : " + entier);
    }
}
