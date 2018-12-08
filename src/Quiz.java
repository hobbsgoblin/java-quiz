import java.util.Arrays;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

class Quiz {
    private List<String> difficulties = new ArrayList<>(Arrays.asList("easy", "medium", "hard"));
    private String difficultiesString = String.join(", ", difficulties);
    private int questionNumber = 1;
    private int numQuestionsToAsk = 3;
    private Scanner reader = new Scanner(System.in);
    void runQuiz() {
        String greeting = "What difficulty would you like to play at? Enter one of [" + this.difficultiesString + "]";
        System.out.println(greeting);
        String difficulty = this.reader.nextLine();
        if (!this.difficulties.contains(difficulty)) {
            System.out.println("Ya blew it. That wasn't a valid difficulty. \n");
            return;
        }

        RandomQuestionGenerator questionGenerator = new RandomQuestionGenerator();
        while (this.questionNumber <= this.numQuestionsToAsk) {
            Question currentQuestion = questionGenerator.getRandomQuestion(difficulty);
            System.out.println("Question number " + this.questionNumber + " (" + currentQuestion.getDifficulty() + "):");
            boolean correct = this.askQuestion(currentQuestion);
            while (!correct) {
                // Keep asking question until correct answer is provided
                System.out.println("Womp womp, that's wrong. Try again! \n");
                correct = this.askQuestion(currentQuestion);
            }
            System.out.println("Correct!! Well done. \n");
            this.questionNumber++;
        }

        System.out.println("And that concludes this quiz. Thank you, please play again! \n");

        // Clean up after we're done
        this.reader.close();
    }

    private boolean askQuestion(Question question) {
        System.out.println(question.getQuestion());
        System.out.println("Please enter the letter of the answer you think is correct...");
        question.getAnswers().forEach((key, answer) -> System.out.println(key + ": " + answer));
        Character userAnswer = this.reader.nextLine().charAt(0);
        return question.checkAnswer(userAnswer);
    }
}
