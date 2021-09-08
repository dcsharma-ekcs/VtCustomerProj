package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CsvUtils {


    public Iterator<Object []> csvDataProvider(String csvFileName ) throws InterruptedException, IOException {
        List<Object []> csvData = new ArrayList<>();
        String[] data= null;
        BufferedReader br = null;
        String line = null;
        String cvsSplitBy = ",";

        String projectPath = System.getProperty("user.dir");
        String csvFile;
        csvFile = projectPath + csvFileName;

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data= line.split(cvsSplitBy);
            csvData.add(data);
        }

        return csvData.iterator();
    }

    public List<String> csvRowDataProvider(String csvFileName, int rowNumber ) throws InterruptedException, IOException {
        List<List<String>> records = new ArrayList<>();
        String[] data= null;
        BufferedReader br = null;
        String line = null;
        String cvsSplitBy = ",";

        String projectPath = System.getProperty("user.dir");
        String csvFile;
        csvFile = projectPath + csvFileName;

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data= line.split(cvsSplitBy);
            records.add(Arrays.asList(data));
        }

        return records.get(rowNumber);
    }

}
