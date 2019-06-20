package vn.magik.hometest;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;

import vn.magik.hometest.adapters.CategoryAdapter;
import vn.magik.hometest.adapters.KeyHotAdapter;
import vn.magik.hometest.adapters.ServicesAdapter;
import vn.magik.hometest.datas.GetJsonNetwork;
import vn.magik.hometest.datas.ICallbackUpdate;
import vn.magik.hometest.helpers.CalculatorTextHelper;
import vn.magik.hometest.helpers.CreateDataHelper;

/**
 * Home screen.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * All recycle_view in view.
     */
    private RecyclerView mRecyclerViewServices, mRecyclerViewCategory, mRecyclerViewKeyHot;
    /**
     * Progress loading keyword.
     */
    private ProgressBar progressBarLoadKeyword;
    private TextView textViewStatusLoadKeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hide toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Init view
        initView();

        // Create view
        createViewServices();
        createViewCategory();
        createViewKeyHot();
    }

    /**
     * Init view.
     */
    private void initView() {
        mRecyclerViewServices = findViewById(R.id.recycler_view_services);
        mRecyclerViewCategory = findViewById(R.id.recycler_view_category);
        mRecyclerViewKeyHot = findViewById(R.id.recycler_view_key_hot);

        progressBarLoadKeyword = findViewById(R.id.progress_load_keyword);
        textViewStatusLoadKeyword = findViewById(R.id.txt_status_loading);
    }

    /**
     * Create view Services.
     */
    private void createViewServices() {
        ServicesAdapter servicesAdapter = new ServicesAdapter(this,
                CreateDataHelper.getDataServices());
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewServices.setLayoutManager(layoutManager);
        mRecyclerViewServices.setAdapter(servicesAdapter);
        ViewCompat.setNestedScrollingEnabled(mRecyclerViewServices, false);
    }

    /**
     * Create view Category.
     */
    private void createViewCategory() {
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,
                CreateDataHelper.getDataCategory());
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewCategory.setLayoutManager(layoutManager);
        mRecyclerViewCategory.setAdapter(categoryAdapter);
        ViewCompat.setNestedScrollingEnabled(mRecyclerViewCategory, false);
    }

    /**
     * Create view KeyHot.
     */
    private void createViewKeyHot() {
        GetJsonNetwork getJsonNetwork = new GetJsonNetwork(new ICallbackUpdate() {
            @Override
            public void onSuccess(Object object) {
                //Update view
                progressBarLoadKeyword.setVisibility(View.GONE);
                mRecyclerViewKeyHot.setVisibility(View.VISIBLE);

                // List keyword from server
                List<String> keywordList =  CalculatorTextHelper.convertJSONToListKeyword(object);

                // Set data into recycler_view
                KeyHotAdapter keyHotAdapter = new KeyHotAdapter(MainActivity.this,
                        CalculatorTextHelper.formatWord(keywordList));
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                        LinearLayoutManager.HORIZONTAL, false);
                mRecyclerViewKeyHot.setLayoutManager(layoutManager);
                mRecyclerViewKeyHot.setAdapter(keyHotAdapter);
                ViewCompat.setNestedScrollingEnabled(mRecyclerViewKeyHot, false);
            }

            @Override
            public void onFailed() {
                //Update view when get data error
                progressBarLoadKeyword.setVisibility(View.GONE);
                mRecyclerViewKeyHot.setVisibility(View.GONE);
                textViewStatusLoadKeyword.setVisibility(View.VISIBLE);
                textViewStatusLoadKeyword.setText(R.string.hot_load_error);
            }
        });
        getJsonNetwork.execute(CreateDataHelper.URL_KEY_HOT);
    }
}
