package com.whatsapp.VO;

import lombok.Data;

@Data
public class ContactVO {
    private Integer contactId;
    private String name;
    private String number;
    private String city;
    private Integer userId;
}
