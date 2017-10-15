# Animation 动画

## 传统动画
### 帧动画 Frame Animation

### 补间动画 Tweened Animation/View Animation

## 属性动画 Property Animation

|名称|说明|
| ------------- |:-----:|------:|
|alpha|渐变透明度|
|scale|渐变尺寸|
|translate|位置移动|
|rotate|旋转|


#### 插值器Interpolator
|名称|说明|
|----|:---:|-----:|
|AccelerateDecelerateInterpolator|先加速后减速，开始结束时慢，中间加速|
|AccelerateInterpolator|加速|
|DecelerateInterpolator| 减速，开始时快然后减速|
|AnticipateInterpolator| 反向 ，先向相反方向改变一段再加速播放|
|AnticipateOvershootInterpolator|反向加超越，先向相反方向改变，再加速播放，会超出目的值然后缓慢移动至目的值|
|BounceInterpolator|跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，80，90，100|
|CycleInterpolator| 循环，动画循环一定次数，值的改变为一正弦函数：Math.sin(2 mCycles Math.PI * input)|
|LinearInterpolator|线性，线性均匀改变|
|OvershottInterpolator| 超越，最后超出目的值然后缓慢改变到目的值|
|TimeInterpolator| 一个接口，允许你自定义interpolator，以上几个都是实现了这个接口|






