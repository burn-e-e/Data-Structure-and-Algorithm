import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    public String code;
    public String name;
    public float credit;

    public Subject(String code, String name, float credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    // Method to read subjectList from file
    public static List<Subject> readSubjectList(String fileName) throws IOException {
        List<Subject> subjectList = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] values = line.split("/");
                if (values.length == 3) {
                    String code = values[0].trim();
                    String name = values[1].trim();
                    float credit = Float.parseFloat(values[2].trim());

                    Subject subject = new Subject(code, name, credit);
                    subjectList.add(subject);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            throw e;
        }

        return subjectList;
    }

    public static void main(String[] args) {
        try {
            String fileName = "Subjects.txt";
            List<Subject> subjectList = readSubjectList(fileName);

            // Print subjectList
            for (Subject subject : subjectList) {
                System.out.println(subject.code + " / " + subject.name + " / " + subject.credit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Major {
    public String code;
    public String name;

    public Major(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Method to read majorList from file
    public static List<Major> readMajorList(String fileName) throws IOException {
        List<Major> majorList = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] values = line.split("/");
                if (values.length == 2) {
                    String code = values[0].trim();
                    String name = values[1].trim();

                    Major major = new Major(code, name);
                    majorList.add(major);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            throw e;
        }

        return majorList;
    }

    public static void main(String[] args) {
        try {
            String fileName = "Professions.txt";
            List<Major> majorList = readMajorList(fileName);

            // Print majorList
            for (Major major : majorList) {
                System.out.println(major.code + " / " + major.name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
