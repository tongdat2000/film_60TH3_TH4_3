package com.congnghephanmem.filmhay.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.congnghephanmem.filmhay.Adapter.RecyclerAnimeAdapter;
import com.congnghephanmem.filmhay.Adapter.RecyclerDanhMucAdapter;
import com.congnghephanmem.filmhay.Interface.InterfaceAnime;
import com.congnghephanmem.filmhay.Interface.InterfaceDanhMuc;
import com.congnghephanmem.filmhay.Model.DanhMuc;
import com.congnghephanmem.filmhay.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

//    @BindView(R.id.imgSlide)
//    ImageSlider imgSlide;

    List<SlideModel> slideModels;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @BindView(R.id.recyler_danh_muc)
    RecyclerView recyclerView;
    RecyclerDanhMucAdapter recyclerDanhMucAdapter;
    ArrayList<DanhMuc> danhMucArrayList;
    @BindView(R.id.recyler_anime_hot)
    RecyclerView recyclerViewAnime;
    ArrayList<DanhMuc> animeHotArray;
    RecyclerAnimeAdapter recyclerAnimeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imgSlide = (ImageSlider) view.findViewById(R.id.imgSlide);
        slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/7d/c2/7d/7dc27da9630a0904b20fe876e058baf2.jpg","Mushoku tensei: isekai ittara honki dasu"));
        slideModels.add(new SlideModel("https://1.bp.blogspot.com/-PnPJYR7Vn-M/YA0Vt5n_OtI/AAAAAAAAFsQ/4663lXMT2hkLSc-rIpQJcH_iO9iqYIt1ACLcBGAsYHQ/s1600/5ffd804958ddd857b64afe8f_Slime-Datta-Ken-ss2-3.jpg","Slime chuyển sinh"));
        slideModels.add(new SlideModel("https://www.fullphim.net/static/5fe2d564b3fa6403ffa11d1c/5fe2d564b3fa64bb09a12fa4_chuyen-tau-vo-tan-5.jpg", "Chuyến tàu vô tận"));
        imgSlide.setImageList(slideModels,true);

        ButterKnife.bind(this, view);
        danhMucArrayList = new ArrayList<>();
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Hành động"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Phép thuật"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Isekai"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Đời thường"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Harem"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Học đường"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Thể thao"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Phiêu lưu"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Kinh dị"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Hài hước"));
        danhMucArrayList.add(new DanhMuc(R.drawable.hanhdong,"Tình cảm"));

        recyclerDanhMucAdapter = new RecyclerDanhMucAdapter(danhMucArrayList, getContext(), new InterfaceDanhMuc() {
            @Override
            public void click(int position) {

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerDanhMucAdapter);

        animeHotArray = new ArrayList<>();
        animeHotArray.add(new DanhMuc(R.drawable.kimetsu_no_yaiba, "Kimetsu No Yaiba"));
        animeHotArray.add(new DanhMuc(R.drawable.kimetsu_no_yaiba_mugen_train,"Mugen Train"));
        animeHotArray.add(new DanhMuc(R.drawable.naruto_shipuden, "Naruto shipuden"));
        animeHotArray.add(new DanhMuc(R.drawable.onepiece, "One piece"));
        animeHotArray.add(new DanhMuc(R.drawable.mushoku_tensei, "Mushoku Tensei"));
        animeHotArray.add(new DanhMuc(R.drawable.naruto, "Naruto"));
        animeHotArray.add(new DanhMuc(R.drawable.slime, "Slime chuyển sinh"));
        recyclerAnimeAdapter = new RecyclerAnimeAdapter(getContext(), animeHotArray, new InterfaceAnime() {
            @Override
            public void onClick(int positon) {

            }
        });

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerViewAnime.setLayoutManager(linearLayoutManager1);
        recyclerViewAnime.setAdapter(recyclerAnimeAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy");
    }

}