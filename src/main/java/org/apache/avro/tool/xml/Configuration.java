package org.apache.avro.tool.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;
import java.util.Set;

@JacksonXmlRootElement(localName = "configuration")
public class Configuration {

    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<HadoopProperty> property;

    public Configuration(Set<HadoopProperty> property) {
        this.property = property;
    }

    public Set<HadoopProperty> getProperty() {
        return property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(property, that.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "property=" + property +
                '}';
    }
}
