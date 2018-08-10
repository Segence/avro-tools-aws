package org.apache.avro.tool.xml;

import java.util.Objects;

public class HadoopProperty {

    private String name;
    private String value;

    public HadoopProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HadoopProperty that = (HadoopProperty) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "HadoopProperty{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
