import java.io.File;
/*
For every file in the directory,
*/
public class Q4 {
    public static void main(String[] args) {
        File dir = new File("C:/Users/Simon/Documents/Github");
        listAllFiles(dir);
    }
    public static void listAllFiles(File dir) {
        File[] list = dir.listFiles();
        String s = "";

        for (File x: list) {
            if (x.isDirectory()) {
                File n = new File(x.getAbsolutePath());
                System.out.println( s + "[Folder " + n.getName() + "]");;
                listAllFiles(x);

            } else {
                s += " ";
                listAllFiles(x, s);
            }
        }
    }
    public static void listAllFiles(File dir, String spaces) {
        System.out.println(spaces + dir.getName());
    }
}