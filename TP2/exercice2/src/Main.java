public class Main {
    public static void main(String[] args) {

        Ingenieur ingenieur=new Ingenieur("ayoub","ouhen","email@gmail.com","0606060606",10000,"specialite11");

        Manager manager=new Manager("zakaria","elg","ayoub@gmail.com","0612345678",15000,"service1");

        System.out.println(ingenieur.toString());

        System.out.println(manager.toString());


    }
}