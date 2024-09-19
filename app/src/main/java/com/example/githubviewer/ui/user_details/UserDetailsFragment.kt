package com.example.githubviewer.ui.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.githubviewer.databinding.FragmentUserDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailsFragment : Fragment() {

    private val args: UserDetailsFragmentArgs by navArgs()

    private lateinit var binding: FragmentUserDetailsBinding
    private val viewModel: UserDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadUserDetails(args.userName)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        viewModel.userDetails.observe(viewLifecycleOwner) {
            Glide.with(requireContext()).load(it.avatarUrl).into(binding.profileImage)
            binding.tvNameSurname.text = it.fullName
            binding.tvLocation.text = it.location
            binding.tvFollowers.text = it.followers.toString()
            binding.tvFollowing.text = it.following.toString()
            binding.tvBio.text = it.bio ?: "-"
            binding.tvRepository.text = it.publicRepository.toString()
            binding.tvGists.text = it.publicGists.toString()
            binding.tvDate.text = it.updateDate
        }
    }

}