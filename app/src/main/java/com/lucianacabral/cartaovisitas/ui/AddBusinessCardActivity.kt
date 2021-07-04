package com.lucianacabral.cartaovisitas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lucianacabral.cartaovisitas.App
import com.lucianacabral.cartaovisitas.R
import com.lucianacabral.cartaovisitas.data.BusinessCard
import com.lucianacabral.cartaovisitas.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add_business_card)
        setContentView(binding.root)
        insertListeners()

    }

    private fun insertListeners() {
        binding.btnConfirmar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNomeTxt.editText?.text.toString(),
                telefone = binding.tilTelefoneTxt.editText?.text.toString(),
                email = binding.tilEmailTxt.editText?.text.toString(),
                empresa = binding.tilEmpresaTxt.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}
