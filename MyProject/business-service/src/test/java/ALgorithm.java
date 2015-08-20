public class ALgorithm {


    private int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    static long startTime;
    static long endTime;

    public ALgorithm(int size) {
        this.theArray = new int[size];
        for (int i = 0; i < size; i++)
            addItemToArray((int) Math.random() * 100);
        this.arraySize = size - 1;
    }


    public static void main(String a[]) {

        ALgorithm aLgorithm = new ALgorithm(1000000);

        ALgorithm aLgorithm1 = new ALgorithm(14000000);

        ALgorithm aLgorithm3 = new ALgorithm(28000000);

        aLgorithm.search(1);
        aLgorithm1.search(1);
        aLgorithm3.search(1);

        aLgorithm.bubbleSort();
        aLgorithm1.bubbleSort();
        aLgorithm3.bubbleSort();

    }

    //Big O 1 or O(1)
    public void addItemToArray(int newItem) {
        theArray[itemsInArray++] = newItem;
    }


    //O(N)
    public void search(int item) {
        boolean valueInArray = false;
        String indexWithValue = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < theArray.length; i++) {
            if (theArray[i] == item) {
                valueInArray = true;
                indexWithValue += i + "";
            }
        }
        System.out.println("Value found in aaray" + valueInArray);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }


    //O(N^2)
    public void bubbleSort() {
        startTime = System.currentTimeMillis();

        for (int i = arraySize; i > 1; i--) {
            for (int j = 0; j > i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    int temp = theArray[j];
                    theArray[j] = theArray[j + 1];
                    theArray[j + 1] = temp;
                }

            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    //O(log N)
    public void binarySeach(){

    }

    //O(NlogN)
    public void quickSort(){

    }
}


