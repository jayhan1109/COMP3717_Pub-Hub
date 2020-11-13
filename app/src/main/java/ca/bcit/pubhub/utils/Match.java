package ca.bcit.pubhub.utils;

import java.sql.Date;
import java.util.Random;

public class Match {
    private static final int LIMIT_TEAMS = 15;
    private static final String[] EPL_TEAMS = {"Liverpool", "Arsenal", "Aston Villa", "Brighton", "Burnley", "Chelsea", "Crystal Palace", "Everton", "Fulham", "Leeds United", "Leicester City", "Manchester City", "Manchester United", "Newcastle United", "Tottenham Hotspur", "West Ham United", "Wolverhampton"};
    private static final String[] LALIGA_TEAMS = {"Real Sociedad", "Real Madrid", "Granada", "Villarreal", "Cadiz", "Getafe", "Real Betis", "Barcelona", "Sevilla", "Valencia", "Levante", "Real Valladolid"};
    private static final String[] BUNDESLIGA_TEAMS = {"Bayern", "Dortmund", "Wolfsburg", "Leverkusen", "Freiburg", "Frankfurt", "Hoffenheim", "Leipzig", "Berlin", "Bremen", "Stuttgart"};

    private static final String[] NBA_TEAMS = {"Boston Celtics", "New York Knicks", "Toronto Raptors", "Chicago Bulls", "Cleveland Cavaliers", "Milwaukee Bucks", "Atlanta Hawks", "Miami Heat", "Orlando Magic", "Washington Wizards", "Denver Nuggets", "Utah Jazz", "Golden State Warriors", "La Clippers", "La Lakers"};
    private static final String[] LNB_TEAMS = {"AS Monaco Basket", "ASVEL", "BCM Gravelines-Dunkerque", "Boulazac Basket Dordogne", "Champagne Châlons-Reims Basket", "Cholet Basket", "Élan Béarnais Pau-Lacq-Orthez", "Élan Chalon", "ESSM Le Portel", "Orléans Loiret Basket", "JDA Dijon Basket", "JL Bourg-en-Bresse", "Le Mans Sarthe Basket", "Limoges CSP", "Metropolitans 92", "Nanterre 92", "Roanne", "SIG Strasbourg"};
    private static final String[] ACB_TEAMS = {"Acunsa GBC", "Barça", "Baxi Manresa", "Casademont Zaragoza", "Club Joventut Badalona", "Coosur Real Betis", "Herbalife Gran Canaria", "Hereda San Pablo Burgos", "Iberostar Tenerife", "Monbus Obradoiro", "MoraBanc Andorra", "Movistar Estudiantes", "Real Madrid", "RETAbet Bilbao Basket", "TD Systems Baskonia", "UCAM Murcia", "Unicaja", "Urbas Fuenlabrada", "Valencia Basket"};

    private static final String[] MLB_TEAMS = {"Chicago", "New York", "Miami", "Pittsburgh", "Colorado", "Los Angeles", "Toronto Blue", "Tampa Bay", "San Francisco", "San Diego", "St. Louis", "Washington", "Philadelphia", "Minnesota", "Kansas", "Detroit", "Cleveland"};
    private static final String[] KBO_TEAMS = {"DOOSAN BEARS", "KIWOOM HEROES", "SK WYVERNS", "LG TWINS", "NC DINOS", "kt wiz", "KIA TIGERS", "SAMSUNG LIONS", "HANWHA EAGLES", "LOTTE GIANTS"};
    private static final String[] NPB_TEAMS = {"Yomiuri Giants", "Saitama Seibu Lions",  "YOKOHAMA DeNA BAYSTARS", "Fukuoka SoftBank Hawks", "Hanshin Tigers", "Tohoku Rakuten Golden Eagles", "Hiroshima Toyo Carp", "Chiba Lotte Marines", "Chunichi Dragons", "Hokkaido Nippon-Ham Fighters", "Tokyo Yakult Swallows", "ORIX Buffaloes"};

    private static final String[] LOL_TEAMS = {"G2", "TES", "DRX", "JDG", "Fnatic", "GEN.G", "PSG", "LGD", "Rogue", "TSM", "UOL", "MAD", "T1"};
    private static final String[] OVERWATCH_TEAMS = {"San Francisco Shock", "Shanghai Dragons", "Philadelphia Fusion", "Seoul Dynasty", "Guangzhou Charge", "New York Execelsior", "Paris Eternal", "Hangzhou Spark", "Florida Mayhem", "Washington Justice", "Chengdu Hunters", "Los Angeles Gladiators", "Los Angeles Valiant", "Atlanta Reign", "Dallas Fuel", "Toronto Defiant", "London Spitfire"};
    private static final String[] FORTNITE_TEAMS = {"Faze Clan", "Sentinels", "Team Liquid", "NRG eSports", "Ghost Gaming", "Team SoloMid", "Team Atlantis", "Team Secret", "Cooler eSports", "100 Thieves", "E11 Gaming", "Team Kungarna", "Luminosity Gaming", "Solary", "Fnatic", "OpTic gaming"};



    public static final MatchModel[] soccer_epl = getMatches(MatchId.getSoccerEpl(), 0, EPL_TEAMS);
    public static final MatchModel[] soccer_laliga = getMatches(MatchId.getSoccerLaliga(), 1, LALIGA_TEAMS);
    public static final MatchModel[] soccer_bundesliga = getMatches(MatchId.getSoccerBundesliga(), 2, BUNDESLIGA_TEAMS);


    public static final MatchModel[] basketball_nba = getMatches(MatchId.getBasketballNba(), 3, NBA_TEAMS);
    public static final MatchModel[] basketball_lnb = getMatches(MatchId.getBasketballLnb(), 4, LNB_TEAMS);
    public static final MatchModel[] basketball_acb = getMatches(MatchId.getBasketballAcb(), 5, ACB_TEAMS);


    public static final MatchModel[] baseball_mlb = getMatches(MatchId.getBaseballMlb(), 6, MLB_TEAMS);
    public static final MatchModel[] baseball_kbo = getMatches(MatchId.getBaseballKbo(), 7, KBO_TEAMS);
    public static final MatchModel[] baseball_npb = getMatches(MatchId.getBaseballNpb(), 8, NPB_TEAMS);


    public static final MatchModel[] esports_lol = getMatches(MatchId.getEsportsLol(), 9, LOL_TEAMS);
    public static final MatchModel[] esports_overwatch = getMatches(MatchId.getEsportsOverwatch(), 10, OVERWATCH_TEAMS);
    public static final MatchModel[] esports_fortnite = getMatches(MatchId.getEsportsFortnite(), 11, FORTNITE_TEAMS);

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
