package ca.bcit.pubhub.utils;

import java.sql.Date;

public class MatchModel {
    private int _category;
    private int _matchId;
    private String _team1;
    private String _team2;
    private Date _date;

    public MatchModel(int _category, int _matchId, String _team1, String _team2, Date _date) {
        this._category = _category;
        this._matchId = _matchId;
        this._team1 = _team1;
        this._team2 = _team2;
        this._date = _date;
    }

    public int get_category() {
        return _category;
    }

    // With match ID, we can get history list
    // Get index of match ID
    // use get_match function
    public int get_matchId() {
        return _matchId;
    }

    public String get_team1() {
        return _team1;
    }

    public String get_team2() {
        return _team2;
    }

    public Date get_date() {
        return _date;
    }

    public MatchModel get_match() {
        return this;
    }

}

