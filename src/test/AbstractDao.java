package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao<T>{
	protected Connection con;
	protected Statement stmt;
	
	protected void getConnection() throws DAOException{

		// JDBCドライバ名
		String drv = "com.mysql.jdbc.Driver";
		// URL・ユーザ名・パスワードの設定
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String user = "embexU";
		String password = "embexP";

		if ( this.con != null ){
			return;
		}

		try {
			// JDBCドライバのロード
			Class.forName(drv);

		// ロードに失敗した場合の例外処理
		} catch (ClassNotFoundException e) {
			throw new DAOException("[conect]異常", e);
		}

		try {

			// データベースへの接続の取得
			con = DriverManager.getConnection(url, user, password);
			return;

		// SQLに関する例外処理
		} catch (SQLException e) {
			throw new DAOException("[conect]異常", e);
		}
	}
	protected void createStmt() throws DAOException{

		if ( this.stmt != null){
			return;
		}
		try {

			// ステートメント取得
			stmt = con.createStatement();

		// SQLに関する例外処理
		} catch (SQLException e) {
			throw new DAOException("[createStmt]異常", e);
		}
	}
	public abstract int insert(T entity);

	public abstract T select(int key);
}
