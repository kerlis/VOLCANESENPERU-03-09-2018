package peru.volcanes.volcanesper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.ArrayList;
public class Listadoredessociales extends FragmentActivity implements RecyclerViewAdapter.ItemListener {
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    ArrayList<DataModel> arrayList;
    ArrayList<DataModel> arrayList2;
    ImageView sliderz;
    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private CharSequence mDrawerTitle;
    private String[] mNavigationDrawerItemTitles;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerBlock;
    Toolbar toolbar;
    RelativeLayout blocke1a;
    RelativeLayout blocke2a;
    RelativeLayout blocke3a;
    RelativeLayout blocke4a;
    RelativeLayout blocke5a;
    RelativeLayout blocke9;
    RelativeLayout blocke6a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redessociales);
        sliderz = (ImageView) findViewById(R.id.sliderz);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerBlock = (RelativeLayout) findViewById(R.id.mDrawerBlock);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
        sliderz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);

        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Listadoredessociales.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Listadoredessociales.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Listadoredessociales.this,Configuraciones.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Listadoredessociales.this,Convenciones.class);
                startActivity(intent);
            }
        });


        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Listadoredessociales.this,Listadoredessociales.class);
                startActivity(intent);
            }
        });

        blocke6a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("FACEBOOK", R.drawable.facebookicon, R.drawable.facebookicon));
        arrayList.add(new DataModel("TWITTER", R.drawable.twittericon, R.drawable.twittericon));

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        arrayList2 = new ArrayList<>();
        arrayList2.add(new DataModel("FACEBOOK ", R.drawable.facebookicon, R.drawable.facebookicon));
        arrayList2.add(new DataModel("TWITTER ", R.drawable.twittericon, R.drawable.twittericon));
        arrayList2.add(new DataModel("YOUTUBE ", R.drawable.youtubeicon, R.drawable.youtubeicon));
        arrayList2.add(new DataModel("INSTAGRAM ", R.drawable.instagramicon, R.drawable.instagramicon));
        arrayList2.add(new DataModel("LINKEDIN ", R.drawable.linkedinicon, R.drawable.linkedinicon));

        //arrayList.add(new DataModel("NUESTROS PRODUCTOS ", R.drawable.three_d, R.drawable.iconoreloj));
        //arrayList.add(new DataModel("NOTICIAS", R.drawable.terraria, R.drawable.iconosismo));

        /*
        arrayList.add(new DataModel("Sismos", R.drawable.battle, "#73000000" ));
        arrayList.add(new DataModel("Volcanes", R.drawable.beer, "#800D0000"));
        arrayList.add(new DataModel("ATMOSFERA", R.drawable.ferrari, "#73000000"));
        arrayList.add(new DataModel("HUAYCOS", R.drawable.jetpack_joyride, "#73000000"));
        arrayList.add(new DataModel("CLIMA ", R.drawable.three_d, "#73000000"));
 */

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(this, arrayList2, this);
        recyclerView2.setAdapter(adapter2);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


        AutoFitGridLayoutManager layoutManager2 = new AutoFitGridLayoutManager(this, 500);
        recyclerView2.setLayoutManager(layoutManager2);

        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/
    }

    @Override
    public void onItemClick(DataModel item) {
       String valor = String.valueOf(item.text);
        Toast.makeText(getApplicationContext(), item.text, Toast.LENGTH_SHORT).show();
        if(valor  == "YOUTUBE"){
            openDetailActivity("https://www.youtube.com/igp_videos","IGP Youtube");
        }
        else if(valor  == "TWITTER"){
            openDetailActivity("http://twitter.com/#!/Sismos_Peru_IGP", "IGP CENSIS Twitter");
        }
        else if(valor  == "FACEBOOK"){
            openDetailActivity("http://www.facebook.com/sismosperuigp","IGP CENSIS Facebook");
        }

        if(valor  == "YOUTUBE "){
            openDetailActivity("https://www.youtube.com/igp_videos","IGP Youtube");
        }
        else if(valor  == "TWITTER "){
            openDetailActivity("https://twitter.com/igp_peru", "IGP Twitter");
        }
        else if(valor  == "FACEBOOK "){
            openDetailActivity("http://www.facebook.com/igp.peru","IGP Facebook");
        }
        else if(valor  == "INSTAGRAM "){
            openDetailActivity("https://www.instagram.com/igp.peru/", "IGP Instagram");
        }
        else if(valor  == "LINKEDIN "){
            openDetailActivity("https://www.linkedin.com/company/igpperu/", "IGP Linkedin");
        }
        else{

        }
    }


    public void onItemClick(DataModel2 item) {
        String valor = String.valueOf(item.text);
        Toast.makeText(getApplicationContext(), item.text, Toast.LENGTH_SHORT).show();
        if(valor  == "YOUTUBE"){
            openDetailActivity("https://www.youtube.com/igp_videos","IGP Youtube");
        }
        else if(valor  == "TWITTER"){
            openDetailActivity("https://twitter.com/igp_peru", "IGP Twitter");
        }
        else if(valor  == "FACEBOOK"){
            openDetailActivity("http://www.facebook.com/igp.peru","IGP Facebook");
        }

        else if(valor  == "INSTAGRAM"){
            openDetailActivity("https://www.instagram.com/igp.peru/", "IGP Instagram");
        }

        else if(valor  == "LINKEDIN"){
            openDetailActivity("https://www.linkedin.com/company/igpperu/", "IGP Linkedin");
        }
        else{
        }

    }


    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }

    private void openDetailActivity(String...details) {
        Intent i=new Intent(Listadoredessociales.this,Contenedorredsocial.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("NOMBRE",details[1]);

        Listadoredessociales.this.startActivity(i);
    }
}