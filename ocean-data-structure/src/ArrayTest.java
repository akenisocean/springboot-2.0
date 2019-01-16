/**
 * @author jack chao
 * @create 2019-01-03 16:04
 * @desc
 **/
public class ArrayTest {
    public static void main(String[] args) {
        Array<Student> arr = new Array<Student>();
        arr.addLast(new Student("Alice",10));
        arr.addLast(new Student("Aken",30));
        arr.addLast(new Student("Folen",50));
        System.out.println(arr.toString());

    }
}
