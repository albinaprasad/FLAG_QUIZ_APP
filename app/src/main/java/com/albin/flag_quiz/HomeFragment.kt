package com.albin.flag_quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.albin.flag_quiz.databinding.FragmentHomeBinding
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper


class HomeFragment : Fragment() {

lateinit var fragmentBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentBinding= FragmentHomeBinding.inflate(inflater,container,false)

        createAndOpenDatabse()



        fragmentBinding.button.setOnClickListener{


            val direction= HomeFragmentDirections.actionHomeFragmentToQuizFragment()
            this.findNavController().navigate(direction)

        }

        // Inflate the layout for this fragment
        return fragmentBinding.root
    }

    fun createAndOpenDatabse(){

        try {
            var helper = DatabaseCopyHelper(activity)
            helper.createDataBase()
            helper.openDataBase()
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
    }


}