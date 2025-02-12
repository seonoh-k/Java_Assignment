package mms.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

	private int id;
	private String name;
	private String addr;
	private String nation;
	private String email;
	private int age;
	
}
