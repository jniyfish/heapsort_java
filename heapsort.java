import java.util.*;
import static java.lang.System.out;
import java.util.Scanner;


public class heapsort {

    public static void main(String[] args) {

    
        Scanner scanner = new Scanner(System.in);
        int[] nums;
        int n=1,input=0;
        nums = new int[100];

        while(true)
        {
            System.out.println("insert input,-999 to end");
            input = scanner.nextInt();
            if(input==-999)
            {
                nums[0]=-999;
                break;
            }
            else{
                nums[n] = input;
                n++;
            }
        }

        heap Heap = new heap();
        Heap.initial(nums);
        for (int i = 1; i < n; i++) {
            Heap.exMax(nums, n);
        }
    }

}

class heap {

    public void initial(int[] input) {
        int n=input.length/2-1;
        for(int i=n;i>=1;i--)
        {
            adjust(input, i, (n+1)*2);
        }
      
    }

    public void adjust(int[] input, int pos,int n) {
        int temp = input[pos];
        int j=2*pos;
        while(j<=n)
        {
            if(j<n)
                if(input[j]<input[j+1])
                    j=j+1;
            if(temp>=input[j])
                break;
            else{
                input[j/2] = input[j];
                j=2*j;
            }
            input[j/2] = temp;
        }
    }
    public void exMax(int[] input,int n)
    {
        System.out.println(input[1]);
        input[1] = input[n];
        n--;
        adjust(input, 1, n);
    }
}
