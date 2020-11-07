package ca.bcit.pubhub.utils;

public class MatchId {
    // Soccer
    private static int SOCCER = 1;
    private static int SOCCER_EPL = 11;
    private static int SOCCER_LALIGA = 12;
    private static int SOCCER_BUNDESLIGA = 13;

    // Basketball
    private static int BASKETBALL_NBA = 21;
    private static int BASKETBALL_LNB = 22;
    private static int BASKETBALL_ACB = 23;

    // Baseball
    private static int BASEBALL_MLB = 31;
    private static int BASEBALL_KBO = 32;
    private static int BASEBALL_NPB = 33;

    // Esports
    private static int ESPORTS_LOL = 41;
    private static int ESPORTS_OVERWATCH = 42;
    private static int ESSPORTS_FORTNITE = 43;

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
    public static int getBasketballLnb() { return BASKETBALL_LNB; }
    public static int getBasketballAcb() { return BASKETBALL_ACB; }

    public static int getBaseballMlb() {
        return BASEBALL_MLB;
    }
    public static int getBaseballKbo() { return BASEBALL_KBO; }
    public static int getBaseballNpb() { return BASEBALL_NPB; }

    public static int getEsportsLol() {
        return ESPORTS_LOL;
    }
    public static int getEsportsOverwatch() { return ESPORTS_OVERWATCH; }
    public static int getEsportsFortnite() { return ESSPORTS_FORTNITE; }
}
