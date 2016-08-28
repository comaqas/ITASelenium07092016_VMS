package elements;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;


public class TablePageElement {

    private SelenideElement webTable;

    public TablePageElement(SelenideElement webTable){
        this.webTable = webTable;
    }


    public SelenideElement getWebTable(){
        return webTable;
    }


    public void setWebTable(SelenideElement webTable) {
        this.webTable = webTable;
    }


    public int getRowsNumber(){
        return webTable.$$(By.tagName("tr")).size();
    }


    public int getColumnsNumber(){
        List<SelenideElement> rows = webTable.$$(By.tagName("tr"));
        SelenideElement tableHeader = rows.get(0);
        return tableHeader.$$(By.tagName("td")).size();
    }


    public SelenideElement getCell(int rowIndex, int columnIndex){
        List<SelenideElement> rows = webTable.$$(By.tagName("tr"));
        SelenideElement targetRow = rows.get(rowIndex-1);
        return targetRow.$$(By.tagName("td")).get(columnIndex-1);
    }


    public int[] getTableDimension(SelenideElement webTable){
        int[] tableDimension = new int[2];

        List<SelenideElement> rows = webTable.$$(By.tagName("tr"));
        tableDimension[0] = rows.size();

        SelenideElement tableHeader = rows.get(0);
        tableDimension[1] = tableHeader.$$(By.tagName("td")).size();

        return tableDimension;
    }


    public String getCellValue(SelenideElement webTable, int rowIndex, int columnIndex){
        List<SelenideElement> rows = webTable.$$(By.tagName("tr"));
        SelenideElement targetRow = rows.get(rowIndex-1);
        SelenideElement targetCell = targetRow.$$(By.tagName("td")).get(columnIndex-1);
        return targetCell.getValue();
    }


    public String getCellText(SelenideElement webTable, int rowIndex, int columnIndex){
        List<SelenideElement> rows = webTable.$$(By.tagName("tr"));
        SelenideElement targetRow = rows.get(rowIndex-1);
        SelenideElement targetCell = targetRow.$$(By.tagName("td")).get(columnIndex-1);
        return targetCell.getText();
    }


    public ArrayList<String> getCellsTextFromTargetRow(SelenideElement webTable, int rowIndex){
        List<SelenideElement> rows = webTable.$$(By.tagName("tr"));
        SelenideElement targetRow = rows.get(rowIndex-1);

        List<SelenideElement> cellsFromTargetRow = targetRow.$$(By.tagName("td"));

        ArrayList<String> cellsTextFromTargetRow = new ArrayList<String>();

        for (int i = 0; i < cellsFromTargetRow.size(); i++){
            cellsTextFromTargetRow.add(cellsFromTargetRow.get(i).getText());
        }

        return cellsTextFromTargetRow;
    }

}
