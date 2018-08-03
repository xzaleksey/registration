package com.avalyakin.registration.mongo.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNumServiceImpl implements UserNumService {

    @Autowired
    private UserNumRepository userNumRepository;

    @Override
    public long getNext() {
        UserNum last = userNumRepository.findTopByOrderByIdDesc();
        UserNum next;
        if (last == null) {
            next = new UserNum(1);
        } else {
            long lastNum = last.getSeq();
            next = new UserNum(lastNum + 1);
        }
        userNumRepository.save(next);
        return next.getSeq();
    }
}