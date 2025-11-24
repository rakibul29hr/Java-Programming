import java.util.Scanner;

public class SimpleQuiz {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int score = 0;


        String[] questions = {
                "What is the chemical symbol for Gold? (e.g., Ag, Au, Fe)",
                "Which is the largest ocean on Earth?",
                "Who wrote the play 'Romeo and Juliet'?",
                "What is the square root of 64?",
                "What is the capital city of France?"
        };

        String[] answers = {
                "Au",
                "Pacific",
                "Shakespeare",
                "8",
                "Paris"
        };

        System.out.println("Welcome to the High School GK Quiz!");
        System.out.println("-----------------------------------");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q" + (i + 1) + ": " + questions[i]);
            System.out.print("Your Answer: ");

            String userAnswer = scanner.nextLine();


            if (userAnswer.trim().equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + answers[i]);
            }
            System.out.println();
        }

        System.out.println("-----------------------------------");
        System.out.println("Quiz Finished!");
        System.out.println("Your final score: " + score + " out of " + questions.length);

        scanner.close();
    }
}