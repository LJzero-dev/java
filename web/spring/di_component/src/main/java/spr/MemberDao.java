package spr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component	// 스프링이 검색해서 빈으로 등록시킬 수 있도록 스캔 대상으로 표시해 주는 애노테이션
public class MemberDao {
	private static int newIdx = 0;
	private Map<String, MemberInfo> map = new HashMap<String, MemberInfo>();
	
	public MemberInfo selectByUid(String uid) {
		return map.get(uid);
	}
	
	public void insert(MemberInfo mi) {
		//	사용자가 입력한 데이터들을 저장한 mio 인스턴스로 회원가입시키는 메소드
		mi.setIdx(++newIdx);
		//	newIdx는 static으로 선언되어 클래스 변수이므로 인스턴스와 상관없이 하나만 존재
		//	newIdx의 값을 먼저 1증가 시킨 후 mi 인스턴스의 setIdx()메소드로 저장
		map.put(mi.getUid(), mi);
		//	회원 정보들이 저장되어있는 map에 mi인스턴스를 저장하여 회원 가입을 시킴
	}
	
	public void update(MemberInfo mi) {
		map.put(mi.getUid(), mi);	// key에 해당하는 값(mi.getUid())이 이미 있을 경우 map은 덮어쓰기를 함
	}

	public Collection<MemberInfo> selectAll() {
		return map.values();	// values() : 맵의 value들만 Collection형으로 리턴하는 메소드
	}
}