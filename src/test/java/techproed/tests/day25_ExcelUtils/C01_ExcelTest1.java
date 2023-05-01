package techproed.tests.day25_ExcelUtils;

import org.testng.annotations.Test;
import techproed.utilities.ExcelUtils;

public class C01_ExcelTest1 {
    @Test
    public void testName() {

        String path = "src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa="customer_info";
        ExcelUtils excelUtils=new ExcelUtils(path,sayfa);
        System.out.println(excelUtils.getCellData(1, 0));
        String email = excelUtils.getCellData(1,0);
        String password = excelUtils.getCellData(1,1);
        System.out.println("email: "+email+" || " +"password: "+ password);

        System.out.println("kac sutun var: "+excelUtils.columnCount());

    }


}
