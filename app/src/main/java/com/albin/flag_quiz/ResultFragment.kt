package com.albin.flag_quiz

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.albin.flag_quiz.databinding.FragmentResultBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class ResultFragment : Fragment() {

lateinit var resultBinding: FragmentResultBinding

var correctNumber=0
    var emptyNumber=0
    var wrongNumber=0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultBinding= FragmentResultBinding.inflate(inflater,container,false)

        val args=arguments?.let{
            ResultFragmentArgs.fromBundle(it)
        }
        args?.let {
            correctNumber=it.correct
            wrongNumber=it.wrong
            emptyNumber=it.empty



        }


        //data for pieChart


        var entries= ArrayList<PieEntry>()
        entries.add(PieEntry(correctNumber.toFloat(),"Correct Answers"))
        entries.add(PieEntry(wrongNumber.toFloat(),"wrong Answers"))
        entries.add(PieEntry(emptyNumber.toFloat(),"Empty Answers"))

        val dataSet= PieDataSet(entries,"Results")
        val colors = arrayListOf<Int>()
        colors.add(Color.GREEN)        // Correct answers - Green
        colors.add(Color.RED)          // Wrong answers - Red
        colors.add(Color.GRAY)
        dataSet.valueTextSize=14f

        dataSet.colors=colors
        val pieData = PieData(dataSet)
        resultBinding.piechart.data = pieData


        resultBinding.piechart.invalidate()



        resultBinding.piechart.animateY(1500)
//quit button
        resultBinding.button6.setOnClickListener {

    requireActivity().finishAffinity()
        }
 //Again button
        resultBinding.button7.setOnClickListener {
            this.findNavController().popBackStack(R.id.homeFragment,false)

        }

        // Inflate the layout for this fragment
        return resultBinding.root
    }



}