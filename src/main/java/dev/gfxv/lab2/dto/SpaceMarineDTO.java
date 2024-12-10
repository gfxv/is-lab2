package dev.gfxv.lab2.dto;

import dev.gfxv.lab2.dao.SpaceMarineDAO;
import dev.gfxv.lab2.dao.enums.MeleeWeapon;
import dev.gfxv.lab2.dao.enums.Weapon;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpaceMarineDTO {
    Long id;
    String name;
    LocalDate creationDate;
    Integer health;
    Long height;
    Weapon weapon;
    MeleeWeapon meleeWeapon;
    CoordinatesDTO coordinates;
    ChapterDTO chapter;
    UserDTO owner;

    public static SpaceMarineDTO fromDAO(SpaceMarineDAO spaceMarineDAO) {
        return SpaceMarineDTO
                .builder()
                .id(spaceMarineDAO.getId())
                .name(spaceMarineDAO.getName())
                .creationDate(spaceMarineDAO.getCreationDate())
                .health(spaceMarineDAO.getHealth())
                .height(spaceMarineDAO.getHeight())
                .weapon(spaceMarineDAO.getWeapon())
                .meleeWeapon(spaceMarineDAO.getMeleeWeapon())
                .coordinates(CoordinatesDTO.fromDAO(spaceMarineDAO.getCoordinates()))
                .chapter(ChapterDTO.fromDAO(spaceMarineDAO.getChapter()))
                .owner(UserDTO.fromDAO(spaceMarineDAO.getUser()))
                .build();
    }

    public static SpaceMarineDAO toDAO(SpaceMarineDTO dto) {
        SpaceMarineDAO dao = new SpaceMarineDAO();
        if (dto.getId() != null) {
            dao.setId(dto.getId());
        }
        dao.setName(dto.getName());
        dao.setCreationDate(dto.getCreationDate());
        dao.setHealth(dto.getHealth());
        dao.setHeight(dto.getHeight());
        dao.setWeapon(dto.getWeapon());
        dao.setMeleeWeapon(dto.getMeleeWeapon());
        dao.setCoordinates(CoordinatesDTO.toDAO(dto.getCoordinates()));
        dao.setChapter(ChapterDTO.toDAO(dto.getChapter()));
        return dao;
    }
}
