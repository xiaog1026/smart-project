package jp.co.company.smart.utils;

import lombok.Data;

import java.util.List;

@Data
public class ErTable {
    private String tableName;
    private String logicTableName;
    private List<ErColumn> columns;
}
