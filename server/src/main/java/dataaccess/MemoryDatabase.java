package dataaccess;

import model.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryDatabase {
    public final Map<String,UserData> users = new HashMap<>();
    public final Map<String,AuthData>  auths = new HashMap<>();
    public final Map<Integer,GameData> games = new HashMap<>();
    public final AtomicInteger nextId = new AtomicInteger(1);

    public void clear() {
        users.clear(); auths.clear(); games.clear(); nextId.set(1);
    }
}