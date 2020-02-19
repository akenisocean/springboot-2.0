/**
 * @author jack chao
 * @create 2019-01-03 11:10
 * @desc 数组数据结构
 **/
public class Array<E> {
    private E[] data;
    private int size;


    /**
     * 默认给当前数组设置容量为10；
     */
    public Array() {
        this(10);
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;

    }

    /**
     * 获取数组中的元素个数
     *
     * @return the number of elements in this Array
     */
    public int size() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组中的内容是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中的最后一个位置添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild.Require index >=0 and index <=size");
        }
        if (size == data.length) {
            //进行数组的扩容
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }

    /**
     * 进行扩容操作
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }


    /**
     * 获取index索引位置的元素
     *
     * @return
     */
    public E getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add faild.Require index >=0 and index <=size");
        }
        return data[index];

    }

    /**
     * 修改指定缩影中的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set faild.Require index >=0 and index <=size");
        }
        data[index] = e;
    }

    /**
     * 查看数组中是否有指定的元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;

    }

    /**
     * 查找某个元素对应的索引
     *
     * @param e
     * @return 返回改元素指定的索引位置，如果改元素不存在，则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     *
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove faild.Require index >=0 and index <=size");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];

        }
        size--;
        data[size] = null;
        return ret;
    }


    public E removeFirst() {
        return remove(0);

    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d,capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

    }

}
