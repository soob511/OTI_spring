package com.mycompany.springframework.dto;

import lombok.Data;

@Data//자동으로 getter, setter 만들어짐.
public class Ch02LoginResult {
	private String result;
	private String mid;

}
