package memo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import memo.model.Memo;

/**
 * memos テーブルを操作する DAO（JDBC）。
 *
 * TODO: 全メソッドで PreparedStatement を使い、Connection は DbUtil.getConnection() で取得して
 *       try-with-resources で閉じる。
 */
public class MemoDao {

    /**
     * 未削除（is_deleted = 0）のメモを、更新日時の新しい順に全件取得する。
     * TODO: SELECT id, title, content, created_at, updated_at FROM memos WHERE is_deleted = 0 ORDER BY updated_at DESC
     */
    public List<Memo> findAll() throws SQLException {
        return null;
    }

    /**
     * id で未削除のメモを 1 件取得する。見つからなければ null。
     * TODO: SELECT ... WHERE id = ? AND is_deleted = 0
     */
    public Memo findById(int id) throws SQLException {
        return null;
    }

    /**
     * メモを登録し、採番された id を返す。
     * TODO: INSERT INTO memos (title, content) VALUES (?, ?)（Statement.RETURN_GENERATED_KEYS を指定）
     */
    public int insert(Memo m) throws SQLException {
        return 0;
    }

    /**
     * 未削除のメモのタイトルと本文を更新する。1 件以上更新できたら true。
     * TODO: UPDATE memos SET title = ?, content = ? WHERE id = ? AND is_deleted = 0
     */
    public boolean update(Memo m) throws SQLException {
        return false;
    }

    /**
     * 論理削除する（物理削除しない）。1 件以上更新できたら true、対象がなければ false。
     * TODO: UPDATE memos SET is_deleted = 1 WHERE id = ? AND is_deleted = 0
     */
    public boolean softDelete(int id) throws SQLException {
        return false;
    }

    // TODO: ResultSet を Memo に変換する private メソッド（map）を作る
    //       created_at / updated_at は getTimestamp(...).toLocalDateTime() で変換する
	private Memo map(ResultSet rs) throws SQLException {
		Memo m = new Memo();
		m.setId(rs.getInt("id"));
		m.setTitle(rs.getString("title"));
		m.setContent(rs.getString("content"));
		m.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
		m.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
		return m;
	}
}
