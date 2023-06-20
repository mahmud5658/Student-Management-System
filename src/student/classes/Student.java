package student.classes;

public class Student extends StudentBase {
    private String id;
    private String name;
    private int age;
    private String department;
    private String section;
    private String gender;
    private double cgpa;
    private int creditPassed;

    public Student() {

    }

    public Student(String id, String name, int age, String department, String section, String gender, double cgpa, int creditPassed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.section = section;
        this.gender = gender;
        this.cgpa = cgpa;
        this.creditPassed = creditPassed;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getSection() {
        return section;
    }

    @Override
    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public double getCgpa() {
        return cgpa;
    }

    @Override
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int getCreditPassed() {
        return creditPassed;
    }

    @Override
    public void setCreditPassed(int creditPassed) {
        this.creditPassed = creditPassed;
    }

    @Override
    void showDetails() {
        System.out.println("\n==== Student Information ====");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Section: " + section);
        System.out.println("Gender: " + gender);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Credit Passed: " + creditPassed);
    }
    String studentToString() {
        return id + "\r\n" + name + "\r\n" + age + "\r\n" + department + "\r\n" + section + "\r\n" + gender + "\r\n" + cgpa + "\r\n" + creditPassed;
    }
}
