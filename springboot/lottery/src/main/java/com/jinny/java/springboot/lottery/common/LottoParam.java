package com.jinny.java.springboot.lottery.common;

public class LottoParam {
    Integer lastDrwNo;  // 최근 당첨 회차
    Integer searchDrwNo;    // 최근 n 회차
    Integer cnt;        // n번 당첨 횟수

    public LottoParam(Integer lastDrwNo, Integer searchDrwNo, Integer cnt) {
        this.lastDrwNo = lastDrwNo;
        this.searchDrwNo = searchDrwNo;
        this.cnt = cnt;
    }

    public Integer getLastDrwNo() {
        return lastDrwNo;
    }

    public void setLastDrwNo(Integer lastDrwNo) {
        this.lastDrwNo = lastDrwNo;
    }

    public Integer getSearchDrwNo() {
        return searchDrwNo;
    }

    public void setSearchDrwNo(Integer searchDrwNo) {
        this.searchDrwNo = searchDrwNo;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
