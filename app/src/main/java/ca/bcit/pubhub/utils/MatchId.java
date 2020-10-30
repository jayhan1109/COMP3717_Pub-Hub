package ca.bcit.pubhub.utils;

public class MatchId {
    // Soccer
    private static int SOCCER = 1;
    private static int SOCCER_EPL = 11;
    private static int SOCCER_LALIGA = 12;
    private static int SOCCER_BUNDESLIGA = 13;

    // Basketball
    private static int BASKETBALL_NBA = 2;

    // Baseball
    private static int BASEBALL_ML = 3;

    // Esports
    private static int ESPORTS_LOL = 4;

    public static int getSOCCER() {
        return SOCCER;
    }

    public static int getSoccerEpl() {
        return SOCCER_EPL;
    }

    public static int getSoccerLaliga() {
        return SOCCER_LALIGA;
    }

    public static int getSoccerBundesliga() {
        return SOCCER_BUNDESLIGA;
    }

    public static int getBasketballNba() {
        return BASKETBALL_NBA;
    }

    public static int getBaseballMl() {
        return BASEBALL_ML;
    }

    public static int getEsportsLol() {
        return ESPORTS_LOL;
    }
}
