package kr.ac.kumoh.oiyo.mydiaryback.service;

import kr.ac.kumoh.oiyo.mydiaryback.repository.PostUserInfoDto;
import kr.ac.kumoh.oiyo.mydiaryback.repository.User;
import kr.ac.kumoh.oiyo.mydiaryback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public int updateUser(PostUserInfoDto updateUserInfo){
        User user = userRepository.findByEmail(updateUserInfo.getEmail()).orElseThrow(()->{
            return new IllegalArgumentException("수정하기 위한 회원 찾기 실패!");
        });

        user.setProfileIntroduction(updateUserInfo.getProfileIntroduction());
        user.setBirthDatebyString(updateUserInfo.getBirthDate());
        user.setAddress(updateUserInfo.getAddress());

        userRepository.save(user);

        return 1;
    }
}