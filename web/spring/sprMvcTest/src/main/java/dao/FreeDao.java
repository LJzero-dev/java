package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import vo.FreeList;

public class FreeDao {
	private JdbcTemplate jdbc;	
	public FreeDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	public int getFreeListCount(String where) {	// 검색된(검색어가 있을 경우) 게시글의 총 개수를 리턴하는 메소드
		return jdbc.queryForObject("select count(*) from t_free_list " + where, Integer.class);
	}
	public List<FreeList> getFreeList(String where, int cpage, int psize) {	// 게시글의 목록을 FreeList형 인스턴스를 저장한 List로 리턴하는 메소드		
		List<FreeList> result = jdbc.query("select fl_idx, fl_title, fl_reply, fl_writer, fl_read, if(curdate() = date(fl_date), right(fl_date, 8), mid(fl_date,3,8)) wdate from t_free_list " + where + " order by fl_idx desc limit " + (cpage - 1) * psize + ", " + psize, (ResultSet rs, int rowNum) -> {
			FreeList fl = new FreeList();
			fl.setFl_idx(rs.getInt("fl_idx"));
			fl.setFl_writer(rs.getString("fl_writer"));
			fl.setFl_read(rs.getInt("fl_read"));
			fl.setFl_date(rs.getString("wdate").replace("-", "."));			
			String title = "";	int cnt = 30;
			if (rs.getInt("fl_reply") > 0) { title = " [" + rs.getInt("fl_reply") + "]";	cnt -= 3; }
			if (rs.getString("fl_title").length() > cnt) title = rs.getString("fl_title").substring(0, cnt - 3) + "..." + title;			
			else title = rs.getString("fl_title") + title;
			fl.setFl_title(title);
				return fl;
				}
			);
		return result;
	}
	public int readUpdate(int flidx) {
		return jdbc.update("update t_free_list set fl_read = fl_read + 1 where fl_idx = " + flidx);
	}
	public FreeList getFreeInfo(int flidx) {
		   // 지정한 게시글의 내용을 FreeList형 인스턴스로 리턴하는 메소드
		readUpdate(flidx);
		      String sql = "select * from t_free_list where fl_isview = 'y' and fl_idx = " + flidx;
		      FreeList fl = jdbc.queryForObject(sql, new RowMapper<FreeList>() {
		         @Override
		         public FreeList mapRow(ResultSet rs, int rowNum) throws SQLException {
		            FreeList fl = new FreeList();
		            fl.setFl_idx(rs.getInt("fl_idx"));
		               fl.setFl_ismem(rs.getString("fl_ismem"));
		               fl.setFl_writer(rs.getString("fl_writer"));
		               fl.setFl_title(rs.getString("fl_title"));
		               fl.setFl_content(rs.getString("fl_content").replace("\r\n", "<br>"));
		               fl.setFl_reply(rs.getInt("fl_reply"));
		               fl.setFl_read(rs.getInt("fl_read"));
		               fl.setFl_ip(rs.getString("fl_ip"));
		               fl.setFl_date(rs.getString("fl_date"));		               
		               return fl;
		         }
		      });
		      return fl;
		   }
}