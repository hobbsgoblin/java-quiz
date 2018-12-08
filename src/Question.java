import java.util.HashMap;
import java.util.Map;

class Question {

    private String difficulty;
    private String question;
    private Map<Character,String> answers;
    private Character correctAnswer;

    Question(String difficulty, String question, Map<Character, String> answers, Character correctAnswer) {
        this.difficulty = difficulty;
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    boolean checkAnswer(Character answer) {
        return answer == this.correctAnswer;
    }

    String getDifficulty() {
        return difficulty;
    }
    void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    String getQuestion() {
        return question;
    }
    void setQuestion(String question) {
        this.question = question;
    }

    Map getAnswers() {
        return answers;
    }
    void setAnswers(HashMap<Character,String> answers) {
        this.answers = answers;
    }
}
