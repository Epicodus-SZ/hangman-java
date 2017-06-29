import org.junit.*;
import static org.junit.Assert.*;
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


}
