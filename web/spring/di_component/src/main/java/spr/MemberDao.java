package spr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component	// �������� �˻��ؼ� ������ ��Ͻ�ų �� �ֵ��� ��ĵ ������� ǥ���� �ִ� �ֳ����̼�
public class MemberDao {
	private static int newIdx = 0;
	private Map<String, MemberInfo> map = new HashMap<String, MemberInfo>();
	
	public MemberInfo selectByUid(String uid) {
		return map.get(uid);
	}
	
	public void insert(MemberInfo mi) {
		//	����ڰ� �Է��� �����͵��� ������ mio �ν��Ͻ��� ȸ�����Խ�Ű�� �޼ҵ�
		mi.setIdx(++newIdx);
		//	newIdx�� static���� ����Ǿ� Ŭ���� �����̹Ƿ� �ν��Ͻ��� ������� �ϳ��� ����
		//	newIdx�� ���� ���� 1���� ��Ų �� mi �ν��Ͻ��� setIdx()�޼ҵ�� ����
		map.put(mi.getUid(), mi);
		//	ȸ�� �������� ����Ǿ��ִ� map�� mi�ν��Ͻ��� �����Ͽ� ȸ�� ������ ��Ŵ
	}
	
	public void update(MemberInfo mi) {
		map.put(mi.getUid(), mi);	// key�� �ش��ϴ� ��(mi.getUid())�� �̹� ���� ��� map�� ����⸦ ��
	}

	public Collection<MemberInfo> selectAll() {
		return map.values();	// values() : ���� value�鸸 Collection������ �����ϴ� �޼ҵ�
	}
}