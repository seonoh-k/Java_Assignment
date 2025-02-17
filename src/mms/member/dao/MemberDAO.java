package mms.member.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {

	static List<Member> memberList = new CopyOnWriteArrayList<>();
	
	public boolean insertNewMember(Member newMember) {
		
		boolean isInsertSuccess = memberList.add(newMember);
		
		if (isInsertSuccess) {
	            String timestamp = getCurrentTimestamp();  // ���� �ð� ��������
	            logList.add("[" + timestamp + "] Added new member: " + newMember);  // �α׿� �ð� ����
	    }

		
		return isInsertSuccess;
	}
	
	public void printMember(int memberId) { // ����Ʈ ���
		
		if(memberId == 0) { // 0�� �Է��ϸ� ȸ�� ��ü ���
			memberList.forEach(System.out::println);
		}else {
			boolean found = false;
			for(Member member : memberList) {
				if(member.getId() == memberId) { // �Է��� ���̵�� ���� ���̵� ������ ȸ�� ���� ���
					System.out.println(member);
					found = true; // �Է��� ���̵�� ��ġ�ϴ� ȸ���� ������ ��� true�� �����ϰ� �ݺ��� ����.
					break;
				}
			}
			
			if(!found) { // �Է��� ���̵�� ��ġ�ϴ� ȸ�� ������ ������
				System.out.println("�Է��Ͻ� ���̵�� ��ġ�ϴ� ȸ�� ������ �����ϴ�");
			}
		}		
	}
	
	public boolean deleteMember(int memberId) { // ȸ�� ���� ����
		
		boolean isDeleteSuccess = false;
		
		Member memberToDelete = null; // ������ ȸ�� ������ ���� �� ��ü ����
		
		for(Member member : memberList) {
			if(member.getId() == memberId) { // �Է��� ���̵�� ��ġ�ϴ� ȸ�� ������ �� ��ü�� ����
				memberToDelete = member;
				break;
			}
		}
		
		if(memberToDelete != null) { // ������ ȸ�� ������ �ִٸ�
			memberList.remove(memberToDelete); // ȸ�� ���� ����
			String timestamp = getCurrentTimestamp();  // ���� �ð� ��������
            logList.add(String.format("[%s] Deleted member: %s", timestamp, memberToDelete)); // ������ ȸ�� ���� ����
			isDeleteSuccess = true;
		}else {
			isDeleteSuccess = false;
		}
		
		return isDeleteSuccess;
	}
	
	public boolean updateMember(Member updatedMember) { 
	    boolean isUpdateSuccess = false;

	    for (Member member : memberList) {
	        if (member.getId() == updatedMember.getId()) { 
	        	String timestamp = getCurrentTimestamp();  // ���� �ð� ��������
	        	logList.add(String.format("[%s] Updated member: %s �� %s", timestamp, member, updatedMember)); // ���� ���� ���� ����
	            memberList.set(memberList.indexOf(member), updatedMember);
	            isUpdateSuccess = true;
	            break;
	        }
	    }

	    return isUpdateSuccess; 
	}
	
	public Member getMemberById(int memberId) {
		for (Member member : memberList) {
			if (member.getId() == memberId) {
				return member; 
				}
			}
		return null; 
		}


	static List<String> logList = new CopyOnWriteArrayList<>();  // �α� ������ ���� logList �߰�
	
	private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

	 // ��� �α� ��ȯ
    public static List<String> getAllMemberLogs() {
        return logList;  
    }

	
	// Ư�� ȸ���� ������ �׼� Ÿ�ӽ����� ��������
    public String getLastActionTimestamp(int memberId) {
        for (int i = logList.size() - 1; i >= 0; i--) { // �ֽ� �α׺��� Ž��
            String logEntry = logList.get(i);
            if (logEntry.contains("Member(id=" + memberId + ",")) { // �ش� ȸ�� ID�� ���Ե� �α� ã��
                return logEntry.substring(1, 20); // [YYYY-MM-DD HH:mm:ss] �κи� ����
            }
        }
        return "�ش� ȸ���� ����� �����ϴ�."; // �ش� ȸ���� �αװ� ���� ���
    }
    
    public void showLastActionTimestamp(int memberId) {
        String lastActionTime = getLastActionTimestamp(memberId);
        
        if (lastActionTime.equals("�ش� ȸ���� ����� �����ϴ�.")) {
            System.out.println("�ش� ȸ���� �ֱ� ���� ����� �����ϴ�.");
        } else {
            System.out.println("���� ��� : " + lastActionTime);
        }
    
    }

		
}

//	public void saveLog(String log) {
//		
//		logList.add(log);
//		
//	}
//	
//	public void getLog() {
//				
//		if(logList != null) {
//			logList.forEach(System.out::println);
//		}else {
//			System.out.println("����� �������� �ʽ��ϴ�");
//		}
//		
//	}