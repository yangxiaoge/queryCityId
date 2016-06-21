# 本Demo 主要是 获取City Id

其中关于 service(四大组件之一)的, 可以不看, 就是服务的开启关闭。

使用查询天气用到的City Id

`例如:`
> http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=101190101

`city id`跟`name`存在`citycode.txt`文件中, 文件位于 `assets` 目录下:

txt中数据格式: `101190101=南京` ---> cityid=name (等号分割)

1. 本demo用了 ormlite 框架操作sqlite ,详情见 鸿洋: http://blog.csdn.net/lmj623565791/article/details/39121377
2. 也可以用最简单的文件读取(每次查询都要重新读取文件), 然后 传入 name匹配,之后取出citycode,这种方式效率不高,建议第一种,直接写到数据库中.

