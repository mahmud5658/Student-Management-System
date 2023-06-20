package student.classes;

import exceptions.FileReadWriteException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class StudentIO {
    private String fileName = "StudentInformation";
    private File file ;
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader bufferedReader;

    public void WriteIntoFile(Student student) throws Exception {
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file, true);
            writer.write(student.getId() + "\r\n");
            writer.write(student.getName() + "\r\n");
            writer.write(student.getAge() + "\r\n");
            writer.write(student.getDepartment() + "\r\n");
            writer.write(student.getSection() + "\r\n");
            writer.write(student.getGender() + "\r\n");
            writer.write(student.getCgpa() + "\r\n");
            writer.write(student.getCreditPassed() + "\r\n");
            writer.write("\r\n");
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File write error.");
        } catch (Exception error) {
            throw new Exception("Some error occurred.");
        }
    }

    public Student searchFromFile(String id) throws Exception {
        Student student = new Student();
        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String temp = "";
            int counter = 0;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(id) && temp.length() == id.length()) {
                    student.setId(temp);
                    counter++;
                } else {
                    switch (counter) {
                        case 1: {
                            student.setName(temp);
                            counter++;
                            break;
                        }
                        case 2: {
                            student.setAge(Integer.parseInt(temp));
                            counter++;
                            break;
                        }
                        case 3: {
                            student.setDepartment(temp);
                            counter++;
                            break;
                        }
                        case 4: {
                            student.setSection(temp);
                            counter++;
                            break;
                        }
                        case 5: {
                            student.setGender(temp);
                            counter++;
                            break;
                        }
                        case 6: {
                            student.setCgpa(Double.parseDouble(temp));
                            counter++;
                            break;
                        }
                        case 7: {
                            student.setCreditPassed(Integer.parseInt(temp));
                            counter++;
                            break;
                        }
                    }
                }
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException error) {
            throw new FileReadWriteException("File read error.");
        } catch (Exception error) {
            throw new Exception("Some error occurred.");
        }
        return student;
    }

    public void updateData(String oldData, String newData) throws Exception {
        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String oldStudentData = "";
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                oldStudentData += temp+ "\r\n";
            }
            String newStudentData = oldStudentData.replace(oldData, newData);
            bufferedReader.close();
            reader.close();
            writer = new FileWriter(file);
            writer.write(newStudentData);
            writer.flush();
            writer.close();
        } catch (IOException error) {
            throw new FileReadWriteException("File update error.");
        } catch (Exception error) {
            throw new Exception("Some error occurred.");
        }
    }

    public Student[] getAllStudent() throws Exception {
        Student[] students = new Student[]{};
        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String temp;
            int wordCount = 0;
            int studentCount = 0;

            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.length() > 0)
                    wordCount++;
            }
            students = new Student[wordCount / 8];
            wordCount = 0;
            bufferedReader.close();
            reader.close();
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);

            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.length() > 0) {
                    if (students[studentCount] == null) {
                        students[studentCount] = new Student();
                    }
                    switch (wordCount) {
                        case 0:
                            students[studentCount].setId(temp);
                            break;
                        case 1:
                            students[studentCount].setName(temp);
                            break;
                        case 2:
                            students[studentCount].setAge(Integer.parseInt(temp));
                            break;
                        case 3:
                            students[studentCount].setDepartment(temp);
                            break;
                        case 4:
                            students[studentCount].setSection(temp);
                            break;
                        case 5:
                            students[studentCount].setGender(temp);
                            break;
                        case 6:
                            students[studentCount].setCgpa(Double.parseDouble(temp));
                            break;
                        case 7:
                            students[studentCount].setCreditPassed(Integer.parseInt(temp));
                            break;
                    }
                    wordCount++;

                } else {
                    studentCount++;
                    wordCount = 0;
                }
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException error) {
            throw new FileReadWriteException("File read error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
        return students;
    }
}
