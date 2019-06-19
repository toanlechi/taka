package vn.magik.hometest.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.magik.hometest.R;
import vn.magik.hometest.models.Services;

public class CreateDataHelper {
    public static List<Services> getDataServices(){
        List<Services> result = new ArrayList<>();
        result.add(new Services(R.drawable.ic_planes, "Vé máy bay"));
        result.add(new Services(R.drawable.ic_life, "Mua bảo hiểm online"));
        result.add(new Services(R.drawable.ic_phone, "Mua thẻ điện thoại"));
        result.add(new Services(R.drawable.ic_game, "Mua thẻ game"));
        return result;
    }

    public static List<String> getDataCategory(){
        List<String> result = new ArrayList<>();
        result.add("Mẹ & bé");
        result.add("Sức khoẻ");
        result.add("Điện gia dụng");
        result.add("Dịch vụ");
        result.add("Làm đẹp");
        result.add("Điện tử");
        result.add("Xe máy");
        result.add("Bách hóa");
        result.add("Nhà sách");
        result.add("Thể thao");
        return result;
    }

    public static List<String> getKeyHot(){
        return Arrays.asList("xiaomi",
                "bitis hunter",
                "bts",
                "balo",
                "bitis hunter x",
                "tai nghe",
                "harry potter",
                "anker",
                "iphone",
                "balo nữ",
                "nguyễn nhật ánh",
                "đắc nhân tâm",
                "ipad",
                "senka",
                "tai nghe bluetooth",
                "son",
                "maybelline",
                "laneige",
                "kem chống nắng",
                "anh chính là thanh xuân của em");
    }

}
