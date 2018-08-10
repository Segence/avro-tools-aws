Avro Tools AWS
==============

A version of [Avro Tools](https://avro.apache.org/docs/1.8.2/gettingstartedjava.html) that supports using files directly on [Amazon Web Services](https://aws.amazon.com/).

The usage is identical to the original version of Avro Tools except this version will create a `core-site.xml` file in the directory where it is running from to allow the
Hadoop-client, Avro Tools relies on, to establish connectivity to AWS.

Usage:

1. Make sure the AWS credentials are set in one of the [supported mehtods](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html#credentials-default)
2. Run: `java -cp .:path-to-avro-tools-aws/avro-tools-aws.jar org.apache.avro.tool.AWSConnection getmeta s3a://bucket/../...avro`


To use the original Avro Tools without AWS support simply use: `java -cp .:build/libs/avro-tools-aws-1.8.2-all.jar org.apache.avro.tool.Main getmeta s3a://bucket/../...avro`


