import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose which part to run:");
            System.out.println("1. Part1");
            System.out.println("2. Part2");
            System.out.println("3. Part3");
            System.out.println("4. Part4 (YouTube Link Finder)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Running Part1:");
                    Part1 part1 = new Part1();
                    part1.testSimpleGene();
                    break;
                case 2:
                    System.out.println("Running Part2:");
                    Part2 part2 = new Part2();
                    part2.testSimpleGene();
                    break;
                case 3:
                    System.out.println("Running Part3:");
                    Part3 part3 = new Part3();
                    part3.testing();
                    break;
                case 4:
                    System.out.println("Running Part4 (YouTube Link Finder):");
                    Part4 part4 = new Part4();
                    part4.findYouTubeLinks(); // Automatically fetches the page
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
