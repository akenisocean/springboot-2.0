package linkedlist;

/**
 * @author jack chao
 * @create 2019-01-04 16:58
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lin = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            lin.addFirst(i);
            System.out.println(lin);

        }
        lin.add(2,666);
        System.out.println(lin);


        Integer remove = lin.remove(3);
        System.out.println("删除的数据为:"+remove);
        System.out.println(lin);
    }
}
