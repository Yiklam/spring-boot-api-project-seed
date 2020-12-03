package com.company.project.bot;

//import com.company.project.configurer.WebMvcConfigurer;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.net.www.http.HttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class Jobs {

     private Logger log = LoggerFactory.getLogger(Jobs.class);

     private String words[] = new String[]{"宝贝儿，别忘了喝水啦。" ,"静宝贝，该喝水啦。" ,"亲爱的，到时间喝水啦。","静宝宝，喝水啦。","小甜甜，一大杯水走起。","亲亲，喝水水啦。"};
     private String face[] = new String[]{"・ω・" ,"o(*≧▽≦)ツ" ,"⁄(⁄ ⁄•⁄ω⁄•⁄ ⁄)⁄","（づ￣3￣）づ","๑¯◡¯๑"};


    @Scheduled(cron="* * * * * ?")
    public void breathe(){
        log.info("Bot breathe...");
    }

    @Scheduled(cron="0 0 9,11,15,17,19,21 * * ?")
//    @Scheduled(cron="* * * * * ?")
    public void send() throws IOException {

        Random random1 = new Random();
        random1.nextInt(3);
        int i1 = random1.nextInt(3);

        Random random2 = new Random();
        random2.nextInt(3);
        int i2 = random2.nextInt(3);

        String sendStr = face[i1]+words[i2];
        log.info(sendStr);

        //1.获得一个httpclient对象
        CloseableHttpClient httpclient1 = HttpClients.createDefault();
        //2.生成一个get请求
        HttpPost post1 = new HttpPost("https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage"); //这里用上本机的某个工程做测试
        //创建参数列表
        List<NameValuePair> list1 = new ArrayList<NameValuePair>();
        list1.add(new BasicNameValuePair("text", sendStr));
        list1.add(new BasicNameValuePair("chat_id", "809538155"));
        //url格式编码
        UrlEncodedFormEntity uefEntity1 = new UrlEncodedFormEntity(list1, "UTF-8");
        post1.setEntity(uefEntity1);
        log.info("post:{}",post1.getURI());
        //执行请求
        //3.执行get请求并返回结果
        CloseableHttpResponse response1 = httpclient1.execute(post1);
        try {
            //4.处理结果
        } finally {
            response1.close();
        }



        //1.获得一个httpclient对象
        CloseableHttpClient httpclient2 = HttpClients.createDefault();
        //2.生成一个get请求
        HttpPost post2 = new HttpPost("https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage"); //这里用上本机的某个工程做测试
        //创建参数列表
        List<NameValuePair> list2 = new ArrayList<NameValuePair>();
        list2.add(new BasicNameValuePair("text", sendStr));
        list2.add(new BasicNameValuePair("chat_id", "561311173"));
        //url格式编码
        UrlEncodedFormEntity uefEntity2 = new UrlEncodedFormEntity(list2, "UTF-8");
        post2.setEntity(uefEntity2);
        log.info("post:{}",post2.getURI());
        //执行请求
        //3.执行get请求并返回结果
        CloseableHttpResponse response2 = httpclient2.execute(post2);
        try {
            //4.处理结果
        } finally {
            response2.close();
        }



    }


//    then
//    curl "https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=561311173&text=${str1}"
//    curl "https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=809538155&text=${str1}"
//    echo "curl https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=561311173&text=${str1}"
//    elif [[ hour -eq 11 ]] || [[ hour -eq 19 ]]
//    then
//    curl "https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=561311173&text=${str2}"
//    curl "https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=809538155&text=${str2}"
//    echo "curl https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=561311173&text=${str2}"
//    elif [[ hour -eq 15  ]] || [[ hour -eq 21 ]]
//    then
//    curl "https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=561311173&text=${str3}"
//    curl "https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=809538155&text=${str3}"
//    echo "curl https://api.telegram.org/bot1070841229:AAFV-8qBcQJVvM7eY2Srv5rKeuYRnPSqUQ4/sendMessage?chat_id=561311173&text=${str3}"

}
