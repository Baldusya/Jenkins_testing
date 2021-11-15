package models;

import lombok.Data;

@Data
public class PostModel {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
