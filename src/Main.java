import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Testing:");
        System.out.println("1. List");
        System.out.println("2. Set");
        System.out.println("3. Queue");
        System.out.println("4. Map");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ListCollections listCollections = new ListCollections();
                listCollections.listTest();
                break;
            case 2:
                SetCollections setCollections = new SetCollections();
                setCollections.setTest();
                break;
            case 3:
                QueueCollections queueCollections = new QueueCollections();
                queueCollections.queueTest();
                break;
            case 4:
                MapCollections mapCollections = new MapCollections();
                mapCollections.mapTest();
                break;
        }
    }
}