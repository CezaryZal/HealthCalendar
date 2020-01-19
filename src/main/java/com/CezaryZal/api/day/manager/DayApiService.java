package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.DayRepository;
import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.api.DayApiWithConnectedEntities;
import com.CezaryZal.api.day.manager.creator.DayApiCreator;
import com.CezaryZal.api.day.manager.creator.DayApiWithEntitiesCreator;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayApiService extends DayRepoService {

    private final UserService userService;
    private final DayApiCreator dayApiCreator;
    private final DayApiWithEntitiesCreator dayApiWithEntitiesCreator;

    @Autowired
    public DayApiService(DayRepository dayRepository,
                         UserService userService,
                         DayApiCreator dayApiCreator,
                         DayApiWithEntitiesCreator dayApiWithEntitiesCreator) {
        super(dayRepository);
        this.userService = userService;
        this.dayApiCreator = dayApiCreator;
        this.dayApiWithEntitiesCreator = dayApiWithEntitiesCreator;
    }

    public DayApi getDayApiByDateAndUserId(String inputDate, Long userId) {
        Day day = getDayByDateAndUserId(inputDate, userId);
        User user = userService.getUserById(userId);

        return dayApiCreator.createByDayAndUser(day, user);
    }

    public DayApiWithConnectedEntities getDayApiWithEntitiesByDateAndUserId(String inputDate, Long userId) {
        Day day = getDayByDateAndUserId(inputDate, userId);
        User user = userService.getUserById(userId);

        return dayApiWithEntitiesCreator.createByDayAndUser(day, user);
    }
}
