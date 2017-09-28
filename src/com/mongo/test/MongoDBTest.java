package com.mongo.test;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import com.mongodb.Mongo;

public class MongoDBTest {

	public static void main(String[] args) {
		// 实例化Mongo对象，连接27017端口
		Mongo mongo = new Mongo("localhost", 27017);
		// 连接名为countryDB的数据库，假如数据库不存在的话，mongodb会自动建立
		DB db = mongo.getDB("countryDB");

		// 从Mongodb中获得名为countryCollection的数据集合，如果该数据集合不存在，Mongodb会为其新建立
		DBCollection collection = db.getCollection("countryCollection");
		//先查询原有的数据
		DBCursor cursor = collection.find();
		System.out.println("******先查询原有的数据******");
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		// 使用BasicDBObject对象创建一个mongodb的document,并给予赋值。
		BasicDBObject document = new BasicDBObject();
		document.put("_id", 3);
		document.put("country", "English");
		document.put("capital", "Lunton");
		// 将新建立的document保存到collection中去
		collection.insert(document);
		cursor = collection.find();
		System.out.println("******插入id为3的数据后查询全部******");
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		//查询_id为3的数据
		BasicDBObject document3 = new BasicDBObject();
		document3.put("_id", 3);
		cursor = collection.find(document);
		System.out.println("*****查询_id为3的数据******");
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		System.out.println();
		//更新数据
		BasicDBObject document2 = new BasicDBObject();
		document2.put("_id", 3);
		document2.put("country", "English");
		document2.put("capital", "Lundon");
		collection.update(document, document2);
		//检索全部
		System.out.println("******更新_id为3数据后检索全部数据**********");
		cursor = collection.find();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		
		//删除数据
		collection.remove(document3);
		System.out.println();
		System.out.println("******删除_id为3数据后检索全部数据**********");
		cursor = collection.find();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
	}

	
	public void insert() {
		// 实例化Mongo对象，连接27017端口
		Mongo mongo = new Mongo("localhost", 27017);
		// 连接名为countryDB的数据库，假如数据库不存在的话，mongodb会自动建立
		DB db = mongo.getDB("countryDB");

		// 从Mongodb中获得名为countryCollection的数据集合，如果该数据集合不存在，Mongodb会为其新建立
		DBCollection collection = db.getCollection("countryCollection");
		// 使用BasicDBObject对象创建一个mongodb的document,并给予赋值。
		BasicDBObject document = new BasicDBObject();
		document.put("_id", 3);
		document.put("country", "English");
		document.put("capital", "Lunton");
		// 将新建立的document保存到collection中去
		collection.insert(document);
	}

}
