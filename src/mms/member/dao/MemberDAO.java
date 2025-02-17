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
	            String timestamp = getCurrentTimestamp();  // 현재 시간 가져오기
	            logList.add("[" + timestamp + "] Added new member: " + newMember);  // 로그에 시간 포함
	    }

		
		return isInsertSuccess;
	}
	
	public void printMember(int memberId) { // 리스트 출력
		
		if(memberId == 0) { // 0을 입력하면 회원 전체 출력
			memberList.forEach(System.out::println);
		}else {
			boolean found = false;
			for(Member member : memberList) {
				if(member.getId() == memberId) { // 입력한 아이디와 같은 아이디를 가지는 회원 정보 출력
					System.out.println(member);
					found = true; // 입력한 아이디와 일치하는 회원이 존재할 경우 true로 변경하고 반복문 종료.
					break;
				}
			}
			
			if(!found) { // 입력한 아이디와 일치하는 회원 정보가 없으면
				System.out.println("입력하신 아이디와 일치하는 회원 정보가 없습니다");
			}
		}		
	}
	
	public boolean deleteMember(int memberId) { // 회원 정보 삭제
		
		boolean isDeleteSuccess = false;
		
		Member memberToDelete = null; // 삭제할 회원 정보를 담을 빈 객체 생성
		
		for(Member member : memberList) {
			if(member.getId() == memberId) { // 입력한 아이디와 일치하는 회원 정보를 빈 객체에 저장
				memberToDelete = member;
				break;
			}
		}
		
		if(memberToDelete != null) { // 삭제할 회원 정보가 있다면
			memberList.remove(memberToDelete); // 회원 정보 삭제
			String timestamp = getCurrentTimestamp();  // 현재 시간 가져오기
            logList.add(String.format("[%s] Deleted member: %s", timestamp, memberToDelete)); // 삭제된 회원 정보 포함
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
	        	String timestamp = getCurrentTimestamp();  // 현재 시간 가져오기
	        	logList.add(String.format("[%s] Updated member: %s → %s", timestamp, member, updatedMember)); // 수정 전후 정보 포함
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


	static List<String> logList = new CopyOnWriteArrayList<>();  // 로그 저장을 위한 logList 추가
	
	private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

	 // 모든 로그 반환
    public static List<String> getAllMemberLogs() {
        return logList;  
    }

	
	// 특정 회원의 마지막 액션 타임스탬프 가져오기
    public String getLastActionTimestamp(int memberId) {
        for (int i = logList.size() - 1; i >= 0; i--) { // 최신 로그부터 탐색
            String logEntry = logList.get(i);
            if (logEntry.contains("Member(id=" + memberId + ",")) { // 해당 회원 ID가 포함된 로그 찾기
                return logEntry.substring(1, 20); // [YYYY-MM-DD HH:mm:ss] 부분만 추출
            }
        }
        return "해당 회원의 기록이 없습니다."; // 해당 회원의 로그가 없을 경우
    }
    
    public void showLastActionTimestamp(int memberId) {
        String lastActionTime = getLastActionTimestamp(memberId);
        
        if (lastActionTime.equals("해당 회원의 기록이 없습니다.")) {
            System.out.println("해당 회원의 최근 관리 기록이 없습니다.");
        } else {
            System.out.println("관리 기록 : " + lastActionTime);
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
//			System.out.println("기록이 존재하지 않습니다");
//		}
//		
//	}