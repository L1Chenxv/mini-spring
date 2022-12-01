package cn.xv.springframework.core.io;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @version 1.0
 * @create: 2022-12-01 20:26
 * @author: L1Chenxv
 * @************
 * @description:
 */
@Data
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource( String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
}
