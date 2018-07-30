import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * @author chenhao.ych
 * @date 2018-07-15
 */
@TargetUrl("http://www.fuzhou.ccoo.cn/phonebook/all/")
public class FuzhouCcoo {

    @ExtractBy("//span[@class='comp']/a/text()")
    private String name;

    @ExtractBy("//span[@class='comp']/a/@href")
    private String detailUrl;

    private String address;

    @ExtractBy("//span[@class='phone']/a/text()")
    private String phone;

    public static void main(String[] args) {
        OOSpider.create(
                Site.me(),
                new ModelPipeline(), FuzhouCcoo.class).addUrl("http://www.fuzhou.ccoo.cn/phonebook/all/").run();

    }

    private static class ModelPipeline implements PageModelPipeline {
        public ModelPipeline() {
        }

        @Override
        public void process(Object o, Task task) {
            FuzhouCcoo ccoo = (FuzhouCcoo)(o);
            System.out.println(ccoo.getName());
            System.out.println(ccoo.getDetailUrl());
            System.out.println(ccoo.getPhone());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
