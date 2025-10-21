package service;

import dataaccess.AuthDAO;
import dataaccess.GameDAO;
import dataaccess.UserDAO;
import dataaccess.DataAccessException;

public class ClearService {
    private final UserDAO users;
    private final GameDAO games;
    private final AuthDAO auths;

    public ClearService(UserDAO users, GameDAO games, AuthDAO auths) {
        this.users = users;
        this.games = games;
        this.auths = auths;
    }

    public void clear() throws DataAccessException {
        users.clear();
        auths.clear();
        games.clear();
    }
}
