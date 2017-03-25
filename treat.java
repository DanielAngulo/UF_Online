import java.util.Scanner;
public class treat
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            int total = scan.nextInt();
            int visit = scan.nextInt();
            int[] nums = new int[total];
            for(int x = 0; x < total; x++)
            {
                nums[x] = scan.nextInt();
            }
            int max = 0;
            for(int x = 0; x <= total - visit; x++)
            {
                int sum = 0;
                for(int y = 0; y < visit; y++)
                {
                    sum += nums[x + y];
                }
                max = Math.max(sum, max);
            }
            System.out.println(max);
        }
    }
}
