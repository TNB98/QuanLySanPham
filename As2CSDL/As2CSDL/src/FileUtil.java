import java.io.*;

public class FileUtil {
    private static final String filepath = "input.txt";

    public void addObjectArray(Product a[]){
        try {

            File file = new File(filepath);
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            for (int i = 0 ; i < a.length ; i++){
                objectOut.writeObject(a[i]);
            }
            objectOut.close();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static boolean hasObject(File f) {
        // thu doc xem co object nao chua
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {
                check = false;
            }
            inStream.close();

        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }
    public void WriteObjectToFile(Object serObj) {

        try {

            File f = new File(filepath);
            FileOutputStream fo;
            ObjectOutputStream oStream = null;

            // neu file chua ton tai thi tao file va ghi binh thuong
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else { // neu file ton tai

                // neu chua co thi ghi binh thuong
                if (!hasObject(f)) {
                    fo = new FileOutputStream(f);
                    oStream = new ObjectOutputStream(fo);
                } else { // neu co roi thi ghi them vao

                    fo = new FileOutputStream(f, true);

                    oStream = new ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    };
                }
            }

            oStream.writeObject(serObj);
            oStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ReadObjectToFile(){

        try {
            File file = new File(filepath);
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Product c = null;
            do{
                c =(Product) objectIn.readObject();
                System.out.println(c);
            }
            while (fileIn.available() >  0 ) ;

            objectIn.close();

        }
        catch (Exception ex){
              ex.printStackTrace();
        }
    }

}
