package resources.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class FileUtils {
    public static String readFixture(String relativePath) throws Exception {
        URL resource = FileUtils.class.getClassLoader().getResource(relativePath);
        return Files.toString(new File(new URI(resource.toString())), Charsets.UTF_8);
    }
}
