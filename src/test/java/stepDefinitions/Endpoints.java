package stepDefinitions;

public enum Endpoints {



    REGISTER("/register.php"),
    LOGIN("/login.php"),
    MORTGAGE("/getmortagage.php"),
    POST_MORTGAGE("/mortagagedetails.php");






    final String str;
    Endpoints(String str) {
        this.str = str;

    }

    @Override
    public String toString() {
        return this.str;
    }
}