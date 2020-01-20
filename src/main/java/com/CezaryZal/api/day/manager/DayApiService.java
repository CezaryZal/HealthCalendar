package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.api.DayApiWithConnectedEntities;
import com.CezaryZal.api.day.manager.creator.DayApiCreator;
import com.CezaryZal.api.day.manager.creator.DayApiWithEntitiesCreator;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayApiService {

    private final DayRepoService dayRepoService;
    private final UserRepoService userRepoService;
    private final DayApiCreator dayApiCreator;
    private final DayApiWithEntitiesCreator dayApiWithEntitiesCreator;

    @Autowired
    public DayApiService(DayRepoService dayRepoService,
                         UserRepoService userRepoService,
                         DayApiCreator dayApiCreator,
                         DayApiWithEntitiesCreator dayApiWithEntitiesCreator) {
        this.dayRepoService = dayRepoService;
        this.userRepoService = userRepoService;
        this.dayApiCreator = dayApiCreator;
        this.dayApiWithEntitiesCreator = dayApiWithEntitiesCreator;
    }

    public DayApi getDayApiByDateAndUserId(String inputDate, Long userId) {
        Day day = dayRepoService.getDayByDateAndUserId(inputDate, userId);
        User user = userRepoService.getUserById(userId);

        return dayApiCreator.createByDayAndUser(day, user);
    }

    public DayApiWithConnectedEntities getDayApiWithEntitiesByDateAndUserId(String inputDate, Long userId) {
        Day day = dayRepoService.getDayByDateAndUserId(inputDate, userId);
        User user = userRepoService.getUserById(userId);

        return dayApiWithEntitiesCreator.createByDayAndUser(day, user);
    }
}
