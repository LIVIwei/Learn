package org.example.JsonchangetoDTO.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: LIVI
 * @Time: 2022/10/10  14:49
 * @Description:
 */
@Data
public class Province implements Serializable {
    private String city;
    private String postoffice;
    private List<School> school;
    private boolean capital;
}