package JavaPackage;

import util.ExcelUtils;


public class ReadExcelFile {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String fileName = projectPath + "/datafiles/file_example_XLSX_10.xlsx";
        int sheetIndex = 0;
        ExcelUtils excelUtils = new ExcelUtils(fileName,sheetIndex);

        int rowCount = excelUtils.getRowCount();
        System.out.println("rowCount : " + rowCount);

        double cellDataDouble = excelUtils.getCellDataNumber(1,0);
        System.out.println("cellData : " + cellDataDouble);

        String contactInformation = excelUtils.getCellDataString(1,1);
        System.out.println("cellData : " + contactInformation);

        String firstName
                = excelUtils.getCellDataString(1,2);
        System.out.println("cellData : " + firstName);


    }
}
