![](http://olax25rea.bkt.clouddn.com/217990-20170219155424582-264022190.png)

第一步:
   打包资源文件,生成R.java文件
   工具:aapt工具
第二步:
   处理AIDL文件，生成对应的.java文件（当然，有很多工程没有用到AIDL，那这个过程就可以省了）
第三步:
   编译java文件,生成对应的.class文件
第四步:
   把.class文件转换成.dex文件
第五步:
   打包生成未签名的.apk文件
   工具:apkbuilder
第六步:
   对未签名.apk文件进行签名
   工具:jarsigner 
第七步:对签名后的.apk文件进行对齐处理
   工具:zipalign工具