import java.io.*;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    static char[][] input(String filename) throws IOException {
        int i = 1, len=0;

        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        str=br.readLine();
        len = str.length();

        while((str=br.readLine())!=null){
            i++;
        }
        int size=i;
        fis.getChannel().position(0);
        char[][] array = new char[size][len];

        for(i=0; i<size; i++){
            array[i]=br.readLine().toCharArray();
        }

        return array;
    }
}
