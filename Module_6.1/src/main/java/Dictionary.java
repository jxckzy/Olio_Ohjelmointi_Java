import java.util.HashMap;

// custom exception
class WordNotFoundException extends Exception {
    public WordNotFoundException(String message) {
        super(message);
    }
}

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary() {
        this.words = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) throws WordNotFoundException {
        if (word == null || word.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is empty.");
        }

        String cleanWord = word.toLowerCase().trim();
        String meaning = words.get(cleanWord);

        if (meaning == null) {
            throw new WordNotFoundException("Word not found.");
        }

        return meaning;
    }
}