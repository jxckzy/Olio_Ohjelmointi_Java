public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;

        // hardcoded data exclusively for this task
        this.dictionary.addWord("Java", "A high-level, class-based, object-oriented programming language.");
        this.dictionary.addWord("JavaFX", "A software platform for creating and delivering desktop applications.");
        this.dictionary.addWord("Polymorphism", "The condition of occurring in several different forms in programming.");
        this.dictionary.addWord("Algorithm", "A process or set of rules to be followed in calculations or problem-solving.");
    }

    public String search(String word) {
        try {
            return dictionary.searchWord(word);
        } catch (IllegalArgumentException e) {
            return "Please enter a word to search.";
        } catch (WordNotFoundException e) {
            return "Word not found in the dictionary. Please try another word.";
        } catch (Exception e) {
            return "An unexpected error occurred.";
        }
    }
}