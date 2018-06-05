package Collections;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow= 'A' + (numRows -1);
        for(char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum ++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }

        }
    }//end of contructor

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveseat(String seatNumber){
        Seat requestSeat = null;
        for (Seat seat: seats){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestSeat = seat;
                break;
            }
        }

        if(requestSeat == null){
            System.out.println(("there's no seat: " + seatNumber));
            return false;
        }
        return requestSeat.reserve();
    }
    //for testing
    public void getSeats(){
        for (Seat  seat : seats){
            System.out.println(seat.getSeatNumber());
        }

    }
private class Seat{
        private final String seatNumber;
        private boolean reserved = false;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean reserve(){
        if(this.reserved == false){
            setReserved(true);
            System.out.println("Seat " + seatNumber + " reserved");
            return true;
        }else{
            return false;
        }
    }
    public boolean cancel(){
        if(this.reserved){
            this.reserved = false;
            System.out.println("Reservation of seat " + seatNumber +" cancelled");
            return true;
        }else{
            return false;
        }

    }

}
}

