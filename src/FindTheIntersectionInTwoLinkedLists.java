import java.util.List;

public class FindTheIntersectionInTwoLinkedLists {
    public static void main(String[]args)
    {
        ListNode first=new ListNode(2);

        ListNode inter=new ListNode(3);
        first.next=inter;
        System.out.println(getIntersectionNode(first,inter));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
           next = null;
        }
     }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode movingA=headA;
        ListNode movingB=headB;
        while(movingA!=null && movingB!=null){
            if(movingA==movingB){
                return movingA;
            }
            movingA=movingA.next;
            movingB=movingB.next;
        }
        if(movingA==null){
            movingA=headB;
        }
        if(movingB==null){
            movingB=headA;
        }
        while(movingA!=null && movingB!=null){
            if(movingA==movingB){
                return movingA;
            }
            movingA=movingA.next;
            movingB=movingB.next;
        }
        if(movingA==null){
            movingA=headB;
        }
        if(movingB==null){
            movingB=headA;
        }
        while(movingA!=null && movingB!=null){
            if(movingA==movingB){
                return movingA;
            }
            movingA=movingA.next;
            movingB=movingB.next;
        }
        return null;
    }
}
