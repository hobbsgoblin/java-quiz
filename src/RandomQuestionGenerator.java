import java.util.*;

class RandomQuestionGenerator {
    private List<Question> questions;
    private String difficulty;

    Question getRandomQuestion(String difficulty) {
        if (this.questions == null || !this.difficulty.equals(difficulty)) {
            this.difficulty = difficulty;
            this.questions = this.getQuestions();
            this.questions.removeIf(q -> !q.getDifficulty().equals(difficulty));
        }
        int randomQuestionIndex = new Random().nextInt(this.questions.size());
        Question question = this.questions.get(randomQuestionIndex);
        this.questions.remove(randomQuestionIndex);
        return question;
    }

    private List<Question> getQuestions() {
        // TODO: store this data as JSON
        Map<Character, String> q1Answers = new HashMap<>();
        q1Answers.put('a', "Marseilles");
        q1Answers.put('b', "Paris");
        q1Answers.put('c', "Chicago");
        q1Answers.put('d', "Leon");
        Question q1 = new Question(
                "easy",
                "What is the capital city of France?",
                q1Answers,
                'b'
        );

        Map<Character, String> q2Answers = new HashMap<>();
        q2Answers.put('a', "Earth");
        q2Answers.put('b', "The moon");
        q2Answers.put('c', "Jupiter");
        q2Answers.put('d', "The sun");
        Question q2 = new Question(
                "easy",
                "What is the largest visible object in the solar system?",
                q2Answers,
                'd'
        );

        Map<Character, String> q3Answers = new HashMap<>();
        q3Answers.put('a', "12");
        q3Answers.put('b', "4");
        q3Answers.put('c', "8");
        q3Answers.put('d', "6");
        Question q3 = new Question(
                "easy",
                "Which number is not a divisor of 12?",
                q3Answers,
                'c'
        );


        return new ArrayList<>(Arrays.asList(q1, q2, q3));
//        questions.removeIf(q -> !q.getDifficulty().equals(difficulty));
//        return questions;
//        return questions.stream()
//                .filter(q -> q.getDifficulty().equals(difficulty)).collect(Collectors.toList());
    }
}
