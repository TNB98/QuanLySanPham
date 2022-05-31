import java.util.Scanner;

public class As2_Main {
    public static void main(String[] args) {
        As2 as2 = new As2();
        as2.prepareData();

        //Hiển thị bảng chọn chức năng và chọn chức năng
        int choice = 0 ;
        do{
            //Hiển thị bảng chức năng
            System.out.println("1:Đọc dữ liệu có sẵn từ file chứa các sản phẩm rồi lưu vào Linked List");
            System.out.println("2:Nhập và thêm một sản phẩm vào cuối của danh sách Linked List");
            System.out.println("3:Hiển thị thông tin của các sản phẩm trong Linked List");
            System.out.println("4:Lưu danh sách các sản phẩm vào file");
            System.out.println("5:Tìm kiếm thông tin của sản phẩm theo ID");
            System.out.println("6:Xóa sản phẩm trong danh sách theo ID");
            System.out.println("7:Sắp xếp các sản phẩm  trong danh sách theo ID");
            System.out.println("8:Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List về hệ đếm nhị phân");
            System.out.println("9:Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Liệt kê ra màn hình các sản phẩm có trong stack.");
            System.out.println("10:Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.");
            System.out.println("0:Thoát");
            //Chọn chức năng
            Scanner sc  = new Scanner(System.in);
            System.out.println("Chọn chức năng: ");
            choice = sc.nextInt();

            if(choice == 1){
                as2.insertToHead();
            }
            if(choice == 2){
                as2.insertAfterPosition();
            }
            if(choice == 3){
                as2.linkList.display();
            }
            if(choice == 4){
                as2.them1();
                FileUtil fileUtil = new FileUtil();
                fileUtil.ReadObjectToFile();
            }
            if(choice == 5){
                System.out.println("Nhập ID :");
                Scanner SC = new Scanner(System.in);
                String a = SC.nextLine();
                as2.seachID(a);
            }
            if(choice == 6){
                System.out.println("Nhập id càn xóa:");
                Scanner SC = new Scanner(System.in);
                String a = SC.nextLine();
                as2.deleteId(a);
            }
            if(choice == 7){
                as2.sortId();
            }
            if(choice == 8){
                int key = as2.linkList.head.info.getQuantity();
                as2.ConvertBinary(key);
            }
            if(choice == 9){
                as2.inSetStack();
            }
            if(choice == 10){
                as2.inSetQueQue();
            }



        }
        while (choice != 0);
    }
}
