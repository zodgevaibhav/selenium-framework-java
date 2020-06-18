1. Set ANDROID_HOME
2. Set JAVA_HOME
3. How to find main activity
	//adb shell am set-debug-app --persistent com.android.chrome
	//adb shell pm list packages -f | grep chrome
	//adb pull /system/product/app/Chrome/Chrome.ap
	//aapt dump badging Chrome.apk |grep launchable-activity