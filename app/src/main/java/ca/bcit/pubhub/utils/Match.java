package ca.bcit.pubhub.utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class Match {
    private static final int LIMIT_TEAMS = 15;
    private static final String[] EPL_TEAMS = {"Liverpool", "Arsenal", "Aston Villa", "Brighton", "Burnley", "Chelsea", "Crystal Palace", "Everton", "Fulham", "Leeds United", "Leicester City", "Manchester City", "Manchester United", "Newcastle United", "Tottenham Hotspur", "West Ham United", "Wolverhampton"};
    private static final String[] LALIGA_TEAMS = {"Real Sociedad", "Real Madrid", "Granada", "Villarreal", "Cadiz", "Getafe", "Real Betis", "Barcelona", "Sevilla", "Valencia", "Levante", "Real Valladolid"};
    private static final String[] BUNDESLIGA_TEAMS = {"Bayern", "Dortmund", "Wolfsburg", "Leverkusen", "Freiburg", "Frankfurt", "Hoffenheim", "Leipzig", "Berlin", "Bremen", "Stuttgart"};
    private static final String[] NBA_TEAMS = {"Boston Celtics", "New York Knicks", "Toronto Raptors", "Chicago Bulls", "Cleveland Cavaliers", "Milwaukee Bucks", "Atlanta Hawks", "Miami Heat", "Orlando Magic", "Washington Wizards", "Denver Nuggets", "Utah Jazz", "Golden State Warriors", "La Clippers", "La Lakers"};
    private static final String[] ML_TEAMS = {"Chicago", "New York", "Miami", "Pittsburgh", "Colorado", "Los Angeles", "Toronto Blue", "Tampa Bay", "San Francisco", "San Diego", "St. Louis", "Washington", "Philadelphia", "Minnesota", "Kansas", "Detroit", "Cleveland"};
    private static final String[] LOL_TEAMS = {"G2", "TES", "DRX", "JDG", "Fnatic", "GEN.G", "PSG", "LGD", "Rogue", "TSM", "UOL", "MAD", "T1"};

    public static final MatchModel[] soccer_epl = getMatches(MatchId.getSoccerEpl(), 0, EPL_TEAMS);

    public static final MatchModel[] soccer_laliga = getMatches(MatchId.getSoccerLaliga(), 1, LALIGA_TEAMS);

    public static final MatchModel[] soccer_bundesliga = getMatches(MatchId.getSoccerBundesliga(), 2, BUNDESLIGA_TEAMS);

    public static final MatchModel[] basketball_nba = getMatches(MatchId.getBasketballNba(), 3, NBA_TEAMS);

    public static final MatchModel[] baseball_ml = getMatches(MatchId.getBaseballMl(), 4, ML_TEAMS);

    public static final MatchModel[] esports_lol = getMatches(MatchId.getEsportsLol(), 5, LOL_TEAMS);

    public static MatchModel[] getMatches(int category, int matchId, String[] teams) {
        MatchModel[] matches = new MatchModel[LIMIT_TEAMS];

        final int numOfTeams = teams.length;
        Random random = new Random();

        String team1;
        String team2;

        for (int i = 0; i < LIMIT_TEAMS; i++) {
            team1 = teams[random.nextInt(teams.length)];
            team2 = teams[random.nextInt(teams.length)];

            while (team1.equals(team2)) {
                team2 = teams[random.nextInt(teams.length)];
            }

            matches[i] = new MatchModel(category, Integer.parseInt("" + matchId + i), team1, team2, getRandomDate());
        }

        return matches;
    }

    public static Date getRandomDate() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(30) + 1;

        return Date.valueOf("2020" + "-" + month + "-" + day);
    }

}
