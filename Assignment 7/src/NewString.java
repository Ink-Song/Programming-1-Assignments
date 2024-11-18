public class NewString {
    private final String text;

    public NewString(String input){
        text = input;
    }

    public String getBase(){
        return text;
    }
    //Returns an abbreviation of the string.
    public String abbreviate(){
        String[] arr = text.split(" ", -2); // Split the base text at spaces.
        char[] letters = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            letters[i] = (arr[i].charAt(0)); // Iterate through the list and take only first letter from each word.
        }
        return new String(letters);
    }

    //Removes a given input from the string
    public String removeLetter(char input){
        String workingText = text;
        do {
            workingText = workingText.substring(0, workingText.indexOf(input)) + workingText.substring(workingText.indexOf(input)+1);
        }while(workingText.indexOf(input) != -1);

        return workingText;
    }
}
