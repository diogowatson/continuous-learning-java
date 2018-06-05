package Collections;

public class Main {
    public static void main(String[] argv){
        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();

        if(theatre.reserveseat("H11")){
            System.out.println("Please pay");

        }else{
            System.out.println("Sorry, seat is taken");
        }
        if(theatre.reserveseat("H11")){
            System.out.println("Please pay");

        }else{
            System.out.println("Sorry, seat is taken");
        }

    }
}
