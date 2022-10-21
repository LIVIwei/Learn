package org.example.JsonchangetoDTO.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: LIVI
 * @Time: 2022/10/10  14:51
 * @Description:
 */
@Data
public class School implements Serializable {
    private String name;
    private String major;
}