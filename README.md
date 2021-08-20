# usefull-code
Some usefull code collection

## Sign and verify:https://www.cnblogs.com/lene-y/p/11579997.html

## Android judge background and foreground


```kotlin
private var mForeground = false
private var mResumedActivityCount = 0

registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
      override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e(TAG, "${activity::class.java.name} onActivityCreated")
      }

      override fun onActivityStarted(activity: Activity) {
        Log.e(TAG, "${activity::class.java.name} onActivityStarted")
      }

      override fun onActivityResumed(activity: Activity) {
        Log.e(TAG, "${activity::class.java.name} onActivityResumed")
        mResumedActivityCount++
        if (!mForeground) {
          if (mResumedActivityCount >= 1) {
            mForeground = true
            Log.e(TAG, "foreground")
          }
        }
      }

      override fun onActivityPaused(activity: Activity) {
        Log.e(TAG, "${activity::class.java.name} onActivityPaused")
      }

      override fun onActivityStopped(activity: Activity) {
        Log.e(TAG, "${activity::class.java.name} onActivityStopped")
        mResumedActivityCount--
        if (mForeground) {
          if (mResumedActivityCount <= 0) {
            mForeground = false
            Log.e(TAG, "background")
          }
        }
      }

      override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
      }

      override fun onActivityDestroyed(activity: Activity) {
        Log.e(TAG, "${activity::class.java.name} onActivityDestroyed")
      }

    })
    
```    
