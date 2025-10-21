package dataaccess;

import dataaccess.*;
import model.GameData;
import java.util.Collection;

public class MemoryGameDAO implements GameDAO {
    private final MemoryDatabase db;
    public MemoryGameDAO(MemoryDatabase db){ this.db = db; }
    public int insertGame(GameData g){
        int id = db.nextId.getAndIncrement();
        db.games.put(id, new GameData(id, g.whiteUsername(), g.blackUsername(), g.gameName(), g.game()));
        return id;
    }
    public GameData getGame(int id){ return db.games.get(id); }
    public Collection<GameData> listGames(){ return db.games.values(); }
    public void updateGame(GameData g) throws DataAccessException {
        if (!db.games.containsKey(g.gameID())) throw new DataAccessException("no such game");
        db.games.put(g.gameID(), g);
    }
    public void clear(){ db.games.clear(); }
}