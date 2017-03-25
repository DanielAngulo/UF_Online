import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class jumper
{
    static int[][] distances;
    static int platforms;
    static int goal;
    static int potential;
    static HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();
    static boolean printed = false;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            platforms = scan.nextInt();
            potential = scan.nextInt();
            int startIndex = scan.nextInt();
            goal = scan.nextInt();
            distances = new int[platforms][platforms];
            for(int x = 0; x < platforms; x++)
            {
                visited.put(x, new HashSet<>());
                for(int y = 0; y < platforms; y++)
                {
                    distances[x][y] = scan.nextInt();
                }
            }
            jump(startIndex);
            System.out.println(printed? "EASY" : "IMPOSSIBLE");
        }
    }

    public static void jump(int current)
    {
        if(current == goal)
        {
            printed = true;
            return;
        }
        for(int i = 0; i < platforms; i++)
        {
            if(i != current)
            {
                if(!visited.get(current).contains(i))
                {
                    if(distances[i][current] <= potential)
                    {
                        visited.get(current).add(i);
                        visited.get(i).add(current);
                        jump(i);
                    }
                }
            }
        }
    }
}
