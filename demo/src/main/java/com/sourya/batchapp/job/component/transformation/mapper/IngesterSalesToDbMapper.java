package com.sourya.batchapp.job.component.transformation.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.spark.api.java.function.MapPartitionsFunction;
import org.apache.spark.sql.Row;

import com.sourya.batchapp.dictionary.IngesterQueries;
import com.sourya.batchapp.persistence.manager.DatabaseConnManager;
import com.sourya.batchapp.schema.SalesSchema;

public class IngesterSalesToDbMapper implements MapPartitionsFunction<Row, Row> {
	private DatabaseConnManager connManager;

    public IngesterSalesToDbMapper(DatabaseConnManager connManager) {
        this.connManager = connManager;
    }

    @Override
    public Iterator<Row> call(Iterator<Row> iterator) throws Exception {
        return doRowsBatchInsert(iterator);
    }

    private Iterator<Row> doRowsBatchInsert(Iterator<Row> iterator) throws SQLException {
        try (Connection connection = connManager.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(IngesterQueries.INSERT_QUERY_SALES)) {
           //Loop through DataFrame's received rows within the iterator and persist to DB
            while(iterator.hasNext()) {
                int index = 1;
                Row row = iterator.next();
                stmt.setString(index++, row.getAs(SalesSchema.SELLER_ID.name()));
                stmt.setDate(index++, row.getAs(SalesSchema.DATE.name()));
                stmt.setString(index++, row.getAs(SalesSchema.PRODUCT.name()));
                stmt.setLong(index++, row.getAs(SalesSchema.QUANTITY.name()));
                stmt.addBatch();
            }
            //Once all the rows have been added as batch statements, execute against the DB
            stmt.executeBatch();
        } catch (SQLException sqlException) {
            //Do some logging here and re throw Exception
            throw sqlException;
        }
        return iterator;
    }

}
