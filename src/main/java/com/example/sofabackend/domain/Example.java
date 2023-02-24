package com.example.sofabackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "example")
public class Example {

    @Id
    private String id;
    private Integer number;
    private String title;
    private String type;

    // TODO not working, can't start server with this
    // please try
    //https://blog.csdn.net/JavaSupeMan/article/details/125990369?ops_request_misc=&request_id=&biz_id=102&utm_term=jpa%20mysql%20json&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-125990369.142^v73^control_1,201^v4^add_ask,239^v2^insert_chatgpt&spm=1018.2226.3001.4187

//    @Column(name = "extra")
//    @Convert(attributeName = "extra", converter = JsonToMapConverter.class)
//    private Map<String, Object> extra = new HashMap<>();
    private String text;
}
