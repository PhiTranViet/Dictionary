package TuDien;
import java.io.Serializable;
import javax.swing.JOptionPane;
public class TuDien implements Serializable{
    String Tienganh;
    String Tiengviet;
    String Loaitu;
    String Phatam;

    public TuDien() {
    }

    public String getTienganh() {
        return Tienganh;
    }

    public void setTienganh(String Tienganh) {
        this.Tienganh = Tienganh;
    }

    public String getTiengviet() {
        return Tiengviet;
    }

    public void setTiengviet(String Tiengviet) {
        this.Tiengviet = Tiengviet;
    }

    public String getLoaitu() {
        return Loaitu;
    }

    public void setLoaitu(String Loaitu) {
        this.Loaitu = Loaitu;
    }

    public String getPhatam() {
        return Phatam;
    }

    public void setPhatam(String Phatam) {
        this.Phatam = Phatam;
    }

    public TuDien(String Tienganh, String Tiengviet, String Loaitu, String Phatam) {
        this.Tienganh = Tienganh;
        this.Tiengviet = Tiengviet;
        this.Loaitu = Loaitu;
        this.Phatam = Phatam;
    }
 
}
