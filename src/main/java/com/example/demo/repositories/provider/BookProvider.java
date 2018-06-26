package com.example.demo.repositories.provider;

import org.apache.ibatis.jdbc.SQL;

public class BookProvider {
    public String getAllProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("tbbook");
//            INNER_JOIN("category c ON b.cat_id=c.id");
//            ORDER_BY("b.id ASC");

        }}.toString();
    }
    public String createNewBook(){
        return new SQL(){{
            INSERT_INTO("tbbook");
            VALUES("title","#{title}");
            VALUES("author","#{author}");
            VALUES("publisher","#{publisher}");
            VALUES("thumbnail","#{thumbnail}");
        }}.toString();
    }

    public String updateBook(){
        return new SQL(){{
            UPDATE("tbbook");
            SET("title=#{title},author=#{author},publisher=#{publisher},thumbnail=#{thumbnail}");
            WHERE("id=#{id}");
        }}.toString();
    }
}
