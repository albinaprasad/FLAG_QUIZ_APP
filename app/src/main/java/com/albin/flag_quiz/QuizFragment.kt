package com.albin.flag_quiz

import android.graphics.Color
import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.albin.flag_quiz.Database.flagDAO
import com.albin.flag_quiz.databinding.FragmentQuizBinding
import com.albin.flag_quiz.model.flagmodel
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper

class QuizFragment : Fragment() {


    var flagarray= ArrayList<flagmodel>()
    var wrongFlag= ArrayList<flagmodel>()

    var correctNumber=0
    var wrongNumber=0
    var EmptyNumber=0

    var QuestionNumber=0
    var option_control: Boolean=false

    var dao= flagDAO()

    lateinit var quizBinding: FragmentQuizBinding
     lateinit var correctFlag:flagmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        flagarray=dao.getRandomTen(DatabaseCopyHelper(requireActivity()))


        quizBinding= FragmentQuizBinding.inflate(inflater,container,false)


        showData()
        quizBinding.button2.setOnClickListener {

            answerControl(quizBinding.button2)

        }

        quizBinding.button3.setOnClickListener {

            answerControl(quizBinding.button3)
        }

        quizBinding.button4.setOnClickListener {

            answerControl(quizBinding.button4)
        }

        quizBinding.button5.setOnClickListener {

            answerControl(quizBinding.button5)

        }

        quizBinding.nextBtn.setOnClickListener {

            QuestionNumber++


            if(QuestionNumber>9)
            {
                if(!option_control)
                {
                    EmptyNumber++
                }

                val direction= QuizFragmentDirections.actionQuizFragmentToResultFragment().apply {
                    correct=correctNumber
                    wrong=wrongNumber
                    empty=EmptyNumber
                }
                this.findNavController().navigate(
                    R.id.action_quizFragment_to_resultFragment,direction.arguments,
                    NavOptions.Builder().setPopUpTo(R.id.homeFragment,false).build()
                )

            }
            else{
                showData()
                if(!option_control)
                {
                    EmptyNumber++
                    quizBinding.emptyText.setText("$EmptyNumber")
                }
                else{
                    resetButtonProperties(quizBinding.nextBtn)
                }
            }
            option_control=false



        }

        // Inflate the layout for this fragment
        return quizBinding.root
    }
    fun showData()
    {

        quizBinding.textView.setText("Qusetion :${QuestionNumber+1}")
        correctFlag=flagarray[QuestionNumber]
        quizBinding.imageViewflag.setImageResource(resources.getIdentifier(correctFlag.flagName,"drawable",requireActivity().packageName))

        wrongFlag=dao.getRandomThree(DatabaseCopyHelper(requireActivity()),correctFlag.flagid)

        val mixOptions= HashSet<flagmodel>()
        mixOptions.clear()

        mixOptions.add(correctFlag)
        mixOptions.add(wrongFlag[0])
        mixOptions.add(wrongFlag[1])
        mixOptions.add(wrongFlag[2])

        val options= ArrayList<flagmodel>()

        options.clear()

        for (eachFlag in mixOptions){

            options.add(eachFlag)
        }


        quizBinding.button2.text=options[0].flagName
        quizBinding.button3.text=options[1].flagName
        quizBinding.button4.text=options[2].flagName
        quizBinding.button5.text=options[3].flagName


    }
    fun answerControl(button: Button){

      var  buttonName=button.text.toString()
        var country_name=correctFlag.flagName.toString()

        if (buttonName == country_name){

            correctNumber++
            quizBinding.correctText.text=correctNumber.toString()
            button.setBackgroundColor(Color.GREEN)
        }
        else {

            wrongNumber++
            quizBinding.wrongText.text = wrongNumber.toString()
            button.setBackgroundColor(Color.RED)
            button.setTextColor(Color.WHITE)


            when (country_name) {

                quizBinding.button2.text -> quizBinding.button2.setBackgroundColor(Color.GREEN)
                quizBinding.button3.text -> quizBinding.button3.setBackgroundColor(Color.GREEN)
                quizBinding.button4.text -> quizBinding.button4.setBackgroundColor(Color.GREEN)
                quizBinding.button5.text -> quizBinding.button5.setBackgroundColor(Color.GREEN)
            }
        }

            quizBinding.button2.isClickable=false
            quizBinding.button3.isClickable=false
            quizBinding.button4.isClickable=false
            quizBinding.button5.isClickable=false

            option_control=true
        }

    fun resetButtonProperties(button: Button){

        quizBinding.button2.apply {

            setBackgroundColor(Color.WHITE)
            setTextColor(Color.BLACK)
            isClickable=true
        }

        quizBinding.button3.apply {

            setBackgroundColor(Color.WHITE)
            setTextColor(Color.BLACK)
            isClickable=true
        }

        quizBinding.button4.apply {

            setBackgroundColor(Color.WHITE)
            setTextColor(Color.BLACK)
            isClickable=true
        }
        quizBinding.button5.apply {

            setBackgroundColor(Color.WHITE)
            setTextColor(Color.BLACK)
            isClickable=true
        }
    }


}
