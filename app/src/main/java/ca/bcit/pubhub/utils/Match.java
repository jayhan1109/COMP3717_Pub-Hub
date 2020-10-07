package ca.bcit.pubhub.utils;

import java.sql.Date;

public class Match {
    public static final MatchModel[] soccer_epl = {
            new MatchModel(MatchId.getSoccer_epl(), 1, "Liverpool", "Man City", Date.valueOf("2020-12-10")),
            new MatchModel(MatchId.getSoccer_epl(), 2, "Man United", "Man City", Date.valueOf("2020-12-13")),
            new MatchModel(MatchId.getSoccer_epl(), 3, "Liverpool", "Chelsea", Date.valueOf("2020-12-15")),
    };

    public static final MatchModel[] soccer_laliga = {
            new MatchModel(MatchId.getSoccer_laliga(), 11, "Barcelona", "Real Madrid", Date.valueOf("2020-12-12")),
            new MatchModel(MatchId.getSoccer_laliga(), 12, "Real Madrid", "AT Madrid", Date.valueOf("2020-12-13")),
            new MatchModel(MatchId.getSoccer_laliga(), 13, "Barcelona", "Getafe", Date.valueOf("2020-12-15")),
    };

    public static final MatchModel[] soccer_bundesliga = {
            new MatchModel(MatchId.getSoccer_bundesliga(), 21, "Dortmund", "Bayern Munich", Date.valueOf("2020-12-11")),
            new MatchModel(MatchId.getSoccer_bundesliga(), 22, "Schalke", "Dortmund", Date.valueOf("2020-12-13")),
            new MatchModel(MatchId.getSoccer_bundesliga(), 23, "Leipzig", "Bayern Munich", Date.valueOf("2020-12-17")),
    };
}
