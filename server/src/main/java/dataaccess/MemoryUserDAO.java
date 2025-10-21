package dataaccess;

import dataaccess.*;

import model.UserData;
public class MemoryUserDAO implements UserDAO {
    private final MemoryDatabase db;
    public MemoryUserDAO(MemoryDatabase db){ this.db = db; }
    public void insertUser(UserData u) throws DataAccessException {
        if (u == null || u.username() == null) throw new DataAccessException("null user");
        if (db.users.containsKey(u.username())) throw new DataAccessException("user exists");
        db.users.put(u.username(), u);
    }
    public UserData getUser(String username){ return db.users.get(username); }
    public void clear(){ db.users.clear(); }
}