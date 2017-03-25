import java.util.Scanner;
public class discount
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            int items = scan.nextInt();
            int off = scan.nextInt();
            double sum = 0;
            for(int x = 0; x < items; x++)
            {
                int first = scan.nextInt();
                scan.next();
                double other = scan.nextDouble();
                sum += (first * other);
            }
            System.out.println(sum * (100 - off)/100);
        }
    }
}
