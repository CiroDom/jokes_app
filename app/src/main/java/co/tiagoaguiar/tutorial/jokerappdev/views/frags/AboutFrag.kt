package co.tiagoaguiar.tutorial.jokerappdev.views.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.BuildConfig
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.databinding.FragAboutBinding

class AboutFrag : Fragment() {

    private val binding by lazy {
        FragAboutBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtVersion = binding.txtAboutVersion

        txtVersion.text = getString(R.string.build_version, BuildConfig.VERSION_NAME)
    }
}