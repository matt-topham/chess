package dataaccess;

import dataaccess.*;
import model.AuthData;

public class MemoryAuthDAO implements AuthDAO {
    private final MemoryDatabase db;
    public MemoryAuthDAO(MemoryDatabase db){ this.db = db; }
    public void insertAuth(AuthData a){ db.auths.put(a.authToken(), a); }
    public AuthData getAuth(String token){ return db.auths.get(token); }
    public void deleteAuth(String token){ db.auths.remove(token); }
    public void clear(){ db.auths.clear(); }
}