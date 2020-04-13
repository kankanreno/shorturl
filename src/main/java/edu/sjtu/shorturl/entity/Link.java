package edu.sjtu.shorturl.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "links")
@DynamicUpdate  // update 对象的时候，生成动态的 update 语句，如果这个字段的值是 null 就不会被加入到 update 语句中，默认false
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String longUrl;
    private String shortUrl;
}
