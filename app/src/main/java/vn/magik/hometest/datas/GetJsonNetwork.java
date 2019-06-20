package vn.magik.hometest.datas;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Call API get json from server.
 */
public class GetJsonNetwork extends AsyncTask<String, Void, Object> {
    /**
     * Callback class.
     */
    private ICallbackUpdate iCallbackUpdate;

    /**
     * Constructor.
     * @param iCallbackUpdate class callback
     */
    public GetJsonNetwork(ICallbackUpdate iCallbackUpdate) {
        this.iCallbackUpdate = iCallbackUpdate;
    }

    @Override
    protected Object doInBackground(String... params) {
        BufferedReader bufferedReader = null;
        try {
            String str = params[0];
            URLConnection urlConn;
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            // Read string data
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // Convert string to Object data result
            try {
                return new JSONObject(stringBuilder.toString());
            } catch (JSONException je){
                return new JSONArray(stringBuilder.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object jsonData) {
        super.onPostExecute(jsonData);
        if (jsonData!=null){
            iCallbackUpdate.onSuccess(jsonData);
        } else {
            iCallbackUpdate.onFailed();
        }
    }
}
