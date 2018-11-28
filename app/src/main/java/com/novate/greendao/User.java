package com.novate.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/11/28 7:42
 * Version 1.0
 * Params:
 * Description:    实体类
 *
 * 备注：Bean 对象注释的解释
 *           @Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
             @Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
             @Property：可以自定义字段名，注意外键不能使用该属性
             @NotNull：属性不能为空
             @Transient：使用该注释的属性不会被存入数据库的字段中
             @Unique：该属性值必须在数据库中是唯一值
             @Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
 * ================================================
*/

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private int age;
    private String sex;
    @Generated(hash = 689493095)
    public User(Long id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
