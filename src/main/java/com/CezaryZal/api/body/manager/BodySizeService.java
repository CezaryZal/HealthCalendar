package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.BodySizeRepository;
import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDao;
import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.mapper.ConverterBodySizeToDto;
import com.CezaryZal.api.body.manager.mapper.ConverterDaoToBodySize;
import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodySizeService extends BodySizeRepoService {

    private ConverterBodySizeToDto converterBodySizeToDto;
    private ConverterDaoToBodySize converterDaoToBodySize;

    @Autowired
    public BodySizeService(BodySizeRepository BSRepository,
                           ConverterBodySizeToDto converterBodySizeToDto,
                           ConverterDaoToBodySize converterDaoToBodySize) {
        super(BSRepository);
        this.converterBodySizeToDto = converterBodySizeToDto;
        this.converterDaoToBodySize = converterDaoToBodySize;
    }

    public BodySizeDto getBodySizeDtoById(Long id) {
        return converterBodySizeToDto.mappingEntity(getBodyById(id));
    }

    public BodySizeDto getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        return converterBodySizeToDto.mappingEntity(getBodyByDateAndUserId(inputDate, userId));
    }

    public List<BodySizeDto> getListBodySizeDto() {
        List<BodySize> allBodySize = getAll();
        List<BodySizeDto> listBodySizeDto = new ArrayList<>();
        allBodySize.forEach(tmpBS -> listBodySizeDto.add(converterBodySizeToDto.mappingEntity(tmpBS)));
        return listBodySizeDto;
    }

    public String addBodySizeByDao(BodySizeDao bodySizeDao) {
        addBody(converterDaoToBodySize.mappingEntity(bodySizeDao));
        return "Przesłany pomiar ciała został zapisany w bazie danych";
    }

    public String updateBodySizeByDao(BodySizeDao bodySizeDao){
        updateBody(converterDaoToBodySize.mappingEntity(bodySizeDao));
        return "Przesłany pomiar został uaktualniony";
    }

    public String deleteBodySizeById(Long id){
        deleteBodyById(id);
        return "Pomiar ciała o przesłanym id został usunięty";
    }
}
