import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
  private String mSecretWord;
  private String[] mExpectedWords = {"apple", "phone", "these", "watermelon", "jackets"};

  public Hangman() {
    setSecretWord();
  }

  public String getSecretWord(){
    return mSecretWord;
  }

  public String setSecretWord(){
    Random randomNumber = new Random();
    int numberRolled = randomNumber.nextInt(5);
    mSecretWord = mExpectedWords[numberRolled];
    return mSecretWord;
  }

  public boolean letterIsInWord(String guessedLetter){
    //for each letter in secretword loop
    int pos = mSecretWord.indexOf(guessedLetter);
      if (pos == -1) {
          // letter not found
          return false;
      }
      else {
          // letter exists at zero-based position pos
          // CAUTION: it might also exist in later positions!
          return true;
      }
    //return true i
  }
}
