package org.example.JsonchangetoDTO;

import net.sf.json.JSONObject;
import org.example.JsonchangetoDTO.DTO.InternationalSchool;
import org.example.JsonchangetoDTO.DTO.Province;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String jsonData = "{\n" +
                "\t\"country\": \"中国\",\n" +
                "\t\"province\": [{\n" +
                "\t\t\t\"city\": \"西安\",\n" +
                "\t\t\t\"postoffice\": 710126,\n" +
                "\t\t\t\"school\": {\n" +
                "\t\t\t\t\"name\": \"西安电子科技大学\",\n" +
                "\t\t\t\t\"major\": \"computer\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"capital\": \"true\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"city\": \"北京\",\n" +
                "\t\t\t\"postoffice\": 826123,\n" +
                "\t\t\t\"school\": {\n" +
                "\t\t\t\t\"name\": \"北京大学\",\n" +
                "\t\t\t\t\"major\": \"fiance\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"capital\": \"true\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"city\": \"温州市\",\n" +
                "\t\t\t\"postoffice\": 236556,\n" +
                "\t\t\t\"school\": {\n" +
                "\t\t\t\t\"name\": \"浙江大学\",\n" +
                "\t\t\t\t\"major\": \"accounting\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"capital\": \"false\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        JSONObject jsonObject= JSONObject.fromObject(jsonData);
        InternationalSchool inSchool = (InternationalSchool) JSONObject.toBean(jsonObject,InternationalSchool.class);
        System.out.println(inSchool);
        String country = inSchool.getCountry();
        List<Province> provinces = inSchool.getProvince();
        System.out.println("打印provinces的到的是provinces中的结果");
    }
}
