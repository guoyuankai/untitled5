package mypackage;

public class TestSearchHouse {
    public static void main(String[] args) {
        Person person = (Person) new HomeLink().getInstance(new Master());
        person.searchHouse();
    }
}
