###提高优先级
* 前台进程
  a. 进程中包含处于前台的正与用户交互的activity;
  b. 进程中包含与前台activity绑定的service;
  c. 进程中包含调用了startForeground()方法的service;
  d. 进程中包含正在执行onCreate(), onStart(), 或onDestroy()方法的service;
  e. 进程中包含正在执行onReceive()方法的BroadcastReceiver.
2、可视进程
3、服务进程
4、后台进程
5、空进程