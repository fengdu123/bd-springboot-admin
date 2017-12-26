package com.bd.springboot.admin.service.json;

/**
 * 所在的包名: com.bd.springboot.admin.service.json
 * 所在的项目名：bd-springboot-admin
 *
 * @author:wangyp
 * @Description:
 * @Date: Created in 15:04 2017/12/26
 */
public class Employee {

    private String name;

    private String Sex;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", age=" + age +
                '}';
    }
}
