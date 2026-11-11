package memo.service;

import java.sql.SQLException;
import java.util.List;
import memo.model.Memo;

/**
 * 業務ロジック（タイトル補完など）。DB 操作は MemoDao に任せる。
 *
 * TODO: フィールドに MemoDao を持つ（private final MemoDao dao = new MemoDao();）
 */
public class MemoService {

    /** 未削除のメモ一覧を返す。 */
    public List<Memo> list() throws SQLException {
        // TODO: dao.findAll()
        return null;
    }

    /**
     * 保存する。id が null なら新規登録、数値なら更新。保存したメモの id を返す。
     * 更新対象が存在しない（または削除済み）の場合は null を返す。
     */
    public Integer save(Memo m) throws SQLException {
        // TODO: id が null なら create(m).getId()、そうでなければ update(m.getId(), m) の結果から id を返す
        return null;
    }

    /** 新規登録し、登録したメモを返す。 */
    public Memo create(Memo m) throws SQLException {
        // TODO: タイトルを整える → content が null なら空文字 → dao.insert → dao.findById
        return null;
    }

    /** 更新し、更新後のメモを返す。対象が存在しなければ null。 */
    public Memo update(int id, Memo m) throws SQLException {
        // TODO: m.setId(id) → タイトルを整える → content が null なら空文字 → dao.update → dao.findById
        return null;
    }

    /** 論理削除する。 */
    public boolean delete(int id) throws SQLException {
        // TODO: dao.softDelete(id)
        return false;
    }

    // TODO: タイトルを整える private メソッド（normalizeTitle）を作る
    //  - null または空白のみ → "メモ(YYYY-MM-DD)"（本日の日付、LocalDate.now()）
    //  - それ以外 → 前後の空白を取り除き、255 文字を超える場合は 255 文字に切り詰める
}
