1 资源准备
在开始开发前，请确保已准备好以下资源：

海康SDK动态链接库（DLL文件）： 海康威视官方提供的核心开发组件，代码基于 Windows 开发，所以选择DLL文件，文件可前往海康威视官网下载。
设备网络SDK开发使用手册： 包含API文档和开发指南，便于快速上手开发，手册同样可在官网下载。
球机连接信息：
IP地址
端口号
登录账号和密码
开发工具：
IntelliJ IDEA（推荐使用最新版本）

2 环境配置
开发环境如下：
基础环境：
操作系统：Windows 10
JDK 17：Kotlin开发需要Java环境支持
Gradle 8.5：项目构建工具
技术选型：
JNA（Java Native Access）：开源Java框架，提供简便方式访问本地共享库（如DLL文件），无需编写JNI代码

详细可以查看我的博客：
https://lenz.pics/blog/kotlin-hikvision-sdk.html
