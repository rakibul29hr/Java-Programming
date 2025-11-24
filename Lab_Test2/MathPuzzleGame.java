
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MathPuzzleGame {

    // Define file names constants
    private static final String QUESTIONS_FILE = "questions.txt";
    private static final String SCORE_FILE = "score_history.txt";

    /**
     * Inner class to represent a single math question structure.
     */
    static class Question {
        int operand1;
        char operator;
        int operand2;
        int correctAnswer;

        public Question(int op1, char operator, int op2, int ans) {
            this.operand1 = op1;
            this.operator = operator;
            this.operand2 = op2;
            this.correctAnswer = ans;
        }

        // Formats the question for display (e.g., "3 + 4 = ?")
        public String getQuestionString() {
            return operand1 + " " + operator + " " + operand2 + " = ?";
        }
    }
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        String playerName;
        String difficultyStr;
        int difficultyMultiplier = 1;
        int totalScore = 0;

        System.out.println("=============================");
        System.out.println("Welcome to the Math Puzzle!");
        System.out.println("=============================");

        // 1. Get Player Info from Console
        System.out.print("Enter your name: ");
        playerName = consoleScanner.nextLine();

        boolean validDifficulty = false;
        while (!validDifficulty) {
            System.out.print("Choose difficulty (easy, medium, hard): ");
            difficultyStr = consoleScanner.nextLine().toLowerCase();

            switch (difficultyStr) {
                case "easy":
                    difficultyMultiplier = 1; // 1 point per correct answer
                    validDifficulty = true;
                    break;
                case "medium":
                    difficultyMultiplier = 2; // 2 points per correct answer
                    validDifficulty = true;
                    break;
                case "hard":
                    difficultyMultiplier = 3; // 3 points per correct answer
                    validDifficulty = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please type 'easy', 'medium', or 'hard'.");
            }
        }

        System.out.println("\nStarting quiz for " + playerName + ". Good luck!\n");

        try {
            // 2. Read Questions from Input File
            List<Question> questionsList = loadQuestionsFromFile(QUESTIONS_FILE);

            if (questionsList.isEmpty()) {
                System.out.println("Error: No questions found in " + QUESTIONS_FILE);
                return; // Exit if no questions loaded
            }

            // 3. The Game Loop
            int questionCount = 1;
            for (Question q : questionsList) {
                System.out.print("Q" + questionCount + ": " + q.getQuestionString() + " ");

                // Validate input to ensure they enter a number
                while (!consoleScanner.hasNextInt()) {
                    System.out.println("That's not a number! Try again.");
                    System.out.print("Q" + questionCount + ": " + q.getQuestionString() + " ");
                    consoleScanner.next(); // consume bad input
                }
                int playerAnswer = consoleScanner.nextInt();

                if (playerAnswer == q.correctAnswer) {
                    System.out.println("Correct! (+" + difficultyMultiplier + " points)");
                    totalScore += difficultyMultiplier;
                } else {
                    System.out.println("Wrong. The answer was " + q.correctAnswer + ".");
                }
                questionCount++;
            }

            System.out.println("\n=============================");
            System.out.println("Game Over!");
            System.out.println("Final Score: " + totalScore);
            System.out.println("=============================");

            // 4. Save Score to Output File
            saveScoreToFile(playerName, totalScore, difficultyMultiplier);

        } catch (FileNotFoundException e) {
            System.err.println("CRITICAL ERROR: The input file '" + QUESTIONS_FILE + "' was not found.");
            System.err.println("Please ensure questions.txt is in the project root directory.");
        } catch (IOException e) {
            System.err.println("An error occurred while performing file I/O: " + e.getMessage());
        } finally {
            consoleScanner.close();
        }
    }

    /**
     * Reads questions from the specified text file.
     * Assumes file format: Operand1 Operator Operand2 CorrectAnswer (e.g., "3 + 4 7")
     */
    private static List<Question> loadQuestionsFromFile(String fileName) throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Use a separate scanner to parse the specific line structure
            Scanner lineScanner = new Scanner(line);

            if (lineScanner.hasNextInt()) {
                int op1 = lineScanner.nextInt();
                char operator = lineScanner.next().charAt(0);
                int op2 = lineScanner.nextInt();
                int ans = lineScanner.nextInt();
                questions.add(new Question(op1, operator, op2, ans));
            }
            lineScanner.close();
        }
        fileScanner.close();
        return questions;
    }

    /**
     * Appends the player's score to the score history file with a timestamp.
     */
    private static void saveScoreToFile(String name, int score, int multiplier) throws IOException {
        // Use try-with-resources to ensure the writer closes automatically.
        // The 'true' argument in FileWriter constructor enables APPEND mode.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            String difficultyLabel = (multiplier == 1) ? "Easy" : (multiplier == 2) ? "Medium" : "Hard";

            String scoreEntry = String.format("[%s] Player: %-10s | Difficulty: %-6s | Score: %d",
                    dtf.format(now), name, difficultyLabel, score);

            writer.write(scoreEntry);
            writer.newLine(); // Add a new line for the next entry
            System.out.println("Score successfully saved to " + SCORE_FILE);
        }
    }


}
