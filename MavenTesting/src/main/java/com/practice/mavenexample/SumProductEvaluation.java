package com.practice.mavenexample;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.POILogger;

import java.io.FileInputStream;


public class SumProductEvaluation {
    public static void printHelp() throws Exception {
        // activate logging to console
        System.setProperty("org.apache.poi.util.POILogger", "org.apache.poi.util.SystemOutLogger");
        System.setProperty("poi.log.level", POILogger.INFO + "");
        // open your file
        //   Workbook wb = new HSSFWorkbook(new FileInputStream("MavenTesting/src/main/resources/foo.xls"));
        Workbook wb = new HSSFWorkbook(new FileInputStream("MavenTesting/src/main/resources/LDP_Restore_eff_20210101_15.xls"));
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        // get your cell
        Sheet sheet = wb.getSheet("aLOSSHISTORY");

        System.out.println("sheet Name : " + sheet.getSheetName());
        // System.out.println("row nu,ber : "+ + sheet.getRow(39).toString());
        //  System.out.println("row nu,ber : "+ + sheet.getRow(39).getCell(12));

        //Cell cell = sheet.getRow(8).getCell(12);        // just a dummy example
        Cell cell = sheet.getRow(38).getCell(12);        // just a dummy example
        // perform debug output for the next evaluate-call only
        evaluator.setDebugEvaluationOutputForNextEval(true);
        System.out.println("row nu,ber : " + sheet.getRow(38).getCell(12).getCellComment());
        // System.out.println("Cell value : " + cell.getCellFormula());
        evaluator.evaluateFormulaCell(cell);

        // System.out.println("Cell value 1: " + cell.getCellComment());
        System.out.println("Cell value2 : " + cell.getStringCellValue());
        // System.out.println("Cell value 3: " + cell.getLocalDateTimeCellValue());
        //  Sumproduct sumproduct =evaluator.evaluate()
        // no logging performed for this next evaluate-call
    }

    public static void main(String arg[]) {
        SumProductEvaluation sumProductEvaluation = new SumProductEvaluation();
        try {
            sumProductEvaluation.printHelp();
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getLocalizedMessage());
        }


    }

}
