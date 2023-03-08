package package_1;

public class SameName {
    public static void main(String[] args){
        Employee employee = new Employee("Pletnova Veronika Olexandrivna",
                "java-developer", "name@email.com",
                "15232813", 20);
        System.out.println("Phone number: " + employee.getPhone());
    }
}
