package ca.bcit.pubhub.items;

import java.util.Date;

public class MatchViewItem {
    private int _categoryId;
    private int _matchId;
    private String _team1;
    private String _team2;
    private Date _date;

    public int get_categoryId() {
        return _categoryId;
    }

    public void set_categoryId(int _categoryId) {
        this._categoryId = _categoryId;
    }

    public int get_matchId() {
        return _matchId;
    }

    public void set_matchId(int _matchId) {
        this._matchId = _matchId;
    }

    public String get_team1() {
        return _team1;
    }

    public void set_team1(String _team1) {
        this._team1 = _team1;
    }

    public String get_team2() {
        return _team2;
    }

    public void set_team2(String _team2) {
        this._team2 = _team2;
    }

    public Date get_date() {
        return _date;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }
}
