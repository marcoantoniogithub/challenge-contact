package com.picpay.desafio.android.feature.contacts.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.databinding.FragmentUserListBinding
import com.picpay.desafio.android.feature.contacts.presentation.Adapter.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment() : Fragment() {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserListViewModel by viewModel()

    lateinit var adapter: UserListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUsers()
        observers()
        configView()
    }

    private fun configView() {
        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun observers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            if(it.loading) {
                binding.userListProgressBar.visibility = View.VISIBLE
            } else {
                binding.userListProgressBar.visibility = View.GONE
            }

            if(it.messageError != "") {
                binding.userListProgressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.GONE

                Toast.makeText(context, it.messageError, Toast.LENGTH_SHORT)
                    .show()
            }

            if(it.listUser.isNotEmpty()) {
                binding.userListProgressBar.visibility = View.GONE
                adapter.users = it.listUser
            }
        }
    }
}