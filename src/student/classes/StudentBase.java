package student.classes;

public abstract class StudentBase {
    abstract String getId();

    abstract void setId(String id);

    abstract String getName();

    abstract void setName(String name);

    abstract int getAge();

    abstract void setAge(int age);

    abstract String getDepartment();

    abstract void setDepartment(String department);

    abstract String getSection();

    abstract void setSection(String section);

    abstract String getGender();

    abstract void setGender(String gender);

    abstract double getCgpa();

    abstract void setCgpa(double cgpa);

    abstract int getCreditPassed();

    abstract void setCreditPassed(int creditPassed);

    abstract void showDetails();
}
