package org.apache.avro.tool;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.Sets;
import org.apache.avro.tool.xml.Configuration;
import org.apache.avro.tool.xml.HadoopProperty;

import java.io.File;
import java.io.IOException;

public class AWSConnection {

    private static File CORE_SITE_CONFIGURATION = new File("core-site.xml");

    private static void writeCoreSiteConfiguration() throws IOException {

        AWSCredentials credentials = new DefaultAWSCredentialsProviderChain().getCredentials();

        Configuration configuration = new Configuration(Sets.newHashSet(
                new HadoopProperty("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem"),
                new HadoopProperty("fs.s3a.access.key", credentials.getAWSAccessKeyId()),
                new HadoopProperty("fs.s3a.secret.key", credentials.getAWSSecretKey()),
                new HadoopProperty("fs.s3a.endpoint", "s3.eu-west-2.amazonaws.com")
        ));

        new XmlMapper().writeValue(CORE_SITE_CONFIGURATION, configuration);
    }

    public static void main(String[] args) throws Exception {
        writeCoreSiteConfiguration();
        org.apache.avro.tool.Main.main(args);
    }
}
