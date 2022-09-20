import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student(i+1, "张三" + i);
            students.add(student);
        }

        for (int i = 0; i < 5; i++) {
            Teacher teacher = new Teacher(i, i%2==0?0:1);
            teachers.add(teacher);
        }


        for (Student student : students) {
            System.out.print("学生年龄"+student.getAge()+"=");
        }
        System.out.println("=================");
        for (Teacher teacher : teachers) {
            System.out.print("老师年龄"+teacher.getAge());
        }
        System.out.println("=================");
        for (Student student : students) {
            for (Teacher teacher : teachers) {

                if (teacher.getAge() == student.getAge()) {
                    System.out.println(teacher.getAge() + "");
                    students.remove(student);
                    break;
                }
            }
        }
        /*for (Iterator iterator = students.iterator(); iterator.hasNext();) {
            Student s = (Student) iterator.next();
            for (Teacher teacher : teachers) {
                if (teacher.getAge()==s.getAge()){
                    System.out.println(teacher.getAge()+"");
                    students.remove(s);
                    break;
                }
            }
        }*/


      /*  for (Student student : students) {
            lableB:
            for (Teacher teacher : teachers) {
                if (teacher.getAge()==student.getAge()){
                    students.remove(student);
                    System.out.println(teacher.getAge()+"");
                    break lableB;
                }
            }
        }*/


    }
}
