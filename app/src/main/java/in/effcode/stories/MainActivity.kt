package `in`.effcode.stories

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: GoogleNewsViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private var urlList: MutableList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        urlList.add("https://m.femina.in/wellness/amp-stories/7-easy-ways-to-be-consistent-with-fitness-and-health-195096.amp")
        urlList.add("https://www.cntraveller.in/web-stories/ritz-ahmedabads-first-luxury-hotel-nostalgia/")
        urlList.add("https://spicytamarind.com.au/web-stories/ridge-gourd-peel-chutney-story/")
        urlList.add("https://magalic.com/web-stories/pottery-process")

        viewPager = findViewById(R.id.view_pager_news)
        adapter = GoogleNewsViewPagerAdapter(this@MainActivity, urlList)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })
    }
}