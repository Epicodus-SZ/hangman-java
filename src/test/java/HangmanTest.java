import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.*;

public class HangmanTest {

  @Test
  public void generateRandomWord_ReceiveRandomWord_True(){
    boolean expectedOutput = false;
    Hangman testHangman = new Hangman();
    String[] mExpectedWords = {"apple", "phone", "these", "watermelon", "jackets"};
    String generatedWord = testHangman.setSecretWord();
    if(Arrays.asList(mExpectedWords).contains(generatedWord)){
      expectedOutput = true;
    }
    assertTrue(expectedOutput);
  }

  @Test
  public void letterIsInWord_SeesThatALetterIsNotInWord_False(){
    Hangman testHangman = new Hangman();
    assertEquals(false, testHangman.letterIsInWord("z"));
  }

  @Test
  public void letterIsInWord_SeesThatALetterIsInWord_True(){
    Hangman testHangman = new Hangman();
    assertEquals(true, testHangman.letterIsInWord("e"));
  }

  @Test
  public void putGuessedLetter_CanPutLetterInGuessLetterArray(){
    Hangman testHangman = new Hangman();
    testHangman.putGuessedLetter("z");
    List<String> testLetters = testHangman.getGuessedLetters();
    assertTrue(testLetters.contains("z"));
  }

  @Test
  public void drawUnderscores_ProperlyUnderscoresTheSecretWord_PASS(){
    boolean expectedOutput = false;
    Hangman testHangman = new Hangman();
    testHangman.putGuessedLetter("a");
    testHangman.putGuessedLetter("c");
    testHangman.drawUnderscores("taco");
    assertEquals("_ a c _", testHangman.drawUnderscores("taco"));
  }

  @Test
  public void drawUnderscores_ProperlyUnderscoresTheSecretWord_FAIL(){
    boolean expectedOutput = false;
    Hangman testHangman = new Hangman();
    testHangman.putGuessedLetter("a");
    testHangman.putGuessedLetter("c");
    testHangman.drawUnderscores("taco");
    assertThat("_ _ c _", not(testHangman.drawUnderscores("taco")));
  }



}
