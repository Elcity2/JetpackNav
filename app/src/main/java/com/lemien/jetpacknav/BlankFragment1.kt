package com.lemien.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.lemien.jetpacknav.databinding.FragmentBlank1Binding




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentBlank1Binding? = null
    private var jetpackNavigationActivity : MainActivity?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jetpackNavigationActivity = activity as MainActivity
        jetpackNavigationActivity?.supportActionBar?.title = "First Fragment"
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(layoutInflater)
        return binding?.root
       // return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnMoveToSecond?.setOnClickListener {
            if (binding?.etName?.text?.toString().isNullOrEmpty()) {
                binding?.etName?.error = resources.getString(R.string.enter_text)
            } else {
                var bundle = Bundle()
                bundle.putString("email", binding?.etName?.text?.toString())
                bundle.putString("otp", "1234")
                findNavController().navigate(
                    R.id.action_blankFragment12_to_blankFragment22,
                    bundle
                )
            }
        }


        binding?.et1?.doOnTextChanged { text, start, before, count ->
            var enteredText = binding?.et1?.text?.toString()
            if (enteredText?.length == 1) {
                binding?.et2?.requestFocus()
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}