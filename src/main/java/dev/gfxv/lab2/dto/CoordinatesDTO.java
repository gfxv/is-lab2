package dev.gfxv.lab2.dto;

import dev.gfxv.lab2.dao.CoordinatesDAO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoordinatesDTO {
    Long id;
    Integer x;
    Long y;

    public static CoordinatesDTO fromDAO(CoordinatesDAO coordinatesDAO){
        return CoordinatesDTO.builder()
                .id(coordinatesDAO.getId())
                .x(coordinatesDAO.getX())
                .y(coordinatesDAO.getY())
                .build();
    }

    public static CoordinatesDAO toDAO(CoordinatesDTO dto) {
        CoordinatesDAO dao = new CoordinatesDAO();
        if (dto.getId() != null) {
            dao.setId(dto.getId());
        }
        dao.setX(dto.getX());
        dao.setY(dto.getY());
        return dao;
    }
}
