import java.util.HashMap;
import java.util.Map;

public class GroupEmailsIntoTheirAppreciateGroupThenGiveTheNumberOfGroups {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"a.b@ZigzagTraversal.com","x@ZigzagTraversal.com","x@exa.mple.com","ab+1@ZigzagTraversal.com","y@ZigzagTraversal.com","y@ZigzagTraversal.com","y@ZigzagTraversal.com"}));
    }

    public static int solution(String[] givenStringArray){
        HashMap<String, Integer> emailGroup = new HashMap<String, Integer>();
        int FinalResult=0;
        for(int i=0;i<givenStringArray.length;i++){
            String LocalName=givenStringArray[i].substring(0,givenStringArray[i].indexOf("@"));
            String DomainName=givenStringArray[i].substring(givenStringArray[i].indexOf("@"));
            LocalName=LocalName.replaceAll("\\.","");
            if(LocalName.contains("+")){
                LocalName=LocalName.substring(0,LocalName.indexOf("+"));
            }
            String CompleteName=LocalName+DomainName;
            if(!emailGroup.containsKey(CompleteName)){
                emailGroup.put(CompleteName,1);
            }else{
                emailGroup.replace(CompleteName,emailGroup.get(CompleteName)+1);
            }
        }


        for(Map.Entry<String, Integer> entry : emailGroup.entrySet()) {
            Integer value = entry.getValue();
            if(value>=2){
                FinalResult++;
            }
            // do what you have to do here
            // In your case, another loop.
        }
        return FinalResult;
    }
}
