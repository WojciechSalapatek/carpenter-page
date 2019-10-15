package com.wsa.bedrest.comment;

import com.wsa.bedrest.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = PACKAGE)
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private String nickname;
    private String message;

}
