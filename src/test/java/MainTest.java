import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;


class MainTest {
    @Test
    public void test() throws IOException {
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("test.txt"));
        PrintStream oldps = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        System.setIn(fips);
        Main.start(original, args);
        System.setIn(original);
        String str = baos.toString();



        String str2 = "File - 1 / Stdin - 2\n" +            //correct output including the prompts
                "Filename\n" +
                "d,d,l,l,l,l,l,l,u,u,u,u,u,u,u,u,u,u,l,l,l,l,l,l,l,l,l,l,l,l,l,l,l,u,u,l,l,l,";


        System.out.flush();
        System.setOut(oldps);

        Assertions.assertEquals(str, str2);
    }

}