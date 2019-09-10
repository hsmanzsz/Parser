package com.zsz.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zsz.model.Person;
import com.zsz.parser.Parser;

public class App {
	public static void main(String[] args) {
		Person friend = new Person();
		friend.setAge(10);
		friend.setSex(false);
		friend.setEamil("11@qq.com");
		friend.setPhone("123");
		friend.setName("xiao");
		List<Person> personList = new ArrayList<>();
		personList.add(friend);
		Person person = new Person();
		person.setAge(21);
		person.setName("zsz");
		person.setSex(false);
		person.setEamil("923013918@qq.com");
		person.setPhone("15526068325");
		person.setFriends(personList);
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "ok");
		map.put("info", "about info");
		map.put("isSingle", false);
		person.setHobby(map);
		Parser parser = new Parser();
		Gson gson = new Gson();
		System.out.println("---------toJson");
		System.out.println("�Լ�:"+parser.toJson(map));
		System.out.println("gson:"+gson.toJson(map));
		System.out.println("�Լ�:"+parser.toJson(person));
		System.out.println("gson:"+gson.toJson(person));
		
		System.out.println("---------fromJson");
		String str = "{age:18,name:'bob',phone:'130',friends:[{age:18,name:'bob',phone:'130'}],boss:{age:19,name:'alice',phone:'150'},sex:false}";
		Person per = (Person) parser.fromJson(str,Person.class);
		Person per1 = gson.fromJson(str,Person.class);
		System.out.println("JSON����:"+str);
		System.out.println("�Լ�:"+parser.toJson(per));
		System.out.println("gson:"+gson.toJson(per1));
		String strs = "[{age:18,name:'bob',phone:'130',boss:{age:19,name:'alice',phone:'150',sex:false},sex:false},{age:18,sex:true}]";
		System.out.println("JSON����:"+strs);
		List<Person> list= (List<Person>) parser.fromJson(strs,Person.class);
		List<Person> list1= gson.fromJson(strs,new TypeToken<List<Person>>() {
		}.getType());
		System.out.println("�Լ�:"+parser.toJson(list));
		System.out.println("gson:"+gson.toJson(list1));
		

	}
}
