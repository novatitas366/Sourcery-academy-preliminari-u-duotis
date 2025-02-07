public class Main {

    public static String compress(String input){
        StringBuilder output = new StringBuilder();
        if(input.isEmpty()){
            return "";
        }
        int charnum = 0;
        char presentSymbol;
        char pastSymbol=' ';
        for(int i = 0; i< input.length(); i++){
            presentSymbol = input.charAt(i);
            if(presentSymbol != pastSymbol && pastSymbol != ' '){
                output.append(pastSymbol).append(charnum);
                charnum=0;
            }
            charnum++;
            pastSymbol = presentSymbol;
        }
        output.append(pastSymbol).append(charnum);
        return output.toString();
    }

    public static String decompress(String input){
        StringBuilder output = new StringBuilder();
        if(input.isEmpty()){
            return "";
        }
        for(int i = 0, j=i+1; i<input.length()-1; i=j){
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
        System.out.println(compress("aaaabbb"));
        System.out.println(decompress("a4b3"));
    }
}
