package mms.member.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {

    static List<Member> memberList = new CopyOnWriteArrayList<>();

    public boolean insertNewMember(Member newMember) {
        return memberList.add(newMember);
    }

    public void printMember() { // 리스트 출력
        memberList.forEach(System.out::println);
    }

    public boolean deleteMember(int memberId) { // 회원 정보 삭제
        boolean isDeleteSuccess = false;
        Member memberToDelete = null;

        for (Member member : memberList) {
            if (member.getId() == memberId) {
                memberToDelete = member;
                break;
            }
        }

        if (memberToDelete != null) {
            memberList.remove(memberToDelete);
            isDeleteSuccess = true;
        }
        return isDeleteSuccess;
    }

    public Member getMemberById(int memberId) { // 회원 ID로 회원 정보 조회
        for (Member member : memberList) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null; // 회원이 존재하지 않음
    }

    public boolean updateMember(Member updatedMember) { // 회원 정보 업데이트
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == updatedMember.getId()) {
                memberList.set(i, updatedMember);
                return true; // 업데이트 성공
            }
        }
        return false; // 업데이트 실패 (회원이 존재하지 않음)
    }
}