package ca.bcit.pubhub.utils;

public class MatchId {
    private static int soccer_epl = 1;
    private static int soccer_laliga = 2;
    private static int soccer_bundesliga = 3;

    public static int getSoccer_epl() {
        return soccer_epl;
    }

    public static int getSoccer_laliga() {
        return soccer_laliga;
    }

    public static int getSoccer_bundesliga() {
        return soccer_bundesliga;
    }
}
