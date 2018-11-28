package com.novate.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.novate.greendao.db.DaoSession;
import com.novate.greendao.db.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/11/28 8:51
 * Version 1.0
 * Params:
 * Description:    增删改查方法
 * ================================================
*/

public class MainActivity extends AppCompatActivity {

    int i = 1;
    private DaoSession daoSession;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDaoSession() ;
    }

    private void initDaoSession() {
        daoSession = AppApplication.getInstances().getDaoSession();
        userDao = AppApplication.getInstances().getDaoSession().getUserDao();
    }


    /**
     * 添加数据
     */
    public void add(View view) {
        User user = new User(null , "zhangsan" , i , "男") ;
        i = i+1;
        daoSession.insert(user) ;

        List<User> list = userDao.queryBuilder().list();
        Log.e("TAG" , "插入成功，查询的结果个数为："+list.size()+", 数据为："+list) ;
    }


    /**
     * 删除
     */
    public void delete(View view) {
        List<User> list = userDao.queryBuilder().list();

        if (list == null || list.isEmpty()){
            return;
        }

        for (int j = 0; j < list.size(); j++) {
            User user = list.get(j);
            if ("zhangsan".equals(user.getName())){
                userDao.delete(user);
                Log.e("TAG" , "删除姓名为张三的人") ;
            }
        }

        Log.e("TAG" , "删除成功后，查询的结果个数为: "+userDao.queryBuilder().list().size()) ;
    }


    /**
     * 修改
     */
    public void update(View view) {
        QueryBuilder<User> builder = userDao.queryBuilder();

        // 获取年龄为1的 用户的集合
        List<User> list = builder.where(UserDao.Properties.Age.eq(1)).list();
        if (list == null || list.isEmpty()){
            return;
        }
        for (int j = 0; j < list.size(); j++) {
            User user = list.get(j);
            user.setName("lisi");
            user.setSex("女");
            daoSession.update(user);
            Log.e("TAG" , "修改成功") ;
        }
        Log.e("TAG" , "修改成功后，查询的结果个数为: "+userDao.queryBuilder().list().size()) ;


        // 查询数据库中所有数据的集合
        List<User> list1 = userDao.queryBuilder().list();
        if (list1 == null || list1.isEmpty()){
            Log.e("TAG" , "所有数据的集合list1 - 暂无数据") ;
            return;
        }

        for (int k = 0; k < list1.size(); k++) {
            User user = list1.get(k);

            Long id = user.getId();
            String name = user.getName();
            int age = user.getAge();
            String sex = user.getSex();
            Log.e("TAG" , "修改后 遍历所有集合的：姓名："+name+", 年龄："+age+", 性别："+sex+", id: "+id) ;
        }
    }


    /**
     * 查询
     */
    public void query(View view) {
        QueryBuilder<User> builder = userDao.queryBuilder();
        // 获取 数据库中的list集合
        List<User> list = builder.list();

        if (list == null || list.isEmpty()){
            Log.e("TAG" , "集合中暂无数据") ;
            return;
        }

        for (int j = 0; j < list.size(); j++) {
            User user = list.get(j);

            Long id = user.getId();
            String name = user.getName();
            int age = user.getAge();
            String sex = user.getSex();
            Log.e("TAG" , "查询后 遍历所有集合的：姓名："+name+", 年龄："+age+", 性别："+sex+", id: "+id) ;
        }
    }
}
