package com.hanks7.houjianjuntest.borrowlist;

/**
 * Created by gengjiajia on 16/2/19.
 */
public class BorrowBean {


    /**
     * paymentMode : 4
     * borrowTitle : 流转标测试0223
     * borrowStatus : 2
     * schedules : 0
     * bidremainTime : null
     * borrowWay : 6
     * investNum : 1,000.00 元
     * borrowAmount : 1,000.00 元
     * annualRate : 12
     * isahead : 2
     * id : 9
     * isDayThe : 1
     * credit : 1
     * deadline : 1
     */

    private int paymentMode;
    private String borrowTitle;
    private int borrowStatus;
    private String schedules;
    private String bidremainTime;
    private int borrowWay;
    private String investNum;
    private String borrowAmount;
    private double annualRate;
    private int isahead;
    private int id;
    private int isDayThe;
    private int credit;
    private int deadline;

    public void setPaymentMode(int paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setBorrowTitle(String borrowTitle) {
        this.borrowTitle = borrowTitle;
    }

    public void setBorrowStatus(int borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public void setBidremainTime(String bidremainTime) {
        this.bidremainTime = bidremainTime;
    }

    public void setBorrowWay(int borrowWay) {
        this.borrowWay = borrowWay;
    }

    public void setInvestNum(String investNum) {
        this.investNum = investNum;
    }

    public void setBorrowAmount(String borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public void setAnnualRate(Double annualRate) {
        this.annualRate = annualRate;
    }

    public void setIsahead(int isahead) {
        this.isahead = isahead;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsDayThe(int isDayThe) {
        this.isDayThe = isDayThe;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getPaymentMode() {
        return paymentMode;
    }

    public String getBorrowTitle() {
        return borrowTitle;
    }

    public int getBorrowStatus() {
        return borrowStatus;
    }

    public String getSchedules() {
        return schedules;
    }

    public Object getBidremainTime() {
        return bidremainTime;
    }

    public int getBorrowWay() {
        return borrowWay;
    }

    public String getInvestNum() {
        return investNum;
    }

    public String getBorrowAmount() {
        return borrowAmount;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public int getIsahead() {
        return isahead;
    }

    public int getId() {
        return id;
    }

    public int getIsDayThe() {
        return isDayThe;
    }

    public int getCredit() {
        return credit;
    }

    public int getDeadline() {
        return deadline;
    }
}
