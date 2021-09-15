import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{
    public static char[][] input(){
        char[][] chararray;
        int height, width;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width\n");
        width = sc.nextInt();
        System.out.print("Enter height\n");
        height = sc.nextInt();
        chararray = new char[height][width];
        sc.nextLine();                              //last newline
        System.out.print("Enter maze\n");

        for(int i = 0; i<height; i++){
            chararray[i] = sc.nextLine().toCharArray();
        }

        return chararray;
    }
}
