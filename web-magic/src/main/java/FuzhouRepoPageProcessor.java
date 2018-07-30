import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhao.ych
 * @date 2018-07-15
 */
public class FuzhouRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100)
            .setTimeOut(Integer.MAX_VALUE)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    private static List<String> urls = new ArrayList<>();

    private static List<Man> list = new ArrayList<>();

    private volatile boolean flag = false;

//    private AtomicInteger integer = new AtomicInteger(1);

    private Integer integer = 1;

    private static File file;

    static {
        file = new File("/Users/chenhaoye/data1.xlsx");
        for (int i = 52; i < 150; i++) {
            urls.add("http://www.fuzhou.ccoo.cn/phonebook/all/pn" + i + "/");
        }
    }

    @Override
    public void process(Page page) {
//        List<String> nameList = page.getHtml().xpath("//span[@class='comp']/a/text()").all();
        List<String> detailUrl = page.getHtml().xpath("//span[@class='comp']/a/@href").all();
//        List<String> phoneList = page.getHtml().xpath("span[@class='phone']/a/text()").all();

        page.addTargetRequests(detailUrl);


        if (!page.getUrl().regex("all").match()) {
            String name = page.getHtml().xpath("//div[@class='con f14 fa']/h1/text()").toString();
            List<String> all = page.getHtml().xpath("//div[@class='con f14 fa']/strong/text()").all();
            String phone;
            String address = "";
            if (all.get(0).trim().equals("") || all.get(0) == null) {
                phone = all.get(1);
            } else {
                phone = all.get(0);
            }
            if (all.size() > 2) {
                address = all.get(2);
            }
            try {
                System.out.println("name =" + name);
                Man man = new Man(name, phone, address);
                list.add(man);
                PoiUtils.write(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        page.putField("name", page.getHtml().xpath("//span[@class='comp']/a/text()").toString());
//        page.putField("detailUrl", page.getHtml().xpath("//span[@class='comp']/a/@href").toString());
//        page.putField("phone", page.getHtml().xpath("span[@class='phone']/a/text()").toString());

//        if (integer < 5664) {
//            page.addTargetRequest("http://www.fuzhou.ccoo.cn/phonebook/all/pn" + integer + "/");
//            integer ++;
//        }
        if (!flag) {
            page.addTargetRequests(urls);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                new Proxy("101.96.10.58",8088)));
        Spider.create(new FuzhouRepoPageProcessor())
                .setDownloader(httpClientDownloader)
                .addUrl("http://www.fuzhou.ccoo.cn/phonebook/all/pn51/")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

    public static class Man {

        private String name;

        private String phone;

        private String address;

        public Man(String name, String phone, String address) {
            this.name = name;
            this.phone = phone;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

}
