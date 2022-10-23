package helpers;

public enum Endpoints {

    PET("/pet"),
    LOGIN("/user/login");

    public final String title;

    Endpoints(String title) {
        this.title = title;
    }
}
