package com.jinny.java.springboot.lottery.dto;

public class LottoNumber {
    String drwNoDate;
    Integer drwNo;       // 회차
    Integer drwtNo1;
    Integer drwtNo2;
    Integer drwtNo3;
    Integer drwtNo4;
    Integer drwtNo5;
    Integer drwtNo6;
    Integer bnusNo;

    public LottoNumber() {
    }

    public String getDrwNoDate() {
        return drwNoDate;
    }

    public void setDrwNoDate(String drwNoDate) {
        this.drwNoDate = drwNoDate;
    }

    public Integer getDrwNo() {
        return drwNo;
    }

    public void setDrwNo(Integer drwNo) {
        this.drwNo = drwNo;
    }

    public Integer getDrwtNo1() {
        return drwtNo1;
    }

    public void setDrwtNo1(Integer drwtNo1) {
        this.drwtNo1 = drwtNo1;
    }

    public Integer getDrwtNo2() {
        return drwtNo2;
    }

    public void setDrwtNo2(Integer drwtNo2) {
        this.drwtNo2 = drwtNo2;
    }

    public Integer getDrwtNo3() {
        return drwtNo3;
    }

    public void setDrwtNo3(Integer drwtNo3) {
        this.drwtNo3 = drwtNo3;
    }

    public Integer getDrwtNo4() {
        return drwtNo4;
    }

    public void setDrwtNo4(Integer drwtNo4) {
        this.drwtNo4 = drwtNo4;
    }

    public Integer getDrwtNo5() {
        return drwtNo5;
    }

    public void setDrwtNo5(Integer drwtNo5) {
        this.drwtNo5 = drwtNo5;
    }

    public Integer getDrwtNo6() {
        return drwtNo6;
    }

    public void setDrwtNo6(Integer drwtNo6) {
        this.drwtNo6 = drwtNo6;
    }

    public Integer getBnusNo() {
        return bnusNo;
    }

    public void setBnusNo(Integer bnusNo) {
        this.bnusNo = bnusNo;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "drwNoDate='" + drwNoDate + '\'' +
                ", drwNo=" + drwNo +
                ", drwtNo1=" + drwtNo1 +
                ", drwtNo2=" + drwtNo2 +
                ", drwtNo3=" + drwtNo3 +
                ", drwtNo4=" + drwtNo4 +
                ", drwtNo5=" + drwtNo5 +
                ", drwtNo6=" + drwtNo6 +
                ", bnusNo=" + bnusNo +
                '}';
    }
}
