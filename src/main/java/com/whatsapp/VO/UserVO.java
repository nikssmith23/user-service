package com.whatsapp.VO;

import com.whatsapp.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVO {
    private User user;
    private ContactList contact;

}
