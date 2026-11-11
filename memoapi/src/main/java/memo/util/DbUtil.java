package memo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB 接続を提供するユーティリティ。
 *
 * TODO: 実装する内容
 * 	- 以下の環境変数で上書き可能。
 * 		DB_URL 
 * 		DB_USER 
 * 		DB_PASSWORD 
 *  - JDBC ドライバ（com.mysql.cj.jdbc.Driver）を読み込む
 *  - 接続 URL には useUnicode=true、characterEncoding=utf8、serverTimezone=Asia/Tokyo を指定する
 */
public final class DbUtil {
	private static final String URL = env("DB_URL",
			"jdbc:mysql://localhost:3306/memo_db"
					+ "?useUnicode=true&characterEncoding=utf8&connectionCollation=utf8mb4_0900_ai_ci"
					+ "&serverTimezone=Asia/Tokyo");
	private static final String USER = env("DB_USER", "root");
	private static final String PASSWORD = env("DB_PASSWORD", "password");

	private static String env(String key, String def) {
		String v = System.getenv(key);
		return (v == null || v.isBlank()) ? def : v;
	}

	/**
	 * 
	 */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
	private DbUtil() {}

	/** DB 接続を取得する。呼び出し側が try-with-resources で閉じる。 */
	public static Connection getConnection() throws SQLException {
		// TODO: DriverManager.getConnection(...) で接続を返す
        return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
