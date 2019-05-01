package com.example.project;

public class Party {

    String balloons,cake,partyColors, partyDate,partyLocation, partyName, partyNumGuests,
    partyTheme, partyTime;



    public Party(){}

    public String getBalloons() {
        return balloons;
    }

    public void setBalloons(String balloons) {
        this.balloons = balloons;
    }

    public String getCake() {
        return cake;
    }

    public void setCake(String cake) {
        this.cake = cake;
    }

    public String getPartyColors() {
        return partyColors;
    }

    public void setPartyColors(String partyColors) {
        this.partyColors = partyColors;
    }

    public String getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public String getPartyLocation() {
        return partyLocation;
    }

    public void setPartyLocation(String partyLocation) {
        this.partyLocation = partyLocation;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyNumGuests() {
        return partyNumGuests;
    }

    public void setPartyNumGuests(String partyNumGuests) {
        this.partyNumGuests = partyNumGuests;
    }

    public String getPartyTheme() {
        return partyTheme;
    }

    public void setPartyTheme(String partyTheme) {
        this.partyTheme = partyTheme;
    }

    public String getPartyTime() {
        return partyTime;
    }

    public void setPartyTime(String partyTime) {
        this.partyTime = partyTime;
    }

    public Party(String balloons, String cake, String partyColors, String partyDate, String partyLocation, String partyName, String partyNumGuests, String partyTheme, String partyTime) {
        this.balloons = balloons;
        this.cake = cake;
        this.partyColors = partyColors;
        this.partyDate = partyDate;
        this.partyLocation = partyLocation;
        this.partyName = partyName;
        this.partyNumGuests = partyNumGuests;
        this.partyTheme = partyTheme;
        this.partyTime = partyTime;
    }
}
