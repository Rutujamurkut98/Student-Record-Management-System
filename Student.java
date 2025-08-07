public class Student {
    private int studentId;
    private String email;
    private String name;
    private double marks;

    public Student(int studentId, String email, String name, double marks) {
        this.studentId = studentId;
        this.email = email;
        this.name = name;
        this.marks = marks;
    }

    public int getStudentId() { return studentId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    public String toString() {
        return "Student ID: " + studentId +
               ", Email: " + email +
               ", Name: " + name +
               ", Marks: " + marks;
    }
}
