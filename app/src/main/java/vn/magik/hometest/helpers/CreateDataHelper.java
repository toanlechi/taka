package vn.magik.hometest.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.magik.hometest.R;
import vn.magik.hometest.models.Services;

/**
 * The class simulates retrieving data from the database.
 */
public class CreateDataHelper {
    public static final String URL_KEY_HOT = "https://raw.githubusercontent.com/tikivn/android-home-test/v2/keywords.json";

    /**
     * Get all services.
     *
     * @return list services
     */
    public static List<Services> getDataServices() {
        List<Services> result = new ArrayList<>();
        result.add(new Services(R.drawable.ic_planes, "Vé máy bay"));
        result.add(new Services(R.drawable.ic_life, "Mua bảo hiểm online"));
        result.add(new Services(R.drawable.ic_phone, "Mua thẻ điện thoại"));
        result.add(new Services(R.drawable.ic_game, "Mua thẻ game"));
        return result;
    }

    /**
     * Get all category.
     *
     * @return list category
     */
    public static List<String> getDataCategory() {
        return Arrays.asList(
                "Mẹ & bé",
                "Sức khoẻ",
                "Điện gia dụng",
                "Dịch vụ",
                "Làm đẹp",
                "Điện tử",
                "Xe máy",
                "Bách hóa",
                "Nhà sách",
                "Thể thao"
        );
    }
}
