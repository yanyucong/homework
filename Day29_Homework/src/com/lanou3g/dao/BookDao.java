package com.lanou3g.dao;

import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookDao {
    private QueryRunner qr = new QueryRunner();

    public List<Map<String, Object>> query(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
    List<Map<String, Object>> maps = null;
        try {
            maps = qr.query(conn, sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maps;
    }
}
