package org.example.JsonchangetoDTO.DTO;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: LIVI
 * @Time: 2022/10/10  14:48
 * @Description:
 */
public class InternationalSchool implements Serializable {
    private String country;
    private List<Province> province;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Province> getProvince() {
        return province;
    }

    public void setProvince(List<Province> province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "InternationalSchool{" +
                "country='" + country + '\'' +
                ", province=" + province +
                '}';
    }
}