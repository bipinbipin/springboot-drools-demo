package com.praveen.drools.example.model;

public class Resource {

    private String namespace;
    private String key;

    public Resource() {}

    public Resource(String namespace, String key) {
        this.namespace = namespace;
        this.key = key;
    }

    public String getNamespace() {return namespace;}
    public void setNamespace(String namespace) {this.namespace = namespace;}
    public String getKey() {return key; }
    public void setKey(String key) {this.key = key;}

    @Override
    public String toString() {
        return "Resource{" +
                "namespace='" + namespace + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
