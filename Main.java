

public class Main {
    // This method compresses a string by replacing consecutive repeating 
    // characters with the character followed by the count of its occurrences.
    public static String compress(String input){
        StringBuilder output = new StringBuilder();
        if(input.isEmpty()){
            return "";
        }
        int charnum = 0; // charnum counts consecutive characters in order to put them into the output
        char presentSymbol; // we save the present symbol and past symbol to know when to stop counting the symbols and when
        char pastSymbol=' ';// to append them to the output.
        for(int i = 0; i< input.length(); i++){
            /*
             * In this for loop we take the present symbol and check whether it is different from the past symbol. If not
             * we just increment the count of the letters. If the symbols are different then we append the symbol and its count
             * to the output and set the count to zero. Then we repeat the process until we reach the end of the input string.
             */
            presentSymbol = input.charAt(i);
            if(presentSymbol != pastSymbol && pastSymbol != ' '){
                output.append(pastSymbol).append(charnum);
                charnum=0;
            }
            charnum++;
            pastSymbol = presentSymbol;
        }
        //after the loop we just append the last symbol and count. Then we return the output.
        output.append(pastSymbol).append(charnum);
        return output.toString();
    }


    // This method decompresses a compressed string back to its original form
    public static String decompress(String input){
        StringBuilder output = new StringBuilder();
        if(input.isEmpty()){
            return "";
        }
        for(int i = 0, j=0; i<input.length()-1; i=j){
            /*
             * for the decompression algorithm we initialize i and j. i keeps track of letter location and j keeps track 
             * of count locations in the string. since the count of how many symbols there are is always to the right of a symbol we just
             * take j as i+1 to get the count. Since there is a posibility that there could be multi-digit numbers such as 11,
             * we need to use a while loop to increment j and append more numbers to num so we could have a full multi-digit number.
             * we convert the number from a string to an integer so we could use the string method repeat to repeat the symbol the amount of times
             * specified. Then we append to output. set the i to the next letter and repeat the process.
             * 
             */
            StringBuilder num = new StringBuilder();
            j = i+1;
            while(input.charAt(j) >= 48 && input.charAt(j) <=57){
                num.append(input.charAt(j));
                j++;
                if(input.length() == j){
                    break;
                }
            }
            String symb = Character.toString(input.charAt(i)).repeat(Integer.parseInt(num.toString()));
            output.append(symb);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("qwertyuioplkjhgfdsazxcvbnmm"));
        System.out.println(decompress("a4b3"));
    }
}
