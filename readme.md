二级缓存redis关闭配置：
application-dev.yml
j2cache:
    l2-cache-open: false ## false 关闭二级缓存  true 打开二级缓存
j2cache-dev.properties
##打开二级缓存时 打开
#j2cache.L2.provider_class = lettuce
##关闭二级缓存时 打开
j2cache.L2.provider_class = none
##打开二级缓存时 打开
#j2cache.broadcast = lettuce
##关闭二级缓存时 打开
j2cache.broadcast =net.oschina.j2cache.cache.support.redis.SpringRedisPubSubPolicy