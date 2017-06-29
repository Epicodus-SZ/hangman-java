import java.util.List;
import java.util.*;
import java.util.Random;

public class Hangman {
  private String mSecretWord;
  private String[] mExpectedWords = {"apple", "phone", "these", "watermelon", "jackets"};
  private List<String> guessedLetters = new ArrayList<String>();
  private int mWrongGuesses;
  private boolean mAlive;
  private boolean mWinner;

  // Hangman Constructor
  public Hangman() {
    //initialize a new game
    setSecretWord();
    mWrongGuesses = 0;
    mAlive = true;
    mWinner = false;
  }

  public void putGuessedLetter(String putLetter) {
    guessedLetters.add(putLetter);
  }

  public String getSecretWord(){
    return mSecretWord;
  }

  ///////////////////////////
  //test methods
  ///////////////////////////

  public void testSecretWord(String setString){
    mSecretWord = setString;
  }

  public List<String> getGuessedLetters(){
    return guessedLetters;
  }

  // end test methods
  ///////////////////////////

  public String setSecretWord(){
    Random randomNumber = new Random();
    int numberRolled = randomNumber.nextInt(5);
    mSecretWord = mExpectedWords[numberRolled];
    return mSecretWord;
  }

  //getter to see if we're still mAlive
  public boolean stillAlive(){
    return mAlive;
  }

  //getter to see if we have a mWinner
  public boolean weHaveAWinner(){
    return mWinner;
  }

  public boolean letterIsInWord(String guessedLetter){
    //for each letter in secret word
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
  }

  public String drawGallow() {
    // added an extra arraylist item as a work around for an ugly bug.
    ArrayList<String> deadman = new ArrayList<String>(Arrays.asList(" ","O","/","|","\\","|","/","\\"));
    ArrayList<String> hungman = new ArrayList<String>(Arrays.asList(" "," "," "," "," "," "," "," "));

    for (int i=0;i<=mWrongGuesses;i++){
      hungman.set( i, deadman.get(i) );
    }

  String gallow = String.format("-----|--\n|   %s%s\n|   %s%s%s\n|    %s\n|   %s %s\n|\n---------\n        |\n",hungman.get(0),hungman.get(1),hungman.get(2),hungman.get(3),hungman.get(4),hungman.get(5),hungman.get(6),hungman.get(7));
    return gallow;
  }


  public String drawUnderscores(){
    char[] lettersInWord = mSecretWord.toCharArray();
    String returnString = "";

    for (char letter : lettersInWord) {
      //see if letter is in guessedLetters
      if(guessedLetters.contains(String.valueOf(letter))){
        returnString += letter + " ";
      }
      else {
        returnString += "_ ";
      }
    }
    return returnString.trim();
  }

  public String play(String guessedLetter){
    putGuessedLetter(guessedLetter); //put guessedLetter in guessed array (method)
    String attempt = drawUnderscores(); //draw what's to be displayed

    if(letterIsInWord(guessedLetter)){
      if(!attempt.contains("_")) {
        mWinner = true;
      }//test to see if Drawn == Secretword we have a mWinner
    } else {

      mWrongGuesses++;

      if (mWrongGuesses==7) {mAlive=false;}
      //if the counter is 7 your dead
    }

    return attempt;
  }
}
