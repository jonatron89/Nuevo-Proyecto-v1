package com.poli.pruebapp.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.poli.pruebapp.R
import com.poli.pruebapp.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val view = binding.root

        val videoView : VideoView = view.findViewById(R.id.video)
        videoView.setVideoPath("android.resource://" + requireContext().packageName + "/" + R.raw.n1)
        videoView.start()
        MediaController (requireContext()).also {videoView
            it.setAnchorView(videoView)
            it.setMediaPlayer(videoView)
            videoView.setMediaController(it)
        }


        return view


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}