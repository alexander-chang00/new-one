package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

         int numLines = input.getLineCount();
         for (int i = 0; i < numLines; i++){
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
         }

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        
        // Split the input into words based on spaces
        String[] words = input.trim().split("\\s+"); //split input into words based on whitespace
        if (input.trim().isEmpty()){
            return result; //if input is empty or only spaces, return empty string
        }

        // Translate each word and concatenate to result
        for (int i = 0; i < words.length; i++){
            String translatedWord = translateWord(words[i]);
            result += translatedWord;
            if (i < words.length - 1){
                result += " "; //add space between words
            }
        }

        return result;
    }

    private static String translateWord(String input) {

        String vowels = "aeiouyAEIOUY";
        System.out.println("  -> translateWord('" + input + "')");
        String piglatin = input.trim();
        int len = piglatin.length();
        String result = "";
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean noletters = true;
        for (int i = 0; i < len; i++){
            char c = piglatin.charAt(i);
            if (letters.contains(String.valueOf(c))){
                //if any character is not a letter, return original input
                noletters=false;
            }
        }
        if (noletters){
            return piglatin;
        }
        if (len == 0){
            return result;  //if the input is empty or only spaces, return empty string
        }
        if (input.equals("PG"))
        {
            System.out.println("Debugging PG case");
        }
        String firstLetter = piglatin.substring(0,1);  //retrieve first letter
        String restofInput = piglatin.substring(1);             //retrieve rest of the input

        char firstChar = piglatin.charAt(0);
        boolean isCapitalized = Character.isUpperCase(firstChar); 

        char lastChar = piglatin.charAt(piglatin.length() - 1);
        boolean isPunctuation = !Character.isLetterOrDigit(lastChar) && !Character.isWhitespace(lastChar);
        if (isPunctuation){
            restofInput = piglatin.substring(1, piglatin.length() - 1);   //update restofInput to exclude punctuation
        }

        //if the current first letter is a vowel, then just add "ay" to the end and done
        //else, move the first letter to the end of the string and check again
        boolean done = false;   //initialize done variable to false
        for (int i = 0; i < len && !done; i++){
            if (vowels.contains(firstLetter)){
                result = firstLetter + restofInput + "ay";
                done = true;
            } else {
                restofInput = restofInput + firstLetter.toLowerCase();  //move first letter to the end of restofInput and make it lowercase
                if (restofInput.length() > 0){
                    firstLetter = restofInput.substring(0,1);
                    restofInput = restofInput.substring(1);
                } else {
                    done = true;
                    result = piglatin; //all letters are consonants, return original piglatin
                }
            }
        }
        if (result.equals("")){
            result = piglatin; //in case all letters are consonants, return original piglatin
        }
        //smh the one on line 89 did not work
        // Capitalization (keep caps as-is except transfer first letter style)
        if (isCapitalized){
            char resultFirstChar = result.charAt(0);
            result = Character.toUpperCase(resultFirstChar) + result.substring(1);
        }

        // Punctuation
        if (isPunctuation){
            result = result + lastChar;
        }

        return result;
    }
           
}



