package com.jn.sqlhelper.common.resultset;

import com.jn.langx.util.ThrowableFunction;
import com.jn.langx.util.Throwables;
import com.jn.langx.util.collection.Arrs;
import com.jn.langx.util.collection.Collects;
import com.jn.langx.util.function.Consumer;
import com.jn.sqlhelper.common.ddl.model.internal.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.List;

@SuppressWarnings({"unused"})
public class ResultSetDescription {
    private static final Logger logger = LoggerFactory.getLogger(ResultSetDescription.class);

    public ResultSetDescription(final ResultSetMetaData resultSetMetaData) {
        parseColumnCount(resultSetMetaData);
        parseIsAutoIncrement(resultSetMetaData);
        parseIsCaseSensitive(resultSetMetaData);
        parseIsSearchable(resultSetMetaData);
        parseIsCurrency(resultSetMetaData);
        parseIsNullable(resultSetMetaData);
        parseIsSigned(resultSetMetaData);
        parseColumnDisplaySizes(resultSetMetaData);
        parseColumnNames(resultSetMetaData);
        parseColumnLabels(resultSetMetaData);
        parsePrecisions(resultSetMetaData);
        parseScales(resultSetMetaData);
        parseSchemaNames(resultSetMetaData);
        parseTableNames(resultSetMetaData);
        parseCatalogNames(resultSetMetaData);
        parseColumnTypes(resultSetMetaData);
        parseColumnJdbcTypeNames(resultSetMetaData);
        parseColumnClassNames(resultSetMetaData);
        parseIsReadOnly(resultSetMetaData);
        parseIsWritable(resultSetMetaData);
        parseIsDefinitelyWritable(resultSetMetaData);
    }

    private int columnCount;

    public int getColumnCount() {
        return columnCount;
    }

    private void parseColumnCount(final ResultSetMetaData resultSetMetaData) {
        this.columnCount = Throwables.ignoreThrowable(logger, 0, new ThrowableFunction<Object, Integer>() {
            @Override
            public Integer doFun(Object o) throws Throwable {
                return resultSetMetaData.getColumnCount();
            }
        }, resultSetMetaData);

    }

    private List<Boolean> isAutoIncrement;

    /**
     * Indicates whether the designated column is automatically numbered.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isAutoIncrement(int column) {
        return isAutoIncrement.get(column - 1);
    }

    private void parseIsAutoIncrement(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isAutoIncrement = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isAutoIncrement.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isAutoIncrement(column);
                    }
                }, column));
            }
        });
        this.isAutoIncrement = isAutoIncrement;
    }

    private List<Boolean> isCaseSensitive;

    /**
     * Indicates whether a column's case matters.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isCaseSensitive(int column) {
        return isCaseSensitive.get(column - 1);
    }

    private void parseIsCaseSensitive(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isCaseSensitive = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isCaseSensitive.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isCaseSensitive(column);
                    }
                }, column));
            }
        });
        this.isCaseSensitive = isCaseSensitive;
    }

    private List<Boolean> isSearchable;

    /**
     * Indicates whether the designated column can be used in a where clause.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isSearchable(int column) {
        return isSearchable.get(column - 1);
    }

    private void parseIsSearchable(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isSearchable = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isSearchable.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isSearchable(column);
                    }
                }, column));
            }
        });
        this.isSearchable = isSearchable;
    }


    private List<Boolean> isCurrency;

    /**
     * Indicates whether the designated column is a cash value.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isCurrency(int column) {
        return isCurrency.get(column - 1);
    }

    private void parseIsCurrency(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isCurrency = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isCurrency.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isSearchable(column);
                    }
                }, column));
            }
        });
        this.isCurrency = isCurrency;
    }


    private List<Integer> isNullable;

    /**
     * Indicates the nullability of values in the designated column.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return the nullability status of the given column; one of <code>columnNoNulls</code>,
     * <code>columnNullable</code> or <code>columnNullableUnknown</code>
     */
    public int isNullable(int column) {
        return isNullable.get(column - 1);
    }

    private void parseIsNullable(final ResultSetMetaData resultSetMetaData) {
        final List<Integer> isNullable = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isNullable.add(Throwables.ignoreThrowable(logger, columnNullableUnknown, new ThrowableFunction<Integer, Integer>() {
                    @Override
                    public Integer doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isNullable(column);
                    }
                }, column));
            }
        });
        this.isNullable = isNullable;
    }

    /**
     * The constant indicating that a
     * column does not allow <code>NULL</code> values.
     */
    public static final int columnNoNulls = 0;

    /**
     * The constant indicating that a
     * column allows <code>NULL</code> values.
     */
    int columnNullable = 1;

    /**
     * The constant indicating that the
     * nullability of a column's values is unknown.
     */
    public static final int columnNullableUnknown = 2;


    private List<Boolean> isSigned;

    /**
     * Indicates whether values in the designated column are signed numbers.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isSigned(int column) {
        return isSigned.get(column - 1);
    }

    private void parseIsSigned(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isSigned = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isSigned.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isSigned(column);
                    }
                }, column));
            }
        });
        this.isSigned = isSigned;
    }


    private List<Integer> columnDisplaySizes;

    /**
     * Indicates the designated column's normal maximum width in characters.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return the normal maximum number of characters allowed as the width
     * of the designated column
     */
    public int getColumnDisplaySize(int column) {
        return columnDisplaySizes.get(column - 1);
    }

    private void parseColumnDisplaySizes(final ResultSetMetaData resultSetMetaData) {
        final List<Integer> columnDisplaySizes = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                columnDisplaySizes.add(Throwables.ignoreThrowable(logger, columnNullableUnknown, new ThrowableFunction<Integer, Integer>() {
                    @Override
                    public Integer doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getColumnDisplaySize(column);
                    }
                }, column));
            }
        });
        this.columnDisplaySizes = columnDisplaySizes;
    }


    private List<String> columnLabels;

    /**
     * Gets the designated column's suggested title for use in printouts and
     * displays. The suggested title is usually specified by the SQL <code>AS</code>
     * clause.  If a SQL <code>AS</code> is not specified, the value returned from
     * <code>getColumnLabel</code> will be the same as the value returned by the
     * <code>getColumnName</code> method.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return the suggested column title
     */
    public String getColumnLabel(int column) {
        return columnLabels.get(column - 1);
    }

    private void parseColumnLabels(final ResultSetMetaData resultSetMetaData) {
        final List<String> columnLabels = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                columnLabels.add(Throwables.ignoreThrowable(logger, getColumnName(column), new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getColumnLabel(column);
                    }
                }, column));
            }
        });
        this.columnLabels = columnLabels;
    }


    private List<String> columnNames;

    /**
     * Get the designated column's name.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return column name
     */
    public String getColumnName(int column) {
        return columnNames.get(column - 1);
    }

    private void parseColumnNames(final ResultSetMetaData resultSetMetaData) {
        final List<String> columnNames = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                columnNames.add(Throwables.ignoreThrowable(logger, "_UNKnown_", new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getColumnName(column);
                    }
                }, column));
            }
        });
        this.columnNames = columnNames;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    private List<String> schemaNames;

    /**
     * Get the designated column's table's schema.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return schema name or "" if not applicable
     */
    public String getSchemaName(int column) {
        return schemaNames.get(column - 1);
    }

    private void parseSchemaNames(final ResultSetMetaData resultSetMetaData) {
        final List<String> schemaNames = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                schemaNames.add(Throwables.ignoreThrowable(logger, "", new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getSchemaName(column);
                    }
                }, column));
            }
        });
        this.schemaNames = schemaNames;
    }


    private List<Integer> precisions;

    /**
     * Get the designated column's specified column size.
     * For numeric data, this is the maximum precision.  For character data, this is the length in characters.
     * For datetime datatypes, this is the length in characters of the String representation (assuming the
     * maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
     * this is the length in bytes. 0 is returned for data types where the
     * column size is not applicable.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return precision
     */
    public int getPrecision(int column) {
        return precisions.get(column - 1);
    }

    private void parsePrecisions(final ResultSetMetaData resultSetMetaData) {
        final List<Integer> precisions = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                precisions.add(Throwables.ignoreThrowable(logger, 0, new ThrowableFunction<Integer, Integer>() {
                    @Override
                    public Integer doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getPrecision(column);
                    }
                }, column));
            }
        });
        this.precisions = precisions;
    }


    private List<Integer> scales;

    /**
     * Gets the designated column's number of digits to right of the decimal point.
     * 0 is returned for data types where the scale is not applicable.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return scale
     */
    public int getScale(int column) {
        return scales.get(column - 1);
    }

    private void parseScales(final ResultSetMetaData resultSetMetaData) {
        final List<Integer> scales = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                scales.add(Throwables.ignoreThrowable(logger, 0, new ThrowableFunction<Integer, Integer>() {
                    @Override
                    public Integer doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getScale(column);
                    }
                }, column));
            }
        });
        this.scales = scales;
    }


    private List<String> tableNames;

    /**
     * Gets the designated column's table name.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return table name or "" if not applicable
     */
    public String getTableName(int column) {
        return tableNames.get(column - 1);
    }

    private void parseTableNames(final ResultSetMetaData resultSetMetaData) {
        final List<String> tableNames = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                tableNames.add(Throwables.ignoreThrowable(logger, "", new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getTableName(column);
                    }
                }, column));
            }
        });
        this.tableNames = tableNames;
    }

    private List<String> catalogNames;

    /**
     * Gets the designated column's table's catalog name.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return the name of the catalog for the table in which the given column
     * appears or "" if not applicable
     */
    public String getCatalogName(int column) {
        return catalogNames.get(column - 1);
    }

    private void parseCatalogNames(final ResultSetMetaData resultSetMetaData) {
        final List<String> catalogNames = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                catalogNames.add(Throwables.ignoreThrowable(logger, "", new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getCatalogName(column);
                    }
                }, column));
            }
        });
        this.catalogNames = catalogNames;
    }

    private List<JdbcType> jdbcTypes;

    private void parseColumnTypes(final ResultSetMetaData resultSetMetaData) {
        final List<JdbcType> jdbcTypes = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                jdbcTypes.add(Throwables.ignoreThrowable(logger, JdbcType.UNKNOWN, new ThrowableFunction<Integer, JdbcType>() {
                    @Override
                    public JdbcType doFun(Integer column) throws Throwable {
                        return JdbcType.ofCode(resultSetMetaData.getColumnType(column));
                    }
                }, column));
            }
        });
        this.jdbcTypes = jdbcTypes;

    }

    /**
     * Retrieves the designated column's SQL type.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return SQL type from java.sql.Types
     * @see Types
     */
    public JdbcType getColumnType(int column) {
        return jdbcTypes.get(column - 1);
    }


    private List<String> columnJdbcTypeNames;

    /**
     * Retrieves the designated column's database-specific type name.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return type name used by the database. If the column type is
     * a user-defined type, then a fully-qualified type name is returned.
     */
    public String getColumnTypeName(int column) {
        return columnJdbcTypeNames.get(column - 1);
    }

    private void parseColumnJdbcTypeNames(final ResultSetMetaData resultSetMetaData) {
        final List<String> columnJdbcTypeNames = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                columnJdbcTypeNames.add(Throwables.ignoreThrowable(logger, "", new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getColumnTypeName(column);
                    }
                }, column));
            }
        });
        this.columnJdbcTypeNames = columnJdbcTypeNames;
    }

    private List<Boolean> isReadOnly;

    /**
     * Indicates whether the designated column is definitely not writable.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isReadOnly(int column) {
        return isReadOnly.get(column - 1);
    }

    private void parseIsReadOnly(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isReadOnly = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isReadOnly.add(Throwables.ignoreThrowable(logger, true, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isReadOnly(column);
                    }
                }, column));
            }
        });
        this.isReadOnly = isReadOnly;
    }

    private List<Boolean> isWritable;

    /**
     * Indicates whether it is possible for a write on the designated column to succeed.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isWritable(int column) {
        return isWritable.get(column - 1);
    }

    private void parseIsWritable(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isWritable = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isWritable.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isWritable(column);
                    }
                }, column));
            }
        });
        this.isWritable = isWritable;
    }

    private List<Boolean> isDefinitelyWritable;

    /**
     * Indicates whether a write on the designated column will definitely succeed.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return <code>true</code> if so; <code>false</code> otherwise
     */
    public boolean isDefinitelyWritable(int column) {
        return isDefinitelyWritable.get(column - 1);
    }

    private void parseIsDefinitelyWritable(final ResultSetMetaData resultSetMetaData) {
        final List<Boolean> isDefinitelyWritable = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                isDefinitelyWritable.add(Throwables.ignoreThrowable(logger, false, new ThrowableFunction<Integer, Boolean>() {
                    @Override
                    public Boolean doFun(Integer column) throws Throwable {
                        return resultSetMetaData.isDefinitelyWritable(column);
                    }
                }, column));
            }
        });
        this.isDefinitelyWritable = isDefinitelyWritable;
    }

    private List<String> columnClassNames;

    /**
     * <p>Returns the fully-qualified name of the Java class whose instances
     * are manufactured if the method <code>ResultSet.getObject</code>
     * is called to retrieve a value
     * from the column.  <code>ResultSet.getObject</code> may return a subclass of the
     * class returned by this method.
     *
     * @param column the first column is 1, the second is 2, ...
     * @return the fully-qualified name of the class in the Java programming
     * language that would be used by the method
     * <code>ResultSet.getObject</code> to retrieve the value in the specified
     * column. This is the class name used for custom mapping.
     */
    public String getColumnClassName(int column) {
        return columnClassNames.get(column - 1);
    }

    private void parseColumnClassNames(final ResultSetMetaData resultSetMetaData) {
        final List<String> columnClassNames = Collects.emptyArrayList();
        Collects.forEach(Arrs.range(1, columnCount + 1), new Consumer<Integer>() {
            @Override
            public void accept(Integer column) {
                columnClassNames.add(Throwables.ignoreThrowable(logger, "", new ThrowableFunction<Integer, String>() {
                    @Override
                    public String doFun(Integer column) throws Throwable {
                        return resultSetMetaData.getColumnClassName(column);
                    }
                }, column));
            }
        });
        this.columnClassNames = columnClassNames;
    }
}
