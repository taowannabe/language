

public class LeeCode{

  /*在一个数组里面移除指定value? 并且返回新的数组长度?
这题唯一需要注意的地方在于 in place ? 不能新建另一个数?
  */
    public static void removeElement(int[] array,int value){
        int i = 0;
        int j = 0;
        for(int len = array.length;i<len;i++){
            if(array[i]==value){
                continue;
            }
            array[i]=array[j];
            j++;
        }
        System.out.println(j);
    }
    /*这道题目与前一题Remove Element比较类似? 但是在一个排序好的数组里面删除重复的元素?
    */
    public static void removeDuplicate(int[] sortedArray){
        int i = 1;
        int j = 0;

        if(sortedArray.length<1)
            return;

        for(int len = sortedArray.length;i<len;i++){
            if(sortedArray[j]!=sortedArray[i]){
               sortedArray[++j]=sortedArray[i];
            }

        }
        System.out.println(j+1);
    }


    public static void main(String[] args){
       // removeElement(new int[]{1,2,3,4,3}, 3);
       removeDuplicate(new int[]{1,2,3,3,3,3,4,5,5,5,5});
       removeDuplicate(new int[]{1,2,3,4,5,6});

    }
    public int i;
}
