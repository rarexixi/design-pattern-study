package org.xi.dynamicproxy;

import org.xi.dynamicproxy.annotation.Get;
import org.xi.dynamicproxy.annotation.Param;
import org.xi.dynamicproxy.model.ConfigDetail;

public interface ConfigService {
    @Get(url = "http://172.21.206.7:10927/sys-config/detail")
    ConfigDetail getConfig(@Param("key") String key, @Param("envId") int envId);
}
