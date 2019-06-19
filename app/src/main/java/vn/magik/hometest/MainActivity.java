package vn.magik.hometest;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import vn.magik.hometest.adapters.CategoryAdapter;
import vn.magik.hometest.adapters.KeyHotAdapter;
import vn.magik.hometest.adapters.ServicesAdapter;
import vn.magik.hometest.helpers.CalculatorTextHelper;
import vn.magik.hometest.helpers.CreateDataHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewServices, mRecyclerViewCategory, mRecyclerViewKeyHot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        createViewServices();
        createViewCategory();
        createViewKeyHot();
    }

    private void initView(){
        mRecyclerViewServices = findViewById(R.id.recycler_view_services);
        mRecyclerViewCategory = findViewById(R.id.recycler_view_category);
        mRecyclerViewKeyHot = findViewById(R.id.recycler_view_key_hot);

    }

    private void createViewServices(){
        ServicesAdapter servicesAdapter = new ServicesAdapter(this, CreateDataHelper.getDataServices());
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewServices.setLayoutManager(layoutManager);
        mRecyclerViewServices.setAdapter(servicesAdapter);
        ViewCompat.setNestedScrollingEnabled(mRecyclerViewServices, false);
    }

    private void createViewCategory(){
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, CreateDataHelper.getDataCategory());
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewCategory.setLayoutManager(layoutManager);
        mRecyclerViewCategory.setAdapter(categoryAdapter);
        ViewCompat.setNestedScrollingEnabled(mRecyclerViewCategory, false);
    }

    private void createViewKeyHot(){
        KeyHotAdapter keyHotAdapter = new KeyHotAdapter(this, CalculatorTextHelper.splitWord(CreateDataHelper.getKeyHot()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewKeyHot.setLayoutManager(layoutManager);
        mRecyclerViewKeyHot.setAdapter(keyHotAdapter);
        ViewCompat.setNestedScrollingEnabled(mRecyclerViewKeyHot, false);
    }

}
