package core.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.elements.CheckBox;
import core.elements.GeneralElement;
import core.utils.MessageCollector;
import core.utils.TestAction;
import static core.utils.AssertUtils.*;
import static core.utils.MultiBrowser.*;

public class Table extends GeneralElement{
	
	private static final String XPATH_FOR_HEADER 			= ".//thead/tr";
	private static final String XPATH_FOR_ROW 				= ".//tbody/tr";
	private static final String XPATH_FOR_CELL 				= ".//td";
	private static final String XPATH_FOR_CHECKBOX_CELL 	= ".//input";
	
	private WebElement table;
	private final Map<String, String> properties = new HashMap<String, String>();

	public Table(WebDriver browser, String elementLocator, String elementIdentifier, MessageCollector collector) {
		super(browser, elementLocator, elementIdentifier, collector);
		setElementProperties();
	}
	
	public void verifyNumberOfRowsIs(int expectedNumberOfRows){
		setElement();
		int actualNumberOfRows = getNumberOfRows();
		isEqual("", actualNumberOfRows, expectedNumberOfRows, TestAction.CONTINUE, browser, collector);
	}
	
	public void verifyAllTableColumnsAre(String expectedColumns){
		setElement();
		String[] expectedColumnsList = expectedColumns.split(";");
		List<String> actualColumnsList = getAllColumnNames();
		isEqual("Failed. Expected list of columns: " + expectedColumns + 
				"'. Actual list of columns: " + actualColumnsList, 
				actualColumnsList, Arrays.asList(expectedColumnsList), TestAction.CONTINUE, browser, collector);
	}
	
	public void checkCheckboxFromRowWithValueUnderColumn(String rowValue, String columnName){
		setElement();
		WebElement checkBoxElement = getElementFromRowWithValueUnderColumn(rowValue, columnName, "CheckBox");
		CheckBox checkBox = new CheckBox(browser, checkBoxElement, collector);
		checkBox.check();
	}
	
	public void unCheckCheckboxFromRowWithValueUnderColumn(String rowValue, String columnName){
		setElement();
		WebElement checkBoxElement = getElementFromRowWithValueUnderColumn(rowValue, columnName, "CheckBox");
		CheckBox checkBox = new CheckBox(browser, checkBoxElement, collector);
		checkBox.unCheck();
	}
	
	private void setElement(){
		super.setObject();
		table = getGeneralObject();
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
		isTrue("", allColumnNames.contains(columnName), TestAction.CONTINUE, browser, collector);
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
		isTrue("", allValuesForColumn.contains(rowValue), TestAction.CONTINUE, browser, collector);
		int rowIndex = allValuesForColumn.indexOf(rowValue);
		WebElement rowElement = getAllTableRows().get(rowIndex);
		WebElement element = getElement(rowElement, "xpath", getElementProperties(elementType));

		return element;
	}
	
	private String getElementProperties(String elementType){
		return properties.get(elementType);
	}
	
	private void setElementProperties() {
		properties.put("CheckBox", XPATH_FOR_CHECKBOX_CELL);
	}
}
