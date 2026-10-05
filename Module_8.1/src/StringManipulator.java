import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulator {

    /**
     * Concatenates two input strings and returns the result.
     */
    public String concatenate(String str1, String str2) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        return str1 + str2;
    }

    /**
     * Returns the length of the input string.
     */
    public int findLength(String str) {
        if (str == null) return 0;
        return str.length();
    }

    /**
     * Converts the input string to uppercase and returns the result.
     */
    public String convertToUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }

    /**
     * Converts the input string to lowercase and returns the result.
     */
    public String convertToLowerCase(String str) {
        if (str == null) return null;
        return str.toLowerCase();
    }

    /**
     * Checks if the input string contains the given substring.
     */
    public boolean containsSubstring(String str, String subStr) {
        if (str == null || subStr == null) return false;
        return str.contains(subStr);
    }
}


class StringManipulatorTest {

    private StringManipulator manipulator;

    @BeforeEach
    void setUp() {
        manipulator = new StringManipulator();
    }

    @Test
    @DisplayName("Should concatenate two non-null strings")
    void testConcatenate() {
        assertEquals("Hello World", manipulator.concatenate("Hello ", "World"));
        assertEquals("OpenAI", manipulator.concatenate("Open", "AI"));
        assertEquals("Test", manipulator.concatenate("Test", ""));
        assertEquals("Test", manipulator.concatenate("", "Test"));
    }

    @Test
    @DisplayName("Should return correct string length")
    void testFindLength() {
        assertEquals(5, manipulator.findLength("hello"));
        assertEquals(0, manipulator.findLength(""));
        assertEquals(0, manipulator.findLength(null));
    }

    @Test
    @DisplayName("Should convert string to uppercase")
    void testConvertToUpperCase() {
        assertEquals("JAVA", manipulator.convertToUpperCase("java"));
        assertEquals("JUNIT 5", manipulator.convertToUpperCase("JUnit 5"));
        assertEquals("", manipulator.convertToUpperCase(""));
        assertNull(manipulator.convertToUpperCase(null));
    }

    @Test
    @DisplayName("Should convert string to lowercase")
    void testConvertToLowerCase() {
        assertEquals("java", manipulator.convertToLowerCase("JAVA"));
        assertEquals("junit 5", manipulator.convertToLowerCase("JUnit 5"));
        assertEquals("", manipulator.convertToLowerCase(""));
        assertNull(manipulator.convertToLowerCase(null));
    }

    @Test
    @DisplayName("Should check if string contains substring correctly")
    void testContainsSubstring() {
        assertTrue(manipulator.containsSubstring("Software Development", "Dev"));
        assertFalse(manipulator.containsSubstring("Software Development", "Python"));
        assertTrue(manipulator.containsSubstring("JUnit Test", "JUnit"));
        assertFalse(manipulator.containsSubstring("JUnit Test", "junit")); // Case sensitive
        assertFalse(manipulator.containsSubstring(null, "test"));
    }
}