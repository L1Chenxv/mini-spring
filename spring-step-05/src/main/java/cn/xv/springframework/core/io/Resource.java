package cn.xv.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
