package Section14.Bai1;

import java.io.*;

public class Main {
    public static void appendFile(File file, String newString) {
        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder oldContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                oldContent.append(line);
            }
            bufferedReader.close();

            String updatedContent = oldContent.toString() + newString + ". I am here";

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(updatedContent);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\baitapcty\\src\\main\\java\\Section14\\Bai1\\text.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Hello Trung Tam Java - File");
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
    if((line = bufferedReader.readLine())!= null){
        System.out.println(line);
    }
        appendFile(file,"");
         bufferedReader.close();
        FileReader fileReader1 = new FileReader(file);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        String line1;
        if((line1 = bufferedReader1.readLine())!= null){
            System.out.println(line1);
        }

    }
}
