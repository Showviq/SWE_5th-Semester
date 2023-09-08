public class Main{
    public static <String> void main(String[] args){
        Footballer footballer = new Footballer();
        Cricketer cricketer = new Cricketer();

        System.out.println("Footballer's Routine:");
        footballer.Play();

        System.out.println("\nCricketer's Routine:");
        cricketer.Play();
    }
}

