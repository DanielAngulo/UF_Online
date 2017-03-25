import java.util.Scanner;
public class greater
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            long first = scan.nextLong();
            long second = scan.nextLong();
            if(first > second)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
