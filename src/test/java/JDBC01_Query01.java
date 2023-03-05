import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1- Ilgili driver'ı yüklemeliyiz. MySQL kullandığımızı bildiriyoruz
        // Driver'ı bulamama ihtimaline karşı forName methodu için  ClassNotFoundException'ı
        // metod signature'ımıza exception olarak fırlatmamızı istiyor

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- bağlantıyı oluşturmak için username ve password girmeliyiz
        // burda da bu username ve password'un yanlış olma ihtimaline karşı
        // SQLException fırlatmamızı istiyor

        Connection con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC","root","1234");

        // 3- SQL query'leri için bir Statement objesi oluşturup
        // java'da SQL sorgularımız için bir alan açacağız

        Statement st = con.createStatement();

        // 4- SQL query'lerimizi yazıp, çalıştırabiliriz

        ResultSet veri = st.executeQuery("SELECT * FROM personel");

       // 5- Sonuçları görmek için iteration ile Set içerisindeki elemanları
       // while döngüsü ile yazdırıyoruz

        while (veri.next()) {
            System.out.println(veri.getString(1) + " " + veri.getString(2)
                       + " " + veri.getString(3) + " " + veri.getInt(4)
                       + " " + veri.getString(5));
        }

        /*
          123456789 Ali Seker Istanbul 2500 Honda
          234567890 Ayse Gul Istanbul 1500 Toyota
          345678901 Veli Yilmaz Ankara 3000 Honda
          456789012 Veli Yilmaz Izmir 1000 Ford
          567890123 Veli Yilmaz Ankara 7000 Hyundai
          456789012 Ayse Gul Ankara 1500 Ford
          123456710 Fatma Yasa Bursa 2500 Honda
          */

        // 6- Oluşturulan bağlantıları kapatalım

        con.close();
        st.close();
        veri.close();


    }
}
