import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExtraCurricular2 {
    private static final int MAX_ENTRIES = 100;

    public static void main(String[] args) {
        String[] sports = new String[MAX_ENTRIES];
        String[] extraCurriculars = new String[MAX_ENTRIES];

        int sportsCount = readFile("IMSports.txt", sports);
        int extraCurricularCount = readFile("ExtraCurricular.txt", extraCurriculars);

        while (true) {
            int choice = getUserChoice();
            if (choice == 1) {
                displayActivities("Extra Curricular Activities", extraCurriculars, extraCurricularCount);
            } else if (choice == 2) {
                displayActivities("Intramural Sports", sports, sportsCount);
            } else if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice, Please choose again.");
            }
        }
    }

    public static int readFile(String filename, String[] activities) {
        int count = 0;
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine() && count < MAX_ENTRIES) {
                activities[count++] = scanner.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return count;
    }

    public static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to know the Extra Curricular Activities (1), Intramural Sports (2), or Exit (0)?");
        return scanner.nextInt();
    }

    public static void displayActivities(String activityType, String[] activities, int count) {
        System.out.println(activityType + ":");
        for (int i = 0; i < count; i++) {
            System.out.println(activities[i]);
        }
    }
}
