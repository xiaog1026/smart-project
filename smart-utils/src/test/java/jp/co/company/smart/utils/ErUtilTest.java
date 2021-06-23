package jp.co.company.smart.utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ErUtilTest {

    @Test
    public void readTable() {
        List<ErTable> tables = ErUtil.read("SmartProjectER.erm");
        assertEquals(tables.size(),5);
    }

    @Test
    public void readColumn() {
        List<ErTable> tables = ErUtil.read("SmartProjectER.erm");
        for (ErTable table : tables) {
            if (table.getTableName().equals("code_value_master")) {
                assertEquals(table.getColumns().size(),9);
            }
        }
    }
}