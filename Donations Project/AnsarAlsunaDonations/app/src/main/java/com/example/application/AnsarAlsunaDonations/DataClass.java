package com.example.application.AnsarAlsunaDonations;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Yaseen on 13/01/2017.
 */

public class DataClass {
    private static String MY_STRING_PREF = "mystringpref";
    private static String MY_INT_PREF = "shareduserid";

    private static String Hour="hour";
    private static String Minute="minute";
    private static String SudaniNum="sudaninum";
    private static String ZainNum="zainnum";
    private static String ZainPUK="zainpuk";
    private static String MTNNum="mtnnum";
    private static String Amount="amount";
    private static String UserISP="userisp";
    private static String ServiceState="servicestate";
    private static String ServiceState2="servicestate2";

    private static String UserDeviceType="userdevicetype";
    private static String UserSelectedSlot="userselectedslot";



    public static SharedPreferences getPrefs(Context context) {


        return context.getSharedPreferences("UserNameAcrossApplication", MODE_PRIVATE);

    }

    public static String getMyStringPref(Context context) {

        return getPrefs(context).getString(MY_STRING_PREF, "default");
    }

    public static int getMyIntPref(Context context) {

        return getPrefs(context).getInt(MY_INT_PREF, 0);
    }

    public static void setMyStringPref(Context context, String value) {
        // perform validation etc..
        getPrefs(context).edit().putString(MY_STRING_PREF, value).commit();
    }

    public static void setMyIntPref(Context context, int value) {
        // perform validation etc..
        getPrefs(context).edit().putInt(MY_INT_PREF, value).commit();
    }
    public static int getHour(Context context)
    {
        return getPrefs(context).getInt(Hour,-1);
    }
    public static void setHour(Context context,int value)
    {
        getPrefs(context).edit().putInt(Hour,value).commit();
    }
    public static int getMinute(Context context)
    {
        return getPrefs(context).getInt(Minute,-1);
    }
    public static void setMinute(Context context,int value)
    {
        getPrefs(context).edit().putInt(Minute,value).commit();
    }
    public static String getSudaniNum(Context context)
    {
        return getPrefs(context).getString(SudaniNum,"default");
    }
    public static void setSudaniNum(Context context,String value)
    {
        getPrefs(context).edit().putString(SudaniNum,value).commit();
    }
    public static String getZainNum(Context context)
    {
        return getPrefs(context).getString(ZainNum,"default");
    }

    public static void setZainNum(Context context,String value)
    {
        getPrefs(context).edit().putString(ZainNum,value).commit();
    }
    public static String getZainPUK(Context context)
    {
        return getPrefs(context).getString(ZainPUK,"default");
    }

    public static void setZainPUK(Context context,String value)
    {
        getPrefs(context).edit().putString(ZainPUK,value).commit();
    }
    public static String getMTNNum(Context context)
    {
        return getPrefs(context).getString(MTNNum,"default");
    }
    public static void setMTNNum(Context context,String value)
    {
        getPrefs(context).edit().putString(MTNNum,value).commit();
    }

    public static String getAmount(Context context)
    {
        return getPrefs(context).getString(Amount,"default");

    }
    public static void setAmount(Context context,String value)
    {
        getPrefs(context).edit().putString(Amount,value).commit();
    }
    public static int getUserISP(Context context)
    {
        return getPrefs(context).getInt(UserISP,-1);
    }
    public static void setUserISP(Context context,int value)
    {
        getPrefs(context).edit().putInt(UserISP,value).commit();
    }
    public static boolean getServiceState(Context context)
    {
        return getPrefs(context).getBoolean(ServiceState,false);//false means service is not running
    }
    public static void setServiceState(Context context,boolean value)
    {
        /*if(value)
            Toast.makeText(context,"service is set to (running)",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"service is set to (stop)",Toast.LENGTH_LONG).show();*/
        getPrefs(context).edit().putBoolean(ServiceState,value).commit();
    }
    public static boolean getUserDeviceType(Context context)
    {
        return getPrefs(context).getBoolean(UserDeviceType,true);//true means first selection
    }
    public static void setUserDeviceType(Context context,boolean value)
    {
        getPrefs(context).edit().putBoolean(UserDeviceType,value).commit();
    }
    public static boolean getUserSelectedSlot(Context context)
    {
        return getPrefs(context).getBoolean(UserSelectedSlot,true);//true means first selection
    }
    public static void setUserSelectedSlot(Context context,boolean value)
    {
        getPrefs(context).edit().putBoolean(UserSelectedSlot,value).commit();
    }
    public static void setServiceState2(Context context,int value)
    {
        getPrefs(context).edit().putInt(ServiceState2,value);
    }
    public static int getServiceState2(Context context)
    {
        return getPrefs(context).getInt(ServiceState2,-1);
    }

}
