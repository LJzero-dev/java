package spr;

import java.util.*;

public class MemberDao {
	private static int newIdx = 0;
	private Map<String, MemberInfo> map = new HashMap<String, MemberInfo>();
	
	public MemberInfo selectByUid(String uid) {
		return map.get(uid);
	}
	
	public void insert(MemberInfo mi) {
		mi.setIdx(++newIdx);
		map.put(mi.getUid(), mi);
	}
	
	public void update(MemberInfo mi) {
		map.put(mi.getUid(), mi);
	}
}