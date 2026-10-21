import java.util.Scanner;

public class SoftwareTesting {
    public static void main(String... ignored) {
        var scan = new Scanner(System.in);
        try {
            System.out.print("Scor țintă (int): ");
            var targetScore = scan.nextInt();
            System.out.print("Număr maxim de jocuri (int): ");
            var maxPlays = scan.nextInt();
            System.out.print("Se pot folosi jocuri de două puncte (bool): ");
            var allowTwoPointPlay = scan.nextBoolean();
            System.out.println(ScoreChecker.check(targetScore, maxPlays, allowTwoPointPlay));
        } catch (Exception e) {
            System.out.println("Eroare " + e.getMessage());
        }
    }
}
