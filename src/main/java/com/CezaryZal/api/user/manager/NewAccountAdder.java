package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.DailyLimits;
import com.CezaryZal.api.limits.DailyLimitsService;
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

    public Long createNewAccount(UserCreator userCreator){
        User user = converter.convertUserCreatorToUser(userCreator);
        userS.addUser(user);
        User userFromDb = userS.getUserByLoginName(userCreator.getLoginName());
        return updateDailyLimitsByUser(userFromDb);
    }

    private Long updateDailyLimitsByUser(User user){
        Long userId = user.getId();
        DailyLimits tmpDailyLimits = user.getDailyLimits();
        tmpDailyLimits.setUserId(userId);
        dailyLimitsS.updateLimits(tmpDailyLimits);
        return userId;
    }
}
