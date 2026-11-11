package memo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * メモ 1 件を表すデータクラス（WebAPI 仕様書の Note に対応）。
 *
 * TODO: 実装する内容
 *  - 各フィールドの getter / setter を作る（Eclipse: ソース → getter および setter の生成）
 *  - クラスに @JsonIgnoreProperties(ignoreUnknown = true) を付ける
 *  - createdAt / updatedAt の getter に @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") を付ける
 *  - deleted は JSON に出さないため、isDeleted() に @JsonIgnore を付ける
 */
public class Memo {
    private Integer id;               // メモ ID（新規作成のリクエストでは null）
    private String title;             // タイトル（最大 255 文字）
    private String content;           // 本文
    private LocalDateTime createdAt;  // 登録日時（レスポンスのみ）
    private LocalDateTime updatedAt;  // 更新日時（レスポンスのみ）
    private boolean deleted;          // 削除フラグ（is_deleted）。JSON には出さない

    // TODO: getter / setter

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @JsonIgnore
    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}
