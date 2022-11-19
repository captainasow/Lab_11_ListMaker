import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        final String menu = "\nA - Add  D - Delete  P - Print  - Q - Quit";
        boolean done = false;
        String cmd = "";


        do
        {
            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    add(console);
                    break;
                case "D":
                    delete(console);
                    break;
                case "P":
                    System.out.println("\nPrinting your list...\n");
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }
        }
        while(!done);
    }

    private static void displayList()
    {
        System.out.println("                 Your list:                ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0)
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("|" + "%3d%35s   |\n", i+1, list.get(i) );
            }
        }
        else
            System.out.println("|                   Empty                 |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }

    public static String add(Scanner pipe)
    {
        String retVal = "";
        boolean done = false;

        do{
            System.out.println("What would you like to add?");
            retVal = pipe.nextLine();
            list.add(retVal);
            System.out.println("'" + retVal + "'" + " has been added to the list.\n");
            done = true;
        }while (!done);
        return retVal;
    }

    public static Integer delete(Scanner pipe)
    {
        Integer retVal;
        boolean done = false;
        int low = 1;
        int number = 0;

        do{
            number = SafeInput.getRangedInt(pipe, "What item do you want to delete?", low, list.size());
            list.remove(number - 1);

            done = true;
        }while (!done);
        return number;
    }

}