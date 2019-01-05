import java.util.HashMap;

public class SmartSheetMinimizer {
    public static void main(String[] args) {
        String sample_input="/*\n* Function to chop a string in half.\n*/\npublic static string chop(string input) {\nif (input == null || input.isEmpty()) {\nreturn input;\n}\nif (input.length() % 2 == 1) {\nreturn \"cannot chop an odd-length string in half\";\n}\nreturn input.substring(input.length() / 2);\n}";
        System.out.println(minimize(sample_input));
        String sample_input2="you say yes, I say no you say stop and I say go go go";
        System.out.println(minimize(sample_input2));
    }
    private static String minimize(String s){
        if(s.isEmpty()||s==null){
            return "";
        }
        Integer current_identifier_index=0;
        HashMap<String, Integer> appearance_storage= new HashMap<>();
        String result="";
        char[] arr=s.toCharArray();
        String current_identifier="";
        for(int current_char_index=0;current_char_index<arr.length;current_char_index++){
            if(Character.isAlphabetic(arr[current_char_index])){
                current_identifier+=arr[current_char_index];
            }else{
                if(!current_identifier.isEmpty()){
                    if(!appearance_storage.containsKey(current_identifier)){
                        appearance_storage.put(current_identifier,current_identifier_index);
                        result+=current_identifier;
                    }else{
                        result+="$"+appearance_storage.get(current_identifier);
                    }
                    current_identifier_index++;
                    current_identifier="";
                }
                result+=arr[current_char_index];

            }
        }
        if(!current_identifier.isEmpty()){
            if(!appearance_storage.containsKey(current_identifier)){
                appearance_storage.put(current_identifier,current_identifier_index);
                result+=current_identifier;
            }else{
                result+="$"+appearance_storage.get(current_identifier);
            }
        }
        return result;
    }
}
