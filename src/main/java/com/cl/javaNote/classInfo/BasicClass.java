package com.cl.javaNote.classInfo;

/**
 * Created by cl on 2017/12/1.
 */
public class BasicClass extends BasicAbstractClass implements BasicImplementClass{
    private Integer id;

    private String name;

    private String password;


    public BasicClass() {
    }

    public BasicClass(Integer id) {
        this.id = id;
    }

    private BasicClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void say() {
        System.out.println("继承");
    }

    class InnerBasic {

    }

    @Override
    public String toString() {
        return "BasicClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class ExternalClass {

}
