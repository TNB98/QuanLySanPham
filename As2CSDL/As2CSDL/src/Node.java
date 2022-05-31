public class Node {
    Product info ;
    Node next;
    Node(){
        info = null;
        next=null;
    }
    Node(Product info){
        this.info = info ;
        next = null;
    }
    Node(Product info , Node Ptr){
        this.info = info;
        this.next = Ptr ;
    }
}
