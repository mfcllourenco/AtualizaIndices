import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SalvarArquivo {

    public void salvarIndiceNoArquivo(Map<String, String> mapIndices) {

        final String outputFilePath = System.getProperty("user.home") + "/Downloads/indices.txt";
        System.out.println(outputFilePath.toString());

        File file = new File(outputFilePath);

        if (file.exists()) file.delete();

        BufferedWriter bf = null;

        try {

            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            //iterate map entries
            for (Map.Entry<String, String> entry : mapIndices.entrySet()) {

                //put key and value separated by a colon
                bf.write(entry.getKey() + ";" + entry.getValue());

                //new line
                bf.newLine();
            }

            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                //always close the writer
                bf.close();
            } catch (Exception e) {
            }
        }
    }
}
