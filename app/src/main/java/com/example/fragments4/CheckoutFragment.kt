package com.example.fragments4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutFragment : Fragment() {
    private var quantity = 1
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val productImage:ImageView = view.findViewById(R.id.image)
//        val productName:TextView = view.findViewById(R.id.name)
        val productPrice:TextView = view.findViewById(R.id.price)
        val orderTotal:TextView = view.findViewById(R.id.order_total)
        val quant:TextView = view.findViewById(R.id.quantity)
        val checkOut: Button = view.findViewById(R.id.checkout)
        val reduce:Button = view.findViewById(R.id.reduce_quantity)
        val increase:Button = view.findViewById((R.id.add_quantity))

        var product:Product? = null
//        val id = arguments?.getInt("ID")
//        id?.let{
//            product = products.find{it.id == id}
//        }
        arguments?.let{
            val args = CheckoutFragmentArgs.fromBundle(it)
            product = products.find{args.id == it.id}
        }
        product?.let{
            with(it){
//                productName.text = name
                productPrice.text = "Price: Rs$price"
                orderTotal.text = "Order Total: Rs$price"
                productImage.setImageResource(imageId)

                checkOut.setOnClickListener {
//                    val bundle = Bundle()
//                    bundle.putInt("ID",this.id)
//                    findNavController().navigate(R.id.action_checkout_to_thanks, bundle )
                    findNavController().navigate(CheckoutFragmentDirections.actionCheckoutToThanks(this.id))

                }
            }
        }
        increase.setOnClickListener{
            quantity++
            quant.text = "QTY: $quantity"
        }
        reduce.setOnClickListener {
            if(quantity>1){
                quantity--
                quant.text = "QTY: $quantity"
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}