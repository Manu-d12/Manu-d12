package com.Student_Library_Management_System.dtos;

public class StudentUpdateMobReqDto {
    private int id;
    private String mobNo;

    public StudentUpdateMobReqDto(int id, String mobNo) {
        this.id = id;
        this.mobNo = mobNo;
    }

    public StudentUpdateMobReqDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
