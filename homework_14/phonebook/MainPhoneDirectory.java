package phonebook;

public class MainPhoneDirectory {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add(new Record("Ann", "+380271823546"));
        phoneDirectory.add(new Record("Ivan", "+380579284471"));
        phoneDirectory.add(new Record("Ivan", "+380259274938"));
        phoneDirectory.add(new Record("Roman", "+380192261733"));
        phoneDirectory.add(new Record("Ann", "+380390320055"));
        phoneDirectory.add(new Record("Ann", "+380617826763"));

        System.out.println(phoneDirectory.find("Ivan"));
        System.out.println(phoneDirectory.findAll("Ann"));
    }
}