package com.CezaryZal.api.body.manager.mapper;

import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDao;
import org.springframework.stereotype.Service;


@Service
public class ConverterDaoToBodySize {

    public BodySize mappingEntity(BodySizeDao bodySizeDao){
        return new BodySize(
                bodySizeDao.getId(),

                bodySizeDao.getBodyWeight(),
                bodySizeDao.getNeckSize(),
                bodySizeDao.getArmSize(),
                bodySizeDao.getBustSize(),
                bodySizeDao.getWaist(),
                bodySizeDao.getHipsSize(),
                bodySizeDao.getFemoralSize(),
                bodySizeDao.getCalf(),
                bodySizeDao.getDateMeasurement(),
                bodySizeDao.getUserId());

    }

}
