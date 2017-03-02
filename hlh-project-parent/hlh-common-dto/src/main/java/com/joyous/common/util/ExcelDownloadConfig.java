//package com.joyous.common.util;
//
//import org.apache.poi.ss.usermodel.DataValidation;
//import org.apache.poi.ss.usermodel.DataValidationConstraint;
//import org.apache.poi.ss.usermodel.DataValidationHelper;
//import org.apache.poi.ss.util.CellRangeAddressList;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
//import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.awt.Color;
//
//public abstract class ExcelDownloadConfig {
//
//    private String fileName;
//
//    public ExcelDownloadConfig(String fileName)
//    {
//        this.fileName = fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    /**
//     * 获取下载模板的title信息
//     * @return
//     */
//    public abstract String[] getHead();
//
//    public XSSFWorkbook getXSSFWorkbook() {
//        return getDefaultConfig(getFileName(), getHead());
//    }
//
//    /**
//     * 设置首行cell的样式信息
//     * @return
//     */
//    public XSSFWorkbook getDefaultConfig(String sheetName, String[] headers) {
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet= workbook.createSheet(sheetName);
//        sheet.setDefaultColumnWidth(15);
//        setHeaderStyleAndVal(headers, workbook, sheet);
//        return workbook;
//    }
//
//    private void setHeaderStyleAndVal(String[] headers, XSSFWorkbook workbook, XSSFSheet sheet) {
//        //样式
//        XSSFCellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFillForegroundColor(new XSSFColor(new Color(253, 251, 219)));
//        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//        //字体
//        XSSFFont font = workbook.createFont();
//        font.setFontHeightInPoints((short) 12);
//        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
//        cellStyle.setFont(font);
//
//        XSSFRow row = sheet.createRow(0);
//        for (int i = 0; i< headers.length; i++) {
//            XSSFCell cell = row.createCell(i);
//            cell.setCellStyle(cellStyle);
//            cell.setCellValue(headers[i]);
//        }
//    }
//
//    /**
//     * 设置某些列的值只能输入预制的数据,显示下拉框
//     */
//    public void setExplicitValidation(XSSFSheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol) {
//        XSSFDataValidationConstraint constraint = new XSSFDataValidationConstraint(textlist);
//        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
//        DataValidationHelper help = new XSSFDataValidationHelper(sheet);
//        DataValidation validation = help.createValidation(constraint, regions);
//        validation.createErrorBox("输入值有误", "请从下拉框中选择！");
//        validation.setShowErrorBox(true);
//        sheet.addValidationData(validation);
//    }
//
//    /**
//     * 设置单元格格式为数值
//     */
//    public void setDecimalValidate(XSSFSheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
//        DataValidationConstraint constrain = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.DECIMAL, DataValidationConstraint.OperatorType.BETWEEN,"0","9999999999");
//        CellRangeAddressList region = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
//        DataValidationHelper help = new XSSFDataValidationHelper(sheet);
//        DataValidation validation = help.createValidation(constrain, region);
//        validation.createErrorBox("输入值类型或大小有误", "请输入有效数字！");
//        validation.setShowErrorBox(true);
//        sheet.addValidationData(validation);
//    }
//
//    /**
//     * 设置单元格格式为数值
//     */
//    public void setPhoneValidate(XSSFSheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
//        DataValidationConstraint constrain = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.DECIMAL, DataValidationConstraint.OperatorType.BETWEEN,"10000000000","99999999999");
//        CellRangeAddressList region = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
//        DataValidationHelper help = new XSSFDataValidationHelper(sheet);
//        DataValidation validation = help.createValidation(constrain, region);
//        validation.createErrorBox("输入值类型或大小有误", "请输入11位数字手机号码！");
//        validation.setShowErrorBox(true);
//        sheet.addValidationData(validation);
//    }
//}
