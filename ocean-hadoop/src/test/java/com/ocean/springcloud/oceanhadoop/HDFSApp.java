package com.ocean.springcloud.oceanhadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author 季超
 * @create 2018-12-23 9:10
 * @desc HDFS Java API操作
 **/
public class HDFSApp {

    public static final String HDFS_PATH = "hdfs://dachao3:9000";
     FileSystem fileSystem = null;
     Configuration configuration = null;






     @Test
     public void mkdir() throws IOException {

         fileSystem.mkdirs(new Path("/hdfs/test"));

     }



    @Before
    public void setUp() throws Exception {
        System.out.println("HDFSapp.setUp");
        configuration = new Configuration();
//        configuration.set("HADOOP_HOME","/usr/local/hadoop-2.9.2");
//        configuration.set("hadoop.home.dir","/usr/local/hadoop-2.9.2/temp");
        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration);


    }


    /**
     * 资源释放
     */
    @After
    public void tearDown(){
        configuration = null;
        fileSystem = null;

        System.out.println("HDFSapp.tearDown");
    }


}
