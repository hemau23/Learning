
import java.util.*;
import java.lang.*;

public class HashFunction {

    String [] theArray;
    int arraySize;
    int ItemInArray=0;

    public static void main(String a[]){
        HashFunction theFunc= new HashFunction();
        ArrayList<Integer> arrayList= new ArrayList<Integer>();
        Integer pivot = theFunc.findPivot(arrayList, 0, arrayList.size() - 1);
        System.out.println(pivot);
        arrayList.add(4);
        pivot = theFunc.findPivot(arrayList, 0, arrayList.size() - 1);
        System.out.println(pivot);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(7);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        pivot = theFunc.findPivot(arrayList, 0, arrayList.size() - 1);
        System.out.println(pivot);


        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(0,3);
        l.add(4);

        for(int i:l){
            System.out.println("hemant "+i);
        }


    }

    public Integer findPivot(ArrayList<Integer> arrayList,Integer start, Integer end) {

        //1st Base condition
        if(start>end) return -1;

        //2nd base condition
        if(start==end) return arrayList.get(start);

        Integer mid = (start+end)/2;
        //3rd condition
        if(start < end && arrayList.get(mid)> arrayList.get(end)) return arrayList.get(mid);
        if(start > end && arrayList.get(mid) < arrayList.get(start)) return arrayList.get(mid-1);

        if (arrayList.get(mid) > arrayList.get(start)) findPivot(arrayList,mid+1,end);
        else findPivot(arrayList,start,mid-1);

        return -1;
    }

    public void yLinkList(){

    }
}


