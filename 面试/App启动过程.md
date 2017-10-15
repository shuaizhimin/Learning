1、init.rc
service zygote /system/bin/app_process -Xzygote /system/bin --zygote --start-system-server
2、





* kernal启动->init进程启动->读取init.rc文件,准备启动app_process;
* 启动app_process,初始化AppRunTime对象
* AppRunTime创建一个虚拟机
* 虚拟机初始化并执行目标类‘zygoteInit’的main函数
* ZygoteInit的main函数执行，注册Socket服务端，加载framework
* 