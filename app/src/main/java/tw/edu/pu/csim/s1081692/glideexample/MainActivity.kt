package tw.edu.pu.csim.s1081692.glideexample

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestListener

@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img: ImageView = findViewById(R.id.img)
        GlideApp.with(this)
            //.load(R.drawable.earth)
            .load("https://b.blog.xuite.net/b/b/5/2/11519069/blog_78644/txt/243420413/4.jpg")
            .placeholder(R.drawable.processing)
            .error(R.drawable.error)
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    Toast.makeText(baseContext, "圖片載入失敗", Toast.LENGTH_LONG).show()
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                    Toast.makeText(baseContext, "圖片載入成功", Toast.LENGTH_LONG).show()
                    return false
                }

            })
            .circleCrop()
            .override(800, 600)

            .into(img)

    }
}