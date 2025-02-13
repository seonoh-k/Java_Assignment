package mms.member.action;

import java.util.Scanner;
import mms.member.svc.MemberEditService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberEditAction implements Action {

    @Override
    public void execute(Scanner sc) throws Exception {
        ConsoleUtil cu = new ConsoleUtil();
        
        int memberId = cu.inputMemberId(sc); 
        Member updatedMember = cu.EditMember(sc, memberId); 
        
        MemberEditService memberService = new MemberEditService();
        
        boolean isEditSuccess = memberService.editMember(updatedMember);
        
        if (isEditSuccess) {
            System.out.printf("���̵� %d�� ȸ������ �����Ϸ�\n", memberId);
        } else {
            System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
        }
    }
}