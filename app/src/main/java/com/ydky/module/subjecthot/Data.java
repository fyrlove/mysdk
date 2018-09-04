package com.ydky.module.subjecthot;
import java.util.List;

public class Data {

    private String subject_id;
    private String name;
    private String content;
    private String app_hot_image;
    private String addtime;
    private String activity_start_time;
    private String activity_end_time;
    private String share_times;
    private String show_text;
    private String copy_text;
    private String item_type;
    private List<Item_data> item_data;
    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }
    public String getSubject_id() {
        return subject_id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setApp_hot_image(String app_hot_image) {
        this.app_hot_image = app_hot_image;
    }
    public String getApp_hot_image() {
        return app_hot_image;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
    public String getAddtime() {
        return addtime;
    }

    public void setActivity_start_time(String activity_start_time) {
        this.activity_start_time = activity_start_time;
    }
    public String getActivity_start_time() {
        return activity_start_time;
    }

    public void setActivity_end_time(String activity_end_time) {
        this.activity_end_time = activity_end_time;
    }
    public String getActivity_end_time() {
        return activity_end_time;
    }

    public void setShare_times(String share_times) {
        this.share_times = share_times;
    }
    public String getShare_times() {
        return share_times;
    }

    public void setShow_text(String show_text) {
        this.show_text = show_text;
    }
    public String getShow_text() {
        return show_text;
    }

    public void setCopy_text(String copy_text) {
        this.copy_text = copy_text;
    }
    public String getCopy_text() {
        return copy_text;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }
    public String getItem_type() {
        return item_type;
    }

    public void setItem_data(List<Item_data> item_data) {
        this.item_data = item_data;
    }
    public List<Item_data> getItem_data() {
        return item_data;
    }

}