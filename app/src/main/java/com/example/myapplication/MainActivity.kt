package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.btnNavi.setOnClickListener {
            //메뉴 아이콘을 눌렀을 때, 네비게이션이 열리는 기능
            binding.layoutDrawer.openDrawer(GravityCompat.START)
            //START = 왼쪽, END = 오른쪽
            //START : 왼쪽에서 시작해서 밀어라
            //END : 오른쪽에서 시작해서 밀어라
        }
        binding.naviView.setNavigationItemSelectedListener(this)
        //네이게이션 메뉴 속의 아이템들에 클릭 속성을 부여하는 것
        //naviView 자체가 NaviView이기 때문에 저런 메서드가 있서 !
        
        
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //열려있는 네이게이션 메뉴에 있는 각 아이템 클릭 시 수행할 것
        when(item.itemId){
            //navi_menu.xml의 각 아이템 클릭시 item의 id를 가져온다 
            R.id.access-> Toast.makeText(applicationContext,"접근성",Toast.LENGTH_SHORT).show()
            R.id.email-> Toast.makeText(applicationContext,"이메일",Toast.LENGTH_SHORT).show()
            R.id.message-> Toast.makeText(applicationContext,"메시지",Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers()
        //네비게이션의 각 아이템에 클릭되고 난 후에, 네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer.closeDrawers()
            //네비게이션이 열려있는 경우 --> 백버튼 : navi 퇴각
        }
        else{

            super.onBackPressed()
        //네비게이션이 열려있지 않은 경우 --> 백버튼 : app 종료
        }
    }
}