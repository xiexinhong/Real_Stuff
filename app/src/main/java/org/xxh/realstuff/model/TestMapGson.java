package org.xxh.realstuff.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class TestMapGson {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Map<String,List<User>> userMap = new HashMap<>();
        List<User> users = new ArrayList<>();
        users.add(new User(1,"name1"));
        users.add(new User(1,"name2"));
        users.add(new User(1,"name3"));
        userMap.put("igroup",users);

        Gson gson = new Gson();
        String result = gson.toJson(userMap);
        System.out.println("result = "+result);

       userMap = gson.fromJson(result,new TypeToken<Map<String,List<User>>>(){}.getType());
        System.out.println("userMap = "+userMap);

    }

    private static class User {

        public int id;

        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
