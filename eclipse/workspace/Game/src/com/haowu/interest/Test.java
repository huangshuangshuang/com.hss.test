package com.haowu.interest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	private static File file;
	private static FileOutputStream outputStream;
	private static User user = User.build();
	private static JDBCUtil jdbcUtil;

	public static void init() {
		try {
			file = new File("C:/Users/300002/Desktop/users.sql");
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		jdbcUtil = new JDBCUtil();
		Test test = new Test();
		long start = System.currentTimeMillis();
		test.insertNotAuto(630000);
		long end = System.currentTimeMillis();
		System.out.println("执行完毕，共花费时间是：" + (float) (end - start) / 1000 + "s");
	}

	public void insertNotAuto(int length) {
		init();
		StringBuilder sql = new StringBuilder("insert into user (name,idCard,sex,age,number,address) values");
		for (int i = 0; i < length; i++) {
			sql.append("('" + user.getName() + "',");
			sql.append("'" + user.getIdCard() + "',");
			sql.append("'" + user.getSex() + "',");
			sql.append(user.getAge() + ",");
			sql.append(user.getNumber() + ",");
			sql.append("'" + user.getAddress() + "'),\r\n");
			if (i == length - 1) {
				sql.delete(sql.length() - 3, sql.length());
				sql.append(";");
			}
			byte[] buff = sql.toString().getBytes();
			try {
				outputStream.write(buff);
				sql.delete(0, sql.length());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertAuto(int length) {
		StringBuilder sql = new StringBuilder("insert into user (name,idCard,sex,age,number,address) values");
		for (int i = 0; i < length; i++) {
			sql.append("('" + user.getName() + "',");
			sql.append("'" + user.getIdCard() + "',");
			sql.append("'" + user.getSex() + "',");
			sql.append(user.getAge() + ",");
			sql.append(user.getNumber() + ",");
			sql.append("'" + user.getAddress() + "'),\r\n");
			if (i == length - 1) {
				sql.delete(sql.length() - 3, sql.length());
				sql.append(";");
			}
		}
		jdbcUtil.update(sql.toString());
	}

	public void insertNotAutoByinsert(int length) {
		init();
		for (int i = 0; i < length; i++) {
			StringBuilder sql = new StringBuilder("insert into user (name,idCard,sex,age,number,address) values");
			sql.append("('" + user.getName() + "',");
			sql.append("'" + user.getIdCard() + "',");
			sql.append("'" + user.getSex() + "',");
			sql.append(user.getAge() + ",");
			sql.append(user.getNumber() + ",");
			sql.append("'" + user.getAddress() + "');\r\n");
			byte[] buff = sql.toString().getBytes();
			try {
				outputStream.write(buff);
				sql.delete(0, sql.length());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertAutoByinsert(int length) {
		for (int i = 0; i < length; i++) {
			StringBuilder sql = new StringBuilder("insert into user (name,idCard,sex,age,number,address) values");
			sql.append("('" + user.getName() + "',");
			sql.append("'" + user.getIdCard() + "',");
			sql.append("'" + user.getSex() + "',");
			sql.append(user.getAge() + ",");
			sql.append(user.getNumber() + ",");
			sql.append("'" + user.getAddress() + "');\r\n");
			jdbcUtil.update(sql.toString());
		}
	}
}
