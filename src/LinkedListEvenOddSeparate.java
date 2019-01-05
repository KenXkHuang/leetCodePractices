public class LinkedListEvenOddSeparate {
    public static void main(String args[]){
        node first=new node(3);
        first.next=new node(5);
        first.next.next=new node(6);
        first.next.next.next=new node(8);
        first.next.next.next.next=new node(9);
        first.next.next.next.next.next=new node(12);
        node newHead=separate(first);
    }
    public static node separate(node head){
        node evenHead = null,oddHead=null,lastEven=null,lastOdd=null;
        node current=head;
        if(head==null){
            return null;
        }

        while(current!=null){
            if(current.val%2==0){
                if(evenHead==null){
                    evenHead=lastEven=current;
                }else{
                    lastEven.next=current;
                    lastEven=current;
                }
            }else{
                if(oddHead==null){
                    oddHead=lastOdd=current;
                }else{
                    lastOdd.next=current;
                    lastOdd=current;
                }
            }
            current=current.next;
        }
        lastOdd.next=null;
        if(evenHead==null){
            return oddHead;
        }
        lastEven.next=oddHead;
        return evenHead;
    }
    static class node{
        public node next;
        public int val;
        public node(int val){
            this.val=val;
        }
    }
}
