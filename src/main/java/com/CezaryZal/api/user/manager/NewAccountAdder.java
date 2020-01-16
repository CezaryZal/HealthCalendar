package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountAdder {

    private UserObjectConverter converter;
    private UserService userS;
    private DailyLimitsService dailyLimitsS;

    @Autowired
    public NewAccountAdder(UserObjectConverter converter, UserService userS, DailyLimitsService dailyLimitsS) {
        this.converter = converter;
        this.userS = userS;
        this.dailyLimitsS = dailyLimitsS;
    }

//    public Long createNewAccountAndGetHimUserId(UserCreator userCreator){
//        creteAccount(userCreator);
//        User userFromDb = userS.getUserByLoginName(userCreator.getLoginName());
//        updateDailyLimitsByUser(userFromDb);
//        return userFromDb.getId();
//    }

    private void creteAccount(UserCreator userCreator){
        userS.addUser(converter.convertUserCreatorToUser(userCreator));
    }

//    private void updateDailyLimitsByUser(User userFromDb){
//        Long userId = userFromDb.getId();
//        DailyLimits tmpDailyLimits = userFromDb.getDailyLimits();
//        tmpDailyLimits.setUserId(userId);
//        dailyLimitsS.updateLimits(tmpDailyLimits);
//    }
}
