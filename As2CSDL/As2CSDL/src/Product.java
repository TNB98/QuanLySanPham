import java.io.Serializable;

public class Product  implements Serializable {
    private String bcode ;
    private  String title;
    private  int quantity;
    private  double price;

    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    //Geter & Seter

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //to String

    @Override
    public String toString() {
        return "Product{" +
                "bcode='" + bcode + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
