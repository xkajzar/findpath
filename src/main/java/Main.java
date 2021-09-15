import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        start(System.in, args);
    }

    public static void start(InputStream input, String[] args) throws IOException{
        char[][] chararray;
        int height=0, width=0, mode;
        int sx=0, sy=0, fx=0, fy=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("File - 1 / Stdin - 2\n");
        mode = sc.nextInt();
        sc.nextLine();

        if(mode == 2){
            chararray = FindPathInputReaderStdIn.input();

        }

        else if(mode == 1) {
            System.out.print("Filename\n");
            String str = sc.nextLine();
            chararray=FindPathInputReaderFile.input(str);

        }
        else{
            System.out.print("Wrong input");
            return;
        }

        height = chararray.length;
        width = chararray[0].length;
        for(int i = 0; i<height; i++) {
            for(int j = 0; j<width;j++){
                if(chararray[i][j]=='S') {      //find start
                    sx = i;
                    sy = j;
                }
                if(chararray[i][j]=='X'){       //find finish
                    fx=i;
                    fy=j;
                }
            }
        }

    search(chararray, sx, sy, fx, fy, height, width);
    }

    public static void search(char[][] array, int sx, int sy, int fx, int fy, int height, int width){  //start, finish, xy - coords
        ArrayList<Block> list = new ArrayList();
        Block block = new Block(sx, sy, 0, null, Character.MIN_VALUE);
        list.add(block);
        int i=0;
        while(true) {

            try {
                block = list.get(i);
            }
            catch(Exception e){
                System.out.print("Path not found\n");
                return;
            }

            if (block.getPosx() == fx && block.getPosy() == fy) {       //Final condition check
                printBlock(block);
                return;
            }
            generateAdjacentBlocks(block, list, height, width, array);
            i++;
        }

    }

    public static void generateAdjacentBlocks(Block block, ArrayList list, int height, int width, char[][] array){  //Generates blocks adjacent
        Block newBlock;
        Block listBlock;
        boolean duplicate = false;
        if (block.getLastMove() != 'd' && block.getPosx()>0 && array[block.getPosx()-1][block.getPosy()]!='#') {     //Up
            newBlock = new Block(block.getPosx() - 1, block.getPosy(), block.getDistance() + 1, block, 'u');
            checkList(list, newBlock);
        }
        if (block.getLastMove() != 'u' && block.getPosx()<height-1 && array[block.getPosx()+1][block.getPosy()]!='#') {  //Down
            newBlock = new Block(block.getPosx() + 1, block.getPosy(), block.getDistance() + 1, block, 'd');
            checkList(list, newBlock);
        }
        if (block.getLastMove() != 'r' && block.getPosy()>0 && array[block.getPosx()][block.getPosy()-1]!='#') {     //Left
                newBlock = new Block(block.getPosx(), block.getPosy() - 1, block.getDistance() + 1, block, 'l');
                checkList(list, newBlock);
        }
        if (block.getLastMove() != 'l' && block.getPosy()<width-1 && array[block.getPosx()][block.getPosy()+1]!='#') {     //Right
            newBlock = new Block(block.getPosx(), block.getPosy() + 1, block.getDistance() + 1, block, 'r');
            checkList(list, newBlock);
        }
    }

    public static void checkList(ArrayList list, Block newBlock){       //checks arraylist, adds if not duplicate
        Block listBlock;
        for (int i = 0; i < list.size(); i++) {
            listBlock = (Block) list.get(i);
            if (newBlock.posx == listBlock.posx && newBlock.posy == listBlock.posy) {
                return;
            }
        }
        list.add(newBlock);
    }


    public static void printBlock(Block block){         //Final output
        int limit = block.getDistance();
        char[] print = new char[limit];

        for(int i = 0; i<limit; i++){
            print[i] = block.getLastMove();
            block = block.previous;
        }
        for(int i=limit-1; i>=0; i--){
            System.out.print(print[i]);
            System.out.print(',');
        }
    }
}

