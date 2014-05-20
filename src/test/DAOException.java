package test;
/*
 * JDBCSample02
 * DAOException.java
 *
 * Copyright(C) emBex Inc. All Rights Reserved, 2013
 */



/**
 * データアクセスオブジェクト例外
 * @author emBex
 * @version 1.00
 */
public class DAOException extends Exception {
	/**
	 * @param str
	 * @param th
	 */
	public DAOException(String str, Throwable th) {
		super(str, th);
	}
}
