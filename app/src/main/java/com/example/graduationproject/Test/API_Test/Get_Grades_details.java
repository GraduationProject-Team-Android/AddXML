package com.example.graduationproject.Test.API_Test;

import java.util.List;

public class Get_Grades_details {
    private int id ;
    private int cluster_id ;
    private String name ;
    private String created_at;
    private String updated_at;
    private Pivot_User_Grades pivot ;

    public Pivot_User_Grades getPivot() {
        return pivot;
    }

    public void setPivot(Pivot_User_Grades pivot) {
        this.pivot = pivot;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCluster_id() {
        return cluster_id;
    }

    public void setCluster_id(int cluster_id) {
        this.cluster_id = cluster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
