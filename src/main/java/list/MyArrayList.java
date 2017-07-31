package list;

import java.util.Objects;

/**
 * Created by chenwenning on 2017/7/29.
 * 自己实现一个ArrayList
 */
public class MyArrayList {

    private Object[] elementData;

    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.elementData = new Object[initialCapacity];
    }

    public int size() {
        return this.size;
    }

    public void add(Object obj) {
        //超过初始化的大小 实现数据的扩容
        if (size == elementData.length) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }

        elementData[size++] = obj;
    }

    public void remove(int index) {
        regeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(get(i))) {
                //删除
                remove(i);
                return true;
            }
        }
        return false;
    }

    private void regeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public Object get(int index) {
        regeCheck(index);
        return elementData[index];

    }

    public Object set(int index, Object object) {
        regeCheck(index);

        Object olVlue = (Objects) elementData[index];
        elementData[index] = object;
        return olVlue;
    }

    public Object add(int index,Object obj){
        regeCheck(index);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        return null;

    }


    public static void main(String args[]) {
        MyArrayList myList = new MyArrayList();
        myList.add("333");
        myList.add("434");
        myList.add("4");
        myList.add("43");
        myList.add("33433");
        myList.add("45");
        System.out.println(myList.size());
        System.out.println(myList.get(6));
    }

}
