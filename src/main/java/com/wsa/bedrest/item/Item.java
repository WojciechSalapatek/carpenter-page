package com.wsa.bedrest.item;

import com.wsa.bedrest.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Data
@NoArgsConstructor(access = PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Category category;

    @ElementCollection(targetClass = String.class)
    private List<String> images;
    private String name;
    private double price;
    private String shortDesc;
    @Column(length=10485760)
    private String fullDesc;
    private String smallImage;


}
