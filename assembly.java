import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class assembly
{
    static String[][] program;
    static int[] registers;
    static HashMap<String, Integer> labels = new HashMap<>();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            registers = new int[17];
            int lines = scan.nextInt();
            scan.nextLine();
            program = new String[lines][];
            for(int x = 0; x < lines; x++)
            {
                String[] line = scan.nextLine().replaceAll(",", "").split(" ");
                program[x] = line;
                if(isLabel(line[0]))
                {
                    labels.put(line[0].substring(0, line[0].length() - 1), x);
                }
            }
            run(0);
            System.out.println(Arrays.toString(registers).substring(4).replaceAll(",", "").replaceAll("]", ""));
        }
    }

    public static void run(int num)
    {
        if(num == program.length)
            return;
        String[] line = program[num];
        {
            if(line[0].equals("add"))
            {
                if(line[2].startsWith("$"))
                {
                    registers[Integer.parseInt(line[1].substring(1))] += registers[Integer.parseInt(line[2].substring(1))];
                }
                else
                {
                    registers[Integer.parseInt(line[1].substring(1))] += Integer.parseInt(line[2]);
                }
                run(num + 1);
            }
            else if(line[0].equals("jne"))
            {
                int first = Integer.parseInt(line[1].substring(1));
                int second = Integer.parseInt(line[2].substring(1));
                if(registers[first] != registers[second])
                {
                    run(labels.get(line[3]) + 1);
                }
                else
                    run(num + 1);
            }
            else if(line[0].equals("mov"))
            {
                if(!line[2].startsWith("$"))
                    registers[Integer.parseInt(line[1].substring(1))] = Integer.parseInt(line[2]);
                else
                    registers[Integer.parseInt(line[1].substring(1))] = registers[Integer.parseInt(line[2].substring(1))];
                run(num + 1);
            }
            else
                run(num + 1);
        }
    }

    public static boolean isLabel(String str)
    {
        return str.endsWith(":");
    }
}
