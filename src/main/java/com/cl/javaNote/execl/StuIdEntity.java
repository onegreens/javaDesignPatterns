package com.cl.javaNote.execl;

/**
 * Created by cl on 2017/8/17.
 */
public class StuIdEntity {

    //ID
    private Integer studentId;
    //姓名
    private String studentName;
    //住址
    private String address;
    //出生日期
    private String birth;
    //身份证号
    private String identityCard;
    //邮箱
    private String email;
    //性别
    private Integer sexId;
    //民族
    private Integer nationId;
    //政治面貌
    private Integer politicsStatusId;
    //籍贯
    private Integer nativePlaceId;
    //年级
    private Integer gradeId;
    //专业
    private Integer majorId;
    //用户
    private Integer userId;

    private Integer gradeMajorId;

    public StuIdEntity() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public Integer getPoliticsStatusId() {
        return politicsStatusId;
    }

    public void setPoliticsStatusId(Integer politicsStatusId) {
        this.politicsStatusId = politicsStatusId;
    }

    public Integer getNativePlaceId() {
        return nativePlaceId;
    }

    public void setNativePlaceId(Integer nativePlaceId) {
        this.nativePlaceId = nativePlaceId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGradeMajorId() {
        return gradeMajorId;
    }

    public void setGradeMajorId(Integer gradeMajorId) {
        this.gradeMajorId = gradeMajorId;
    }
}
