
class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}


class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }


    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        Passenger current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Penumpang " + name + " tidak ditemukan.");
    }


    public void displayPassengers() {
        if (head == null) {
            System.out.println("=======================");
            System.out.println("Daftar penumpang kosong.");
            System.out.println("=======================");
        } else {
            System.out.println("================");
            System.out.println("Daftar Penumpang:");
            System.out.println("================");
            Passenger current = head;
            while (current != null) {
                System.out.println(current.name);
                current = current.next;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.addPassenger("Udin");
        flight.addPassenger("Asep");
        flight.addPassenger("Siti");
        flight.addPassenger("Ujang");
        flight.addPassenger("Doni");

        flight.displayPassengers();

        flight.removePassenger("Asep");
        System.out.println("============================================");
        System.out.println("Asep telah dihapus dari daftar penumpang:");
        System.out.println("============================================");
        flight.displayPassengers();
        System.out.println("================================");
        flight.removePassenger("Ayu");
        System.out.println("================================");
    }
}
