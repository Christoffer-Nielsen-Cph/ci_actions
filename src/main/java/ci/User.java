package ci;

public class User {
    private String fname;
    private String lname;
    private String pw;
    private int phone;
    private String address;

    public User(String fname, String lname, String pw, int phone, String address) {
        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
    }

    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public User(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPw() {
        return pw;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", pw='" + pw + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
