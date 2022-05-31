import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Stack;

public class As2 {
    //ghi file
    LinkList linkList = new LinkList();
    public void prepareData() {
        FileUtil objectIO = new FileUtil();
        Product p = new Product("1", "hoa", 1, 3000);
        Product c = new Product("2", "but", 2, 100000);
        Product f = new Product("F4", "thcuoc", 1, 1000.2);
        Product[] a = new Product[3];
        a[0] = p;
        a[1] = c;
        a[2] = f;
        objectIO.addObjectArray(a);
    }
    //1:ghi du lieu tu file vo LinkList
    public void  insertToHead(){

        File file = new File("input.txt");
        Product a = null;
        try {
            FileInputStream in = new FileInputStream("input.txt");
            ObjectInputStream objectIn = new ObjectInputStream(in);
            /*
            a = (Product) objectIn.readObject();
            while (a!= null){
                linkList.addTail(a);
                a = (Product) objectIn.readObject();
            }*/
            do{
                a = (Product) objectIn.readObject();
                linkList.addTail(a);
            }
            while (in.available() >0 );
            objectIn.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        linkList.display();

    }

    //2:Nhập và thêm một sản phẩm vào cuối của danh sách Linked List
    public void  insertAfterPosition(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã số sản phẩm: ");
        String bCode = sc.nextLine();
        System.out.println("Nhập tên sản phẩm:");
        String title = sc.nextLine();
        System.out.println("Nhập số lượng sản phẩm:");
        int quantity = sc.nextInt();
        System.out.println("Nhập giá trị sản phẩm :");
        Double price = sc.nextDouble();
        Product newSP = new Product(bCode,title,quantity,price);
        linkList.addTail(newSP);
        linkList.display();
    }
    //4:
    public void them1(){
        linkList.them();
    }
    //5:
    public void seachID(String a){
        Node newNode = new Node();
        newNode = linkList.head;
        int i = 0 ;
        while (newNode!=null) {
            if (newNode.info.getBcode().equalsIgnoreCase(a)) {
                System.out.println(newNode.info);
                i  = 1 ;
            }
            newNode = newNode.next;
        }
        if(i == 0) {
            System.out.println("-1");
        }


    }
    //6:
    public void deleteId(String a){
        Node newNode = new Node();
        newNode = linkList.head;
        while (newNode!=null){
            if (newNode.info.getBcode().equalsIgnoreCase(a)){
                linkList.deleteNode(newNode.info);
            }
            newNode = newNode.next;
        }

    }
    //7:
    public void sortId(){
        Node newNode = new Node();
        int j = 0 ;
        newNode = linkList.head;
        while (newNode!=null){
            j+=1;
            newNode=newNode.next;
        }
        Product[] a = new Product[j];
        Product temp = null;
        int i = 0 ;
        newNode = linkList.head;
        while (newNode!=null){
            a[i]=newNode.info;
            i++;
            newNode=newNode.next;
        }

        for (int n=0;n<a.length;n++){
            for (int k = n+1 ; k<a.length;k++){
                if(a[n].getBcode().compareTo(a[k].getBcode())>0){
                    temp = a[n];
                    a[n]=a[k];
                    a[k]=temp;
                }
            }
        }
        for (int m = 0 ; m < a.length ; m++){
            System.out.println(a[m]);
        }
        linkList.delete();
        for (int n = 0 ; n < a.length ; n ++ ){
            linkList.addTail(a[n]);
        }
    }

    //8.Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List về hệ đếm nhị phân
    // bằng phương pháp đệ quy.
    int a =0 ;
    public void ConvertBinary (int key){
        if(key !=0){
            a = key%2;
            System.out.print(a);
            ConvertBinary(key/2);
        }
        else {
            System.out.println();
        }
        return;
    }

    //9:Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Liệt kê ra màn hình các sản phẩm có trong stack.
    public int longFile(){
        int i = 0;
        try {
            File file = new File("input.txt");
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(in);
            Product p = null;
            Object c;
            i = in.available();
            do{
                c =(Product) objectIn.readObject();
            }
            while (in.available() >  0 ) ;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
       return i;
    }
    public void inSetStack(){
        MyStack stack = new MyStack();
        stack.MyStack(longFile());
        try {
            File file = new File("input.txt");
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(in);
            Product c;

            do{
                c =(Product) objectIn.readObject();
                stack.push(c);
            }
            while (in.available() >  0 ) ;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        stack.display();
    }

    //10Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
    public void inSetQueQue(){
        MyQueque myQueque = new MyQueque();
        try{
            File file = new File("input.txt");
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(in);
            Product c;
            do{
                c =(Product) objectIn.readObject();
                myQueque.enqueue(c);
            }
            while (in.available() >  0 ) ;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        myQueque.display();
    }


}
