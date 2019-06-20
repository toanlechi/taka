package vn.magik.hometest.datas;

/**
 * Callback when call asyncTask.
 */
public interface ICallbackUpdate {
    /**
     * Call when get data success.
     *
     * @param object JSONObject data
     */
    void onSuccess(Object object);

    /**
     * Call when get data fail.
     */
    void onFailed();
}
