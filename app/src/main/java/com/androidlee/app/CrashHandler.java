package com.androidlee.app;

import android.content.Intent;

import com.androidlee.ui.MainActivity;

/**
 * Created by Kevin on 2016/1/5.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private LibraryApp shekuApp;
    public static CrashHandler INSTANCE = null;

    /**
     * 获取CrashHandler实例
     */
    public static CrashHandler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CrashHandler();
        return INSTANCE;
    }

    public void init(LibraryApp shekuApp) {
        this.shekuApp = shekuApp;
        // 设置该类为线程默认UncatchException的处理器。
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void restartApp(){
        Intent intent = new Intent(shekuApp,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shekuApp.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 当UncaughtException发生时会回调该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println("system wrong....");
        restartApp();
//        Intent intent = new Intent(shekuApp, StartActivity.class);
//        shekuApp.startActivity(intent);
//        for (Activity activity : app.getActivityStack()) {
//            if (activity instanceof StartActivity) {
//                activity.finish();
//            }
//        }

        // MBOPApplication app=(MBOPApplication) mainContext;
        // app.setNeed2Exit(true);
        //异常信息收集
//        collectCrashExceptionInfo(thread, ex);
        //应用程序信息收集
//        collectCrashApplicationInfo(app);
        //保存错误报告文件到文件。
//        saveCrashInfoToFile(ex);
        //MBOPApplication.setCrash(true);
        //判断是否为UI线程异常，thread.getId()==1 为UI线程
//        if (thread.getId() != 1) {
////            System.out.println("Exception ThreadId" + thread.getId());
//            thread.interrupt();
//            //TODO 跳转到IndexActivity
//            System.out.println("Thread ID--->" + Thread.currentThread().getId());
////            Intent intent =new Intent(mainContext,IndexActivity.class);
////            actContext.startActivity(intent);
//            //弹出对话框提示用户是否上传异常日志至服务器
//            new Thread() {
//                public void run() {
//                }
//
//                {
//                    Looper.prepare();
//                    new AlertDialog.Builder(app.currentActivity())
//                            .setTitle("异常处理") //
//                            .setMessage("您的程序出现异常，是否将异常信息上传至服务器?")//
//                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
//
//                                public void onClick(DialogInterface dialog, int which) {
//                                    new Thread(new Runnable() {
//
//                                        @Override
//                                        public void run() {
////                                            sendCrashReportsToServer(app, false);
//
//                                        }
//                                    }).start();
////                            new Thread(){
////                                public void run() {}{
////                                    try{
////                                        System.out.println("执行上传线程ID"+this.getId());
////                                        this.sleep(5000);
////                                    }catch(Exception e){
////
////                                    }
////                                    sendCrashReportsToServer(app);
////                                }
////                            }.start();
//                                }
//                            })//
//                            .setNegativeButton("否", new DialogInterface.OnClickListener() {
//
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//
//                                }
//                            })//
//                            .create()//
//                            .show();
//                    Looper.loop();
//                }
//            }.start();
//
//        } else {
//
////            UserSessionCache usc=UserSessionCache.getInstance();
////            ObjectOutputStream oos=null;
////            try {
////                oos.writeObject(usc);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////            SharedPreferences prefenPreferences = mainContext
////            .getSharedPreferences("IsMBOPCrash",Activity.MODE_PRIVATE);
////            SharedPreferences.Editor editor = prefenPreferences.edit();
////            editor.clear();
////            editor.putBoolean("ISCRASH", true);
////            editor.commit();
//
//            // 退出程序,重新打开
//            app.AppExit(shekuApp.getApplicationContext());
//            Intent intent = new Intent(shekuApp, StartActivity.class);
////            CoreCommonMethod.setCrash(app, true);
////            intent.putExtra(StartActivity.EXTRA_DIRECT_TO_INDEX, true);
////            intent.putExtra(WelcomeActivity.EXTRA_USERINFO, UserSessionCache.getInstance().getUserInfo());
////            intent.putExtra(WelcomeActivity.EXTRA_CURRENT_PORTAL_ID, UserSessionCache.getInstance().getCurrentPortalId());
////            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            shekuApp.startActivity(intent);
////            android.os.Process.killProcess(android.os.Process.myPid());
//        }
    }
}
