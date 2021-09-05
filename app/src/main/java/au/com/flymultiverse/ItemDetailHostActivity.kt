package au.com.flymultiverse

import android.os.Bundle
import au.com.flymultiverse.databinding.ActivityItemDetailBinding
import dagger.android.support.DaggerAppCompatActivity

class ItemDetailHostActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
