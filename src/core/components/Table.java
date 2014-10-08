package core.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.elements.CheckBox;
import core.general.GeneralObject;

public class Table extends GeneralObject{
	
	private static final String XPATH_FOR_TABLE 			= "//table";
	private static final String XPATH_FOR_HEADER 			= ".//thead/tr";
	private static final String XPATH_FOR_ROW 				= ".//tbody/tr";
	private static final String XPATH_FOR_CELL 				= ".//td";
	private static final String XPATH_FOR_CHECKBOX_CELL 	= ".//input";
	
	private final WebElement table;
	private final Map<String, String> properties = new HashMap<String, String>();

	public Table(WebDriver browser) {
		super(browser, "xpath", XPATH_FOR_TABLE);
		table = getGeneralObject();
		setElementProperties();
	}
	
	public void verifyNumberOfRowsIs(int expectedNumberOfRows){
		int actualNumberOfRows = getNumberOfRows();
		Assert.assertEquals(actualNumberOfRows, expectedNumberOfRows);
	}
	
	public void verifyAllTableColumnsAre(String expectedColumns){
		String[] expectedColumnsList = expectedColumns.split(";");
		List<String> actualColumnsList = getAllColumnNames();
		Assert.assertEquals(expectedColumnsList.length, actualColumnsList.size());
	
		for (String expectedColumn : expectedColumnsList)
			Assert.assertTrue(actualColumnsList.contains(expectedColumn));
	}
	
	public void checkCheckboxFromRowWithValueUnderColumn(String rowValue, String columnName){
		WebElement checkBoxElement = getElementFromRowWithValueUnderColumn(rowValue, columnName, "CheckBox");
		CheckBox checkBox = new CheckBox(browser, checkBoxElement);
		checkBox.check();
	}
	
	public void unCheckCheckboxFromRowWithValueUnderColumn(String rowValue, String columnName){
		WebElement checkBoxElement = getElementFromRowWithValueUnderColumn(rowValue, columnName, "CheckBox");
		CheckBox checkBox = new CheckBox(browser, checkBoxElement);
		checkBox.unCheck();
	}
	
	private int getNumberOfRows(){
		List<WebElement> allTableRows = getAllTableRows();
		return allTableRows.size();
	}
	
	private List<WebElement> getAllTableRows(){
		List<WebElement> allTableRows = table.findElements(By.xpath(XPATH_FOR_ROW));
		return allTableRows;
	}
	
	private List<String> getAllColumnNames(){
		WebElement tableHeader = table.findElement(By.xpath(XPATH_FOR_HEADER));
		List<WebElement> allColumnElements = tableHeader.findElements(By.xpath(XPATH_FOR_CELL));
		List<String> allColumnNames = new ArrayList<String>();
		
		for (WebElement columnElement : allColumnElements)
			allColumnNames.add(columnElement.getText());
		
		return allColumnNames;
	}
	
	private int getIndexForColumn(String columnName){
		List<String> allColumnNames = getAllColumnNames();
		Assert.assertTrue(allColumnNames.contains(columnName));
		return allColumnNames.indexOf(columnName);
	}
	
	private List<WebElement> getAllCellsForRow(WebElement row){
		List<WebElement> allRowCells = row.findElements(By.xpath(XPATH_FOR_CELL));
		return allRowCells;
	}
	
	private List<String> getAllCellDataForRow(WebElement row){
		List<String> allCellValuesForRow = new ArrayList<String>();
		for (WebElement rowElement : getAllCellsForRow(row)) {
			allCellValuesForRow.add(rowElement.getText());
		}
		return allCellValuesForRow;
	}
	
	private List<String> getAllValuesUndeColumn(String columnName){
		int columnIndex = getIndexForColumn(columnName);
		List<WebElement> allRows = getAllTableRows();
		List<String> allRowData = new ArrayList<String>();
		for (WebElement row : allRows)
			allRowData.add(getAllCellDataForRow(row).get(columnIndex));
			
		return allRowData;
	}
	
	private WebElement getElementFromRowWithValueUnderColumn(String rowValue, String columnName, String elementType){
		List<String> allValuesForColumn = getAllValuesUndeColumn(columnName);
		Assert.assertTrue(allValuesForColumn.contains(rowValue));
		int rowIndex = allValuesForColumn.indexOf(rowValue);
		WebElement rowElement = getAllTableRows().get(rowIndex);
		WebElement element = rowElement.findElement(By.xpath(getElementProperties(elementType)));

		return element;
	}
	
	private String getElementProperties(String elementType){
		return properties.get(elementType);
	}
	
	private void setElementProperties() {
		properties.put("CheckBox", XPATH_FOR_CHECKBOX_CELL);
	}
}
