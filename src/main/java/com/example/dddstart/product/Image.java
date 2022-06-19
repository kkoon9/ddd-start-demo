package com.example.dddstart.product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private Date uploadTime;

    protected Image() {}

    public Image(String path) {
        this.path = path;
    }

    protected String getPath() {
        return path;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public boolean hasThumbnail() {
        // 성능을 위해 다형성을 포기하고 if-else로 구현
        if(imageType.equals("II")) {
            return true;
        } else {
            return false;
        }
    }
}
