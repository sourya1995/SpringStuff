package com.sourya.batchapp.dictionary;

public class IngesterQueries {
	public static String SALES_TABLE = "SALES";
	
	public static String INSERT_QUERY_SALES = "INSERT INTO" + SALES_TABLE + "(SELLER_ID, SALES_DATE, PRODUCT, QUANTITY)" + " VALUES (?, ?, ?, ?)";

}
