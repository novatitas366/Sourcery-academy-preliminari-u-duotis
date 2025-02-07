public class Main {

    public static String compress(String input){
        if(input.isEmpty()){
            return "";
        }
        String output = "";
        Integer charnum = 0;
        char presentSymbol;
        char pastSymbol=' ';
        for(int i = 0; i< input.length(); i++){
            presentSymbol = input.charAt(i);
            if(presentSymbol != pastSymbol && pastSymbol != ' '){
                output+=pastSymbol+charnum.toString();
                charnum=0;
            }
            charnum++;
            pastSymbol = presentSymbol;
        }
        output += pastSymbol + charnum.toString();
        return output;
    }

    public static String decompress(String input){
        String output = "";
        if(input.isEmpty()){
            return "";
        }
        for(int i = 0; i<input.length()-1; i+=2){
            int j = i+1;
            String symb = Character.toString(input.charAt(i)).repeat(Integer.parseInt(Character.toString(input.charAt(j))));
            output += symb;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(compress(""));
        System.out.println(decompress("a11b3"));
    }
}
