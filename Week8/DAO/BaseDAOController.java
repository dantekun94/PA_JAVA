package DAO;


import java.sql.Connection;

public abstract class BaseDAOController {
    protected Connection conn;

    public BaseDAOController(Connection conn) {
        this.conn = conn;
    }
}
