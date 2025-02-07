public class Main {

    public static String compress(String input){
        if(input.isEmpty()){
            return "";
        }
        String Output = "";
        Integer charnum = 0;
        char presentSymbol;
        char pastSymbol=' ';
        for(int i = 0; i< input.length(); i++){
            presentSymbol = input.charAt(i);
            if(presentSymbol != pastSymbol && pastSymbol != ' '){
                Output+=pastSymbol+charnum.toString();
                charnum=0;
            }
            charnum++;
            pastSymbol = presentSymbol;
        }
        Output += pastSymbol + charnum.toString();
        return Output;
    }

    

    public static void main(String[] args) {
        System.out.println(compress(""));
    }
}
