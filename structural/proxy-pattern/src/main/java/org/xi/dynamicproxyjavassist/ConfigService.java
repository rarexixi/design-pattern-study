package org.xi.dynamicproxyjavassist;

import org.xi.dynamicproxyjavassist.annotation.Get;
import org.xi.dynamicproxyjavassist.annotation.Param;
import org.xi.dynamicproxyjavassist.model.ConfigDetail;

public interface ConfigService {
    @Get(url = "http://172.21.206.7:10927/sys-config/detail")
    ConfigDetail getConfig(@Param("key") String key, @Param("envId") int envId);
}
