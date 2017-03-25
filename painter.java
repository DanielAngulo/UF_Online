import java.util.*;

public class painter
{
    static class Cell
    {
        char color;
        int order;

        public Cell(char c, int o)
        {
            color = c;
            order = 0;
        }
    }

    static class Shape implements Comparable<Shape>
    {
        int startX;
        int endX;
        int startY;
        int endY;
        char color;
        int order;

        public Shape(int startX, int endX, int startY, int endY, char color, int order)
        {
            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY;
            this.color = color;
            this.order = order;
        }

        @Override
        public int compareTo(Shape s)
        {
            return -new Integer(order).compareTo(s.order);
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            int rows = scan.nextInt(), cols = scan.nextInt(), objects = scan.nextInt();
            Cell[][] grid = initialize(rows, cols);
            TreeSet<Shape> shapes = new TreeSet<Shape>();
            for(int j = 0; j < objects; j++)
            {
                int[] upperLeft = {scan.nextInt(), scan.nextInt()};
                int[] bottomRight = {scan.nextInt(), scan.nextInt()};
                char color = scan.next().charAt(0);
                int order = scan.nextInt();
                int startX = upperLeft[0];
                int endX = bottomRight[0];
                int startY = upperLeft[1];
                int endY = bottomRight[1];
                Shape add = new Shape(startX, endX, startY, endY, color, order);
                shapes.add(add);
            }
            for(Shape s : shapes)
            {
                int times =  s.endX - s.startX;
                for(int current = 0; current <= times; current++)
                {
                    for(int y = s.startY; y <= s.endY; y++)
                    {
                        grid[s.startX + current][y] = new Cell(s.color, s.order);
                    }
                }
            }
            for(Cell[] array : grid)
            {
                String print = "";
                for(Cell c : array)
                    print += c.color;
                System.out.println(print);
            }
        }
    }

    public static Cell[][] initialize(int rows, int cols)
    {
        Cell[][] grid = new Cell[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            for(int x = 0; x < cols; x++)
                grid[i][x] = new Cell('#', 0);
        }
        return grid;
    }
}
