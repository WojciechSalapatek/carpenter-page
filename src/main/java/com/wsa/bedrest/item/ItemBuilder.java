package com.wsa.bedrest.item;

import com.wsa.bedrest.category.Category;

import java.util.List;

public final class ItemBuilder {
    private long id;
    private Category category;
    private String name;
    private double price;
    private String shortDesc;
    private String fullDesc;
    private String smallImage;
    private List<String> images;

    private ItemBuilder() {
    }

    public static ItemBuilder aItem() {
        return new ItemBuilder();
    }

    public ItemBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ItemBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemBuilder withShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
        return this;
    }

    public ItemBuilder withFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
        return this;
    }

    public ItemBuilder withSmallImage(String smallImage) {
        this.smallImage = smallImage;
        return this;
    }

    public ItemBuilder withImages(List<String> images) {
        this.images = images;
        return this;
    }

    public Item build() {
        Item item = new Item();
        item.setId(id);
        item.setCategory(category);
        item.setName(name);
        item.setPrice(price);
        item.setShortDesc(shortDesc);
        item.setFullDesc(fullDesc);
        item.setSmallImage(smallImage);
        item.setImages(images);
        return item;
    }
}
