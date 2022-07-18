package com.saphrena.Java;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author rehe
 * @date 2022年0716日
 * https://www.jb51.net/article/214839.htm
 */
public class Remind{

    public static void main(String[] args){
        try {
            List<Map<String, String>> list = readTxt();
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> map = list.get(i);
                String time = map.get("time");
                String msg = map.get("msg");
                String[] split = time.split(":");
                //获取时、分、秒
                int hour = Integer.parseInt(split[0]);
                int minute = Integer.parseInt(split[1]);
                int second = Integer.parseInt(split[2]);
                cacheTimer(hour,minute,second,msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void cacheTimer(int hour,int minute,int second,String msg){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hour);// 时
            calendar.set(Calendar.MINUTE, minute);// 分
            calendar.set(Calendar.SECOND, second);// 秒

            Timer timer = new Timer();
            //schedule(TimerTask task, Date time)：安排在指定的时间执行指定的任务。
            timer.schedule(new TimerTask(){
                public void run(){
                    //创建一个窗体，设置窗体置顶
                    JFrame jf = new JFrame();
                    jf.setAlwaysOnTop(true);
                    //设置提醒信息的字体样式
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", 1, 18)));
                    //一个警告弹窗,因为要将弹窗置顶，所以创建一个JFrame 添加到这里，2 代表的是这个弹窗是警告弹窗
                    JOptionPane.showMessageDialog(jf, msg, "提醒", 2);
                }
            }, calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取文本内容：Remind.txt 里面就是设置要提示的时间和提醒信息
     */
    private static List< Map<String,String>> readTxt() throws IOException {
        // Remind.txt 要是可以更改的，如果放在项目里，打包了之后就不能更改了，就无法设置了
        String path = System.getProperty("user.dir");//jar包或exe程序所在目录名
        InputStreamReader fReader = new InputStreamReader(new FileInputStream(path+"/Remind.txt"),"UTF-8");
        BufferedReader reader = new BufferedReader(fReader);
        String lineTxt=null;
        List< Map<String,String>> list = new ArrayList<>();
        while((lineTxt=reader.readLine())!=null){
            //以“||”进行分割
            String[] split = lineTxt.split("\\|\\|");
            Map<String,String> map = new HashMap<>();
            map.put("time",split[0]);//提醒时间
            map.put("msg",split[1]);//提醒信息
            list.add(map);
        }
        return list;
    }
}
